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
		
		if (isNextFrameBonus()) {
			Frame previousFrame = frames.get(frames.size()-1);
			previousFrame.setBonus(frame.bonus());	
		}
			
		
		frames.add(frame);
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int ret = 0;
		
		for (Frame frame : frames)
			ret += frame.score();
		
		return ret;
	}
	
	public boolean isNextFrameBonus(){
		boolean ret = false;

		if (frames.size() > 0) {
			Frame previousFrame = frames.get(frames.size()-1);
			if (previousFrame.isSpare() || previousFrame.isStrike())
				ret = true;
		}
		
		return ret;
	}
}
