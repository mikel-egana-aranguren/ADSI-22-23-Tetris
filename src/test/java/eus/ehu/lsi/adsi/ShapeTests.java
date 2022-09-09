package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.zetcode.Shape;

public class ShapeTests {

	private static final Logger logger = LogManager.getLogger(ShapeTests.class);
	
	@Test
	public void testShape() {
		logger.info("Test Shape creation");
		Shape shape = new Shape();
		assertTrue(shape.minX() == 0);
	}

	@Test
	public void testSetShape() {
		fail("Not yet implemented");
	}

	@Test
	public void testX() {
		fail("Not yet implemented");
	}

	@Test
	public void testY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShape() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRandomShape() {
		fail("Not yet implemented");
	}

	@Test
	public void testMinX() {
		fail("Not yet implemented");
	}

	@Test
	public void testMinY() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateRight() {
		fail("Not yet implemented");
	}

}
