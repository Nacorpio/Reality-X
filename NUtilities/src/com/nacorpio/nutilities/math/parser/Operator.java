package com.nacorpio.nutilities.math.parser;

public class Operator extends Element {

	public static final Operator plus
	= new Operator(2, 2, EnumOperatorType.ADDITION);
	
	public static final Operator minus
	= new Operator(2, 2, EnumOperatorType.SUBTRACTION);
	
	public static final Operator division
	= new Operator(2, 2, EnumOperatorType.DIVISION);
	
	public static final Operator multiplication 
	= new Operator(2, 2, EnumOperatorType.MULTIPLICATION);
	
	public static final Operator power
	= new Operator(2, 2, EnumOperatorType.POWER);
	
	public static final Operator square_root
	= new Operator(1, 2, EnumOperatorType.SQUARE_ROOT);
	
	public static final Operator[] operands = new Operator[] 
	{
		plus,
		minus,
		division,
		multiplication,
		power,
		square_root
	};
	
	public static enum EnumOperatorType {
		
		SQUARE_ROOT("sqr", "power", '√'),
		ADDITION("add", "subtract", '+'),
		SUBTRACTION("subtract", "add", '-'),
		DIVISION("divide", "multiply", '/'),
		MULTIPLICATION("multiply", "divide", '*'),
		POWER("power", "sqr", '^');
		
		private String name;
		private String refl;
		
		private char sign;
		
		EnumOperatorType(String par1, String par2, char par3) {
			name = par1;
			refl = par2;
			sign = par3;
		}
		
		public final String getName() {
			return name;
		}
		
		public final String getReflection() {
			return refl;
		}
		
		public final char getSign() {
			return sign;
		}
		
	}
	
	// The maximum amount of parameters.
	private int maxPar;
	
	// The minimum amount of parameters.
	private int minPar;
	
	private EnumOperatorType type;
	
	protected Operator(int par1) {
		super(par1, EnumType.OPERAND);
	}
	
	public Operator(int par1, int par2, EnumOperatorType par3) {
		super(-1, EnumType.OPERAND);
		minPar = par1;
		maxPar = par2;
		type = par3;
	}
	
	public final int getMaximumPars() {
		return maxPar;
	}
	
	public final int getMinimumPars() {
		return minPar;
	}
	
	public final EnumOperatorType getOperandType() {
		return type;
	}
	
}
