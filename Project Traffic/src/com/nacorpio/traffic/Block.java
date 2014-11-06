package com.nacorpio.traffic;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.traffic.pos.IntPos;

public class Block {

	private String name;
	private IntPos position;
	
	public static final float CAPACITY = 100.0F;
	
	private List<SubBlock> subs = new ArrayList<SubBlock>();
	
	public Block(IntPos par1) {
		position = par1;
	}
	
	protected Block(String par1) {
		name = par1;
	}
	
	public final boolean addSub(SubBlock par1) {
		if (totalSubSize() + par1.getSize() <= CAPACITY) {
			return subs.add(par1);
		}
		return false;
	}
	
	public final SubBlock getSub(String par1) {
		for (SubBlock var: subs) {
			if (var.getName().equals(par1))
				return var;
		}
		return null;
	}
	
	public final float totalSubSize() {
		
		if (subs.size() == 0) {
			return 0;
		}
		
		float value = 0;
		
		for (SubBlock par: subs) {
			value += par.getSize();
		}
		
		return value;
		
	}
	
	public final String getName() {
		return name;
	}
	
	public final IntPos getPosition() {
		return position;
	}
	
	public String getDisplayName() {
		return name.toLowerCase();
	}
	
	public int getXBounds() {
		return 5;
	}
	
	public int getYBounds() {
		return 5;
	}
	
}
