package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int bonus;
	private boolean lastFrame;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}
	
	public int getSecondThrow() {
		return secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		return firstThrow + secondThrow + bonus;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		boolean ret = false;
		if (firstThrow == 10)
			ret = true;
		return ret;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		boolean ret = false;
		if (firstThrow + secondThrow == 10)
			ret = true;
		return ret;
	}

	public void setLastFrame(boolean lastFrame) {
		this.lastFrame = lastFrame;
	}
	
	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return lastFrame;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	//bonus throws
	public int bonus(){
		// not yet implemented
		return bonus;
	}
}
