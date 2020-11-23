package com.pablo.intersections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class IntersecterTest {
	private Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
	private Rectangle rect2 = new Rectangle(3, 140, 160, 250, 100);
	private Rectangle rect3 = new Rectangle(4, 160, 140, 350, 190);
	private Set<Rectangle> parents = new HashSet<Rectangle>();
	private IntersectRectangle intersect1;

	@Before
	public void prepCase(){
		parents.add(rect1);
		parents.add(rect2);
		intersect1 = new IntersectRectangle(1, 140, 160, 210, 20, parents);
	}
		
	@Test
	public void testHasIntersections() {
		boolean result = Intersecter.hasIntersections(rect1, rect2);
		assertTrue(result);

		result = Intersecter.hasIntersections(intersect1, rect3);
		assertTrue(result);
	}

	@Test
	public void testGetIntersections() {
		Point point1 = new Point(140, 160);
		Point point2 = new Point(350, 180);
		Point[] actualPoints = Intersecter.getIntersections(rect1, rect2);
		assertEquals(point1, actualPoints[0]);
		assertEquals(point2, actualPoints[1]);
		
		point1 = new Point(160,160);
		point2 = new Point(350,180);
		actualPoints =  Intersecter.getIntersections(rect3, intersect1);
		assertEquals(point1, actualPoints[0]);
		assertEquals(point2, actualPoints[1]);
		
	}
}
