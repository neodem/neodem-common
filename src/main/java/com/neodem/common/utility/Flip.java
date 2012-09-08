package com.neodem.common.utility;

public class Flip {
	private boolean lockType;
	private boolean flag = false;

	public Flip(boolean lockType) {
		this.lockType = lockType;
	}
	
	public boolean accept(boolean value) {
		if(value == lockType) {
			flag = true;
		}
		
		return value;
	}
	
	public boolean activated() {
		return flag;
	}
}
