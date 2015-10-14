package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		if (frames == null)
			frames = new ArrayList<>();
		
		Frame previousFrame = getPreviousFrame();
		if (previousFrame != null) {
			
			if (previousFrame.isSpare())
				previousFrame.setBonus(frame.getFirstThrow());
		}
			
		frames.add(frame);
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		bonus = new Frame(firstThrow, secondThrow);
		frames.add(bonus);
	}
	
	public int score(){
		int ret = 0;
		
		for (Frame frame : frames)
			ret += frame.score();
		
		return ret;
	}
	
	public boolean isNextFrameBonus(){
		boolean ret = false;

		
		Frame previousFrame = getPreviousFrame();
		if (previousFrame != null) {
			if (previousFrame.isSpare() || previousFrame.isStrike())
				ret = true;
		}
		
		return ret;
	}
	
	public Frame getPreviousFrame() {
		Frame ret = null;
		if (frames.size() > 0) {
			ret = frames.get(frames.size()-1);
		}
		return ret;
	}
}

