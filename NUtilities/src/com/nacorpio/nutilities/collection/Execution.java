package com.nacorpio.nutilities.collection;

public class Execution {

	private Tree tree;
	private String source;
	
	public Execution(String par1) {
		source = par1;
	}
	
	public Execution(Tree par1) {
		this.source = par1.toString();
	}
	
	public final Tree execute() {
		
		long start = System.currentTimeMillis();
		String[] lines = source.split("\n");
		
		for (int i = 0; i < lines.length; i++) {
			
			String line = lines[i];
			
			if (Builder.isDeclareCommand(line, "@ROOT")) {
				
				tree = new Tree();
				System.out.println("Declared new tree");
				
			} else if (Builder.isInsertCommand(line)) {
				
				if (tree == null) {
					System.out.println("A tree has not been declared");
					return null;
				}
				
				String from = Builder.getPointingFrom(line);
				String to = Builder.getPointingTo(line);
				
				String[] props = Builder.getProperties(line);
				
				if (to.equals("@ROOT")) {
					tree.add(props[0].split("=")[1], props[1].split("=")[1]);
				} else {
					tree.findId(to).add(props[0].split("=")[1], props[1].split("=")[1]);
				}
				
				System.out.println("Inserted " + from + " into " + to + "");
				
			}
			
		}
		
		System.out.println("Execution has finished (" + ((float) (System.currentTimeMillis() - start) / 1000) + " seconds)");
		return tree;
		
	}
	
	public final String toString() {
		return source;
	}
	
}
