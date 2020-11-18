package com.pablo.intersections;

import org.junit.Test;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

public class IntersectRectangleTest {
	private Rectangle parent1 = new Rectangle(1, 100, 100, 250, 80);
	private Rectangle parent2 = new Rectangle(2, 120, 200, 250, 150);
	private Rectangle parent3 = new Rectangle(3, 140, 160, 250, 100);
	private Rectangle parent4 = new Rectangle(4, 160, 140, 350, 190);
	private Rectangle parent5 = new Rectangle(5, 400, 400, 10, 10);

	private Set<Rectangle> parents = new HashSet<Rectangle>();
	private Set<Integer> indexes = new HashSet<Integer>();

	@Test
	public void testParentIndexes() {
		IntersectRectangle rect1 = prepCase1();
		assertEquals(indexes, rect1.getParentsIndex());
		clearCase();

		IntersectRectangle rect2 = prepCase2();
		assertEquals(indexes, rect2.getParentsIndex());
		clearCase();
	}

	@Test
	public void testChildOf() {
		IntersectRectangle rect1 = prepCase1();
		assertTrue(rect1.isChildOf(parent1));
		assertTrue(rect1.isChildOf(parent3));
		assertFalse(rect1.isChildOf(parent4));
		clearCase();

		IntersectRectangle rect2 = prepCase2();
		assertTrue(rect2.isChildOf(parent1));
		assertTrue(rect2.isChildOf(parent3));
		assertTrue(rect2.isChildOf(parent4));
		assertFalse(rect2.isChildOf(parent5));
		clearCase();
	}
	
	@Test
	public void testToString() {
		String s1 = "1: Between rectangle 1 and 3 at (140, 160), delta_x=210, delta_y=20.";
		IntersectRectangle rect1 = prepCase1();
		assertEquals(s1, rect1.toString());
		clearCase();
		String s2 = "2: Between rectangle 1, 3 and 4 at (160, 160), delta_x=190, delta_y=20.";
		IntersectRectangle rect2 = prepCase2();
		assertEquals(s2, rect2.toString());
		clearCase();
	}

	private IntersectRectangle prepCase1() {
		parents.add(parent1);
		parents.add(parent3);
		indexes.add(1);
		indexes.add(3);
		return new IntersectRectangle(1, 140, 160, 210, 20, parents);
	}

	private IntersectRectangle prepCase2() {
		parents.add(parent1);
		parents.add(parent3);
		parents.add(parent4);
		indexes.add(1);
		indexes.add(3);
		indexes.add(4);
		return new IntersectRectangle(2, 160, 160, 190, 20, parents);
	}

	private void clearCase() {
		parents.clear();
		indexes.clear();
	}
}
