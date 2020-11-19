package com.pablo.intersections;
import com.pablo.intersections.JsonRectangles.JsonRectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class RectangleTest {
	private Point pointOne = new Point(10, 10);
	private Point pointTwo = new Point(20, 20);
	private int deltax = 10;
	private int deltay = 10;

	@Test
	public void testConstructor() {
		Rectangle rect = new Rectangle(1, 10, 10, 10, 10);

		assertEquals(pointOne, rect.pointOne);
		assertEquals(pointTwo, rect.pointTwo);
		assertEquals(deltax, rect.getDeltaX());
		assertEquals(deltay, rect.getDeltaY());
	}

	@Test
	public void testJsonConstructor() {
		JsonRectangle jsonRect = new JsonRectangle(10, 10, 10, 10);
		Rectangle rect = new Rectangle(1, jsonRect);

		assertEquals(pointOne, rect.pointOne);
		assertEquals(pointTwo, rect.pointTwo);
		assertEquals(deltax, rect.getDeltaX());
		assertEquals(deltay, rect.getDeltaY());
	}

	@Test
	public void testEqualBehavior() {
		Rectangle rectOne = new Rectangle(1, 10, 10, 10, 10);
		Rectangle rectTwo = new Rectangle(1, 10, 10, 10, 10);

		assertNotEquals(rectOne, rectTwo);
	}
}
