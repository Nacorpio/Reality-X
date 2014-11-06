package com.nacorpio.nutilities.format.n;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nacorpio.nutilities.regex.RegularExpression;
import com.nacorpio.nutilities.regex.RegularExpression.Match;

public final class NFormat {

	/**
	 * Represents a variable that has been parsed by the parser.<br>
	 * Depending on the type, it has a different capacity of storing data.<br>
	 * The type of data will be sorted out in the {@link #DataHandler}.
	 * @author Nacorpio
	 *
	 * @param <T> the type of data.
	 */
	public static class Variable {
		
		private String name;
		private Object value;
		private EnumVariableType type = EnumVariableType.NONE;
		
		public Variable(String par1, Object par2, EnumVariableType par3) {
			this.name = par1;
			this.value = par2;
			this.type = par3;
		}
		
		public Variable(String par1, Object par2) {
			this(par1, par2, EnumVariableType.NONE);
		}
		
		public Variable(String par1, EnumVariableType par2) {
			this(par1, null, par2);
		}
		
		public Variable(String par1) {
			this(par1, null, EnumVariableType.NONE);
		}
		
		public Variable(String par1, Object... par2) {
			this(par1, par2, EnumVariableType.NONE);
		}
		
		public Variable(String par1, EnumVariableType par2, Object... par3) {
			this(par1, par3, par2);
		}
		
		/**
		 * Returns the name of the variable.
		 * @return the name.
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * Returns the value of the variable.
		 * @return the value.
		 */
		public Object getValue() {
			return this.value;
		}
		
		/**
		 * Returns the type of the variable.
		 * @return the type.
		 */
		public EnumVariableType getType() {
			return this.type;
		}
		
		@Override
		public Variable clone() {
			return new Variable(name, value);
		}
		
		@Override
		public boolean equals(Object par1) {
			
			if (par1 == null) {
				return false;
			}
			
			if (par1 instanceof Variable) {
				Variable var1 = (Variable) par1;
				return var1.getName().equals(name) &&
					   var1.getValue().equals(value) &&
					   var1.getType().getId() == type.getId();
			}
			
			return par1.equals(this);
			
		}
		
		@Override
		public String toString() {
			return toVarString(name, value, type);
		}
		
	}

	public static final Variable getVariable(String par1, String par2) {
	
		RegularExpression var1 = new RegularExpression("\\$" + par1 + "=?(.*?)?;?");
		List<Match> var2 = var1.getMatches(par1);
		
		if (var2.size() > 0) {
			return new Variable(par1, var2.get(0).group(0).value());
		}
		
		return new Variable(par1);
		
	}
	
	public static final String toVarString(String par1, Object par2, EnumVariableType par3) {
		
		if (par2 == null) {
			if (par3 == EnumVariableType.NONE) {
				return "$" + par1 + ";";
			} 
			return "$" + par3.getFlag() + ":" + par1 + ";";
		}
		
		if (par3 == EnumVariableType.NONE) {
			return "$" + par1 + "=" + toString(par2) + ";";
		}
		
		return "$" + par3.getFlag() + ":" + par1 + "=" + toString(par2) + ";";
		
	}
	
	public static final String toVarString(String par1, EnumVariableType par2) {
		return toVarString(par1, null, par2);
	}
	
	public static final String toVarString(String par1) {
		return toVarString(par1, null, EnumVariableType.NONE);
	}
	
	public static final String toVarString(String par1, Object par2) {
		return toVarString(par1, par2, EnumVariableType.NONE);
	}
	
	public static final Variable toVariable(String par1) {
		
		if (par1.contains("=")) {
			
			String split1 = par1.substring(0, par1.indexOf("=")).substring(1);
			String split2 = par1.substring(par1.indexOf("=") + 1, par1.length()).replace(";", "");
			
			if (split2.startsWith("\"") && split2.endsWith("\"")) {
				
				// "value"
				return new Variable(split1, split2.substring(1, split2.length() - 1));
				
			} else if (split2.startsWith("{") && split2.endsWith("}")) {
			
				// {"", ""}
				String spl1 = split2.substring(1, split2.length() - 1);
			
				if (spl1.contains(",")) {
					
					Object[] array = spl1.split(",\\s?");
					
					for (int i = 0; i < array.length; i++) {
						
						String src = (String) array[i];
						
						if (src.startsWith("\"") && src.endsWith("\"")) {
							
							String part1 = src.substring(1, src.length() - 1);
							array[i] = part1;
							
						}
						
					}
					
					return new Variable(split1, array);
					
				} else {
					
					return new Variable(split1, new Object[] {spl1});
					
				}		
				
			}
			
			return new Variable(split1, split2);
			
		} else {
		
			return new Variable(par1.substring(1, par1.length() - 1));
			
		}
		
	}
	
	public static final String toString(Object par1) {
		
		if (par1 == null) {
			return "null";
		}
		
		if (par1 instanceof String) {
			
			return (par1 == null ? "null" : "\"" + par1 + "\"");
			
		} else if (par1 instanceof Boolean) {
			
			boolean var1 = (boolean) par1;
			return (par1 == null ? "null" : String.valueOf(var1));
			
		} else if (par1 instanceof Integer) {
			
			int var1 = (int) par1;
			return (par1 == null ? "null" : String.valueOf(var1));
			
		} else if (par1 instanceof Float) {
			
			float var1 = (float) par1;
			return (par1 == null ? "null" : String.valueOf(var1) + "F");
			
		} else if (par1 instanceof Double) {
			
			double var1 = (double) par1;
			return (par1 == null ? "null" : String.valueOf(var1) + "D");
			
		} else if (par1 instanceof Long) {
			
			long var1 = (long) par1;
			return (par1 == null ? "null" : String.valueOf(var1) + "L");
			
		} else if (par1 instanceof Short) {
			
			short var1 = (short) par1;
			return (par1 == null ? "null" : String.valueOf(var1) + "S");
			
		} else if (par1 instanceof Collection) {
			
			Collection<?> var1 = (Collection<?>) par1;
			String var2 = "<";
			
			for (int i = 0; i < var1.size(); i++) {
				
				Object varObject1 = var1.toArray()[i];
				
				if (i < var1.size() - 1) {
					var2 += (varObject1 == null ? "null" : toString(varObject1)) + ", ";
				} else {
					var2 += (varObject1 == null ? "null" : toString(varObject1)) + ">";
				}
				
			}
			
			return var2;
			
		} else if (par1 instanceof Object[]) {
			
			Object[] var1 = (Object[]) par1;
			String var2 = "{";
			
			for (int i = 0; i < var1.length; i++) {
				
				Object varObject1 = var1[i];
				
				if (i < var1.length - 1) {
					var2 += (varObject1 == null ? "null" : toString(varObject1)) + ", ";
				} else {
					var2 += (varObject1 == null ? "null" : toString(varObject1)) + "}";
				}
				
			}
			
			return var2;
			
		} else if (par1 instanceof Map<?, ?> || par1 instanceof HashMap<?, ?>) {
			
			Map<?, ?> var1 = (HashMap<?, ?>) par1;
			String var2 = "Map[";
			
			for (int i = 0; i < var1.size(); i++) {
				
				Object key = var1.keySet().toArray()[i];
				Object val = var1.values().toArray()[i];
				
				// {"key", "value"}
				String src = "{" + (key == null ? "null" : toString(key)) + ", " + (val == null ? "null" : toString(val)) + "}";
				
				if (i < var1.size() - 1) {
					var2 += src + ", ";
				} else {
					var2 += src + "]";
				}
				
			}
			
			// Map[{"key1", "value1"}, {"key2", "value2"}]
			return var2;
			
		} else if (par1 instanceof Annotation) {
			
			Annotation var1 = (Annotation) par1;
			Map<String, Object> prop = new HashMap<String, Object>();
			
			prop.put("type", var1.annotationType());
			
		} else if (par1 instanceof Class<?>) {
			
			Class<?> var1 = (Class<?>) par1;
			String var2 = "JClass[";
			
			Map<String, Object> prop = new HashMap<String, Object>();
			
			prop.put("name", var1.getName());
			prop.put("simpleName", var1.getSimpleName());
			prop.put("canonicalName", var1.getCanonicalName());
			prop.put("modifiers", var1.getModifiers());
			prop.put("isAnnotation", var1.isAnnotation());
			prop.put("isInterface", var1.isInterface());
			prop.put("isArray", var1.isArray());
			prop.put("isLocalClass", var1.isLocalClass());
			prop.put("isMemberClass", var1.isMemberClass());
			prop.put("isPrimitive", var1.isPrimitive());
			prop.put("isSynthetic", var1.isSynthetic());
			prop.put("superClass", var1.getSuperclass());
			prop.put("declaredClass", var1.getDeclaredClasses());
			prop.put("componentType", var1.getComponentType());
			prop.put("classes", var1.getClasses());
			
			var2 += toString(prop) + "]";
			
			return var2;
			
		}
		
		return par1.toString();
		
	}
	
}
