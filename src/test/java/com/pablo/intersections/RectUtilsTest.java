package com.pablo.intersections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RectUtilsTest {

	@Test
	public void testValidDeltas() {
		Point point1 = new Point(10, 10);
		Point point2 = new Point(20, 20);
		Point[] points = { point1, point2 };
		assertTrue(RectUtils.validDeltas(points));

		point2 = new Point(10, 10);
		points[1] = point2;
		assertFalse(RectUtils.validDeltas(points));

		point2 = new Point(5, 5);
		points[1] = point2;
		assertFalse(RectUtils.validDeltas(points));
	}

	@Test
	public void testGetParent() {
		Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
		Rectangle rect2 = new Rectangle(2, 140, 160, 250, 100);
		Rectangle rect3 = new Rectangle(4, 160, 140, 350, 190);
		Set<Rectangle> parents = new HashSet<Rectangle>();
		parents.add(rect1);
		parents.add(rect2);
		assertEquals(parents, RectUtils.getParents(rect1, rect2));
		IntersectRectangle intersect1 = new IntersectRectangle(1, 140, 160, 210, 20, parents);
		parents.add(rect3);
		assertEquals(parents, RectUtils.getParents(intersect1, rect3));
	}
}
