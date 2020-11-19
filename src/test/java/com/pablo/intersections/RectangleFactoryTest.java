package com.pablo.intersections;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class RectangleFactoryTest {

	private Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
	private Rectangle rect2 = new Rectangle(2, 120, 200, 250, 150);
	private Rectangle rect3 = new Rectangle(3, 140, 160, 250, 100);
	private Rectangle rect4 = new Rectangle(4, 160, 140, 350, 190);

	@Test
	public void testGetIntersectRectangle() {
		Point point1 = new Point(140, 160);
		Point point2 = new Point(350, 180);
		Point[] points = { point1, point2 };
		Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
		Rectangle rect2 = new Rectangle(2, 140, 160, 250, 100);
		Rectangle[] rects = { rect1, rect2 };
		Set<Rectangle> parents = new HashSet<>();
		parents.add(rect1);
		parents.add(rect2);
		IntersectRectangle intersect = new IntersectRectangle(1, 140, 160, 210, 20, parents);
		IntersectRectangle actualRect = RectangleFactory.getIntersectRectangle(1, points, rects);

		assertEquals(intersect.getIndex(), actualRect.getIndex());
		assertEquals(intersect.pointOne, actualRect.pointOne);
		assertEquals(intersect.pointTwo, actualRect.pointTwo);
		assertEquals(intersect.getDeltaX(), actualRect.getDeltaX());
		assertEquals(intersect.getDeltaY(), actualRect.getDeltaY());
		assertEquals(intersect.getParents(), actualRect.getParents());

	}

	@Test
	public void testRectangleFromFile() {
		String filepath = new File("testfiles\\test_rects1.json").getAbsolutePath();
		List<Rectangle> actualRects = RectangleFactory.rectanglesFromFile(filepath);
		List<Rectangle> rects = new ArrayList<>();
		rects.add(rect1);
		rects.add(rect2);
		rects.add(rect3);
		rects.add(rect4);
		assertEquals(rects.size(), actualRects.size());

		for (int i = 0; i < actualRects.size(); i++) {
			assertEquals(rects.get(i).getIndex(), actualRects.get(i).getIndex());
			assertEquals(rects.get(i).pointOne, actualRects.get(i).pointOne);
			assertEquals(rects.get(i).pointTwo, actualRects.get(i).pointTwo);
			assertEquals(rects.get(i).getDeltaX(), actualRects.get(i).getDeltaX());
			assertEquals(rects.get(i).getDeltaY(), actualRects.get(i).getDeltaY());
		}
	}
}
