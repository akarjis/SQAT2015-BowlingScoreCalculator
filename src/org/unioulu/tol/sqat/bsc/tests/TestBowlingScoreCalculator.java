package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	private BowlingGame game;
	
	@Before
	public void setup() {
		game = new BowlingGame();
	}
	
	@After
	public void tearDown() {
		game = null;
	}
	
	@Test
	public void testAddFrame() {
		Frame frame = new Frame(0, 0);
		game.addFrame(frame);
		
		assertEquals(1, game.getFrames().size());
	}

}
