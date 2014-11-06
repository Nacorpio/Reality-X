package com.nacorpio.nutilities.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nacorpio.nutilities.conversion.EnumUnit;
import com.nacorpio.nutilities.conversion.Unit;

public final class CommandHandler {

	private static Map<String, ICommand> commands = new HashMap<String, ICommand>();

	static {		
		for (Class<?> var: Unit.class.getClasses()) {
			addMethods(var);
		}
	}
	
	public static final void addMethods(Class<?> par1) {
		for (final Method var: par1.getMethods()) {
			
			// The method's name must be of a specific pattern.
			if (var.getName().matches("(.*?)To(.*?)")) {
				
				// Register the command with the method's name.
				CommandHandler.register(var.getName(), new Command(var.getName()) {	
					
					// Specify what is going to happen when the command is executed.
					public void doWork(Object... par1) {
						
						// Check whether the amount of arguments is exactly 1.
						if (par1.length == 1) {
							try {
								
								// Split the method name so that we can get some data.
								String[] var1 = var.getName().split("To");	
								
								// Get the value that is going to be input to the method.
								float value = Float.parseFloat(String.valueOf(par1[1]));
								
								// Invoke the method with the specified value.
								Object invoke = var.invoke(this, value);
								
								// Put the value from the method above in this variable.
								String var2 = invoke.toString();
								
								// Get the suffixes depending on the name of the method.
								EnumUnit unit = EnumUnit.byName(var1[1]);
								EnumUnit unit1 = EnumUnit.byName(var1[0]);
								
								// Set the description of the method, used in the !help command.
								this.setDescription("Converts the unit " + var1[0].toLowerCase() + " (" + (unit1 != null ? unit1.getSuffix() : "") + ") to " + var1[1].toLowerCase() + " (" + (unit != null ? unit.getSuffix() : "") + ")");
								
								// Check if a unit with that name really exists.
								if (unit != null) {
									var2 += unit.getSuffix();
								}
								
								// Print out the description (for experimental purposes) and value.
								System.out.println(getDescription());
								System.out.println(var2);
								
							}
							
							catch (IllegalAccessException e) {
								e.printStackTrace();
							}
							
							catch (IllegalArgumentException e) {
								e.printStackTrace();
							}
							
							catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						} else {
							
							System.out.println("Error: This command requires exactly 1 argument to function.");
							
						}
						
					}			
				});
				
			}
				
		}
	}
	
	/**
	 * Handle the specified input.
	 * @param par1 the input.
	 * @return whether the input was successfully handled.
	 */
	public static final boolean handle(String par1) {
		
		// !<name> <arg1>...
		if (par1.startsWith("!")) {
			
			String var1 = par1.substring(1);
			
			/**
			 * Split with white-space.
			 * There is no need for trimming.
			 */
			String[] var2 = var1.split("(\\s*)?");
			
			if (var2.length >= 1) {
				
				// Check if a command with the specified name exists.
				if (commands.containsKey(var2[0])) {
					
					// Look the command up and then store it in a variable.
					Command var1Command = (Command) get(var2[0]);	
					List<String> var1List = Arrays.asList(var2);

					// Check if the input command has arguments.
					if (var1List.size() > 0) {
						
						// Store the arguments in an array and then execute.
						Object[] var1Array = var1List.toArray();
						var1Command.doWork(var1Array);
						
					} else {
						
						// Execute the command without arguments.
						var1Command.doWork();
						
					}
							
					return true;
					
				} else {
					
					System.out.println("There's no command with that name.");
					return false;
					
				}
				
			}
			
		}	
		
		return false;
		
	}
	
	/**
	 * Register a new command with the specified name.
	 * @param par1 the name.
	 * @param par2 the command.
	 */
	public static final void register(String par1, ICommand par2) {
		if (!commands.containsKey(par1))
			commands.put(par1, par2);
	}
	
	/**
	 * Returns a registered command with the specified name.
	 * @param par1 the name.
	 * @return the command.
	 */
	public static final ICommand get(String par1) {
		return commands.get(par1);
	}
	
}
