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
	public void testGameAddFrame() {
		Frame frame = new Frame(0, 0);
		game.addFrame(frame);
		assertEquals(1, game.getFrames().size());
	}
	
	@Test
	public void testGameNextFrameBonus() {
		Frame frame = new Frame(10, 0);
		game.addFrame(frame);
		assertTrue(game.isNextFrameBonus());
	}
	
	@Test
	public void testGameScoreSpareBonus() {
		game.addFrame( new Frame(1, 4) ); // 5
		game.addFrame( new Frame(4, 5) ); // 14
		game.addFrame( new Frame(6, 4) ); // 29 (bonus 5)
		game.addFrame( new Frame(5, 0) ); // 34
		assertEquals(34, game.score());
	}
	
	@Test
	public void testGameScoreStrikeBonus() {
		game.addFrame( new Frame(1, 4) ); // 5
		game.addFrame( new Frame(4, 5) ); // 14
		game.addFrame( new Frame(6, 4) ); // 29 (bonus 5)
		game.addFrame( new Frame(5, 5) ); // 49 (bonus 10)
		game.addFrame( new Frame(10, 0) ); // 60 (bonus 1)
		game.addFrame( new Frame(0, 1) ); // 61 (bonus 10)
		assertEquals(61, game.score());
	}
	
	@Test
	public void testGameBonusRoundAtTenthFrame() {
		game.addFrame( new Frame(1, 4) ); // 5
		game.addFrame( new Frame(4, 5) ); // 14
		game.addFrame( new Frame(6, 4) ); // 29 (bonus 5)
		game.addFrame( new Frame(5, 5) ); // 49 (bonus 10)
		game.addFrame( new Frame(10, 0) ); // 60 (bonus 1)
		game.addFrame( new Frame(0, 1) ); // 61
		game.addFrame( new Frame(7, 3) ); // 77 (bonus 6)
		game.addFrame( new Frame(6, 4) ); // 97 (bonus 10)
		game.addFrame( new Frame(10, 0) ); // 117
		game.addFrame( new Frame(2, 8) );
		assertTrue(game.isNextFrameBonus());
		game.setBonus(6, 0);
		assertEquals(133, game.score());
	}
	
	@Test
	public void testGameBonusRoundCannotRollFourBalls() {
		game.addFrame( new Frame(1, 4) ); // 5
		game.addFrame( new Frame(4, 5) ); // 14
		game.addFrame( new Frame(6, 4) ); // 29 (bonus 5)
		game.addFrame( new Frame(5, 5) ); // 49 (bonus 10)
		game.addFrame( new Frame(10, 0) ); // 60 (bonus 1)
		game.addFrame( new Frame(0, 1) ); // 61
		game.addFrame( new Frame(7, 3) ); // 77 (bonus 6)
		game.addFrame( new Frame(6, 4) ); // 97 (bonus 10)
		game.addFrame( new Frame(10, 0) ); // 117
		game.addFrame( new Frame(2, 8) );
		// bonus
		game.setBonus(6, 5);
		assertEquals(133, game.score());
	}
	
	@Test
	public void testGameScore() {
		Frame frame = new Frame(0, 1);
		game.addFrame(frame);
		
		assertEquals(1, game.score());
	}
	
	@Test
	public void testGameLastFrame() {
		game.addFrame( new Frame(1, 4) );
		game.addFrame( new Frame(4, 5) ); 
		game.addFrame( new Frame(6, 4) ); 
		game.addFrame( new Frame(5, 5) ); 
		game.addFrame( new Frame(10, 0) );
		game.addFrame( new Frame(0, 1) );
		game.addFrame( new Frame(7, 3) );
		game.addFrame( new Frame(6, 4) );
		game.addFrame( new Frame(10, 0) );
		Frame lastFrame = new Frame(2, 0);
		game.addFrame( lastFrame );
		
		assertTrue(lastFrame.isLastFrame());
	}
	
	@Test
	public void testGameNoBonusWhenLastFrameIsNotPlayed() {
		game.addFrame( new Frame(1, 4) );
		game.addFrame( new Frame(4, 5) ); 
		game.setBonus(1, 1);
		assertEquals( 14, game.score() );
	}
	
	@Test
	public void testFrameStrike() {
		Frame frame = new Frame(10, 0);
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void testFrameSpare() {
		Frame frame = new Frame(5, 5);
		assertTrue(frame.isSpare());
	}
	
	@Test
	public void testFrameLastFrame() {
		Frame frame = new Frame(0,0);
		frame.setLastFrame(true);
		assertTrue(frame.isLastFrame());
		
	}

}
