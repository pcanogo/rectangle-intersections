package com.pablo.intersections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class PointTest {
	private Point point1 = new Point(10, 15);
	private Point point2 = new Point(10, 15);
	private Point point3 = new Point(15, 15);

	@Test
	public void testPointToString() {
		String expectedString = "(10, 15)";
		assertEquals(expectedString, point1.toString());
	}

	@Test
	public void testPointEquals() {
		assertEquals(point1, point2);
		assertNotEquals(point2, point3);
	}
}
