package com.pablo.intersections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntersectionsComputerTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@After
	public void tearDown() {
		System.setOut(standardOut);
	}
	
	@Test
	public void testFindAllIntersection() {
		List<Rectangle> rectangles = new ArrayList<>();
		Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
		Rectangle rect2 = new Rectangle(2, 120, 200, 250, 150);
		Rectangle rect3 = new Rectangle(3, 140, 160, 250, 100);
		Rectangle rect4 = new Rectangle(4, 160, 140, 350, 190);
		
		rectangles.add(rect1);
		rectangles.add(rect2);
		rectangles.add(rect3);
		rectangles.add(rect4);
		
		String output = "Input"
				+ System.getProperty("line.separator")
				+ "1: Rectangle at (100, 100), delta_x=250, delta_y=80."
				+ System.getProperty("line.separator")
				+ "2: Rectangle at (120, 200), delta_x=250, delta_y=150."
				+ System.getProperty("line.separator")
				+ "3: Rectangle at (140, 160), delta_x=250, delta_y=100."
				+ System.getProperty("line.separator")
				+ "4: Rectangle at (160, 140), delta_x=350, delta_y=190."
				+ System.getProperty("line.separator")
				+ "Intersections:"
				+ System.getProperty("line.separator")
				+ "1: Between rectangle 1 and 3 at (140, 160), delta_x=210, delta_y=20."
				+ System.getProperty("line.separator")
				+ "2: Between rectangle 1 and 4 at (160, 140), delta_x=190, delta_y=40."
				+ System.getProperty("line.separator")
				+ "3: Between rectangle 2 and 3 at (140, 200), delta_x=230, delta_y=60."
				+ System.getProperty("line.separator")
				+ "4: Between rectangle 2 and 4 at (160, 200), delta_x=210, delta_y=130."
				+ System.getProperty("line.separator")
				+ "5: Between rectangle 3 and 4 at (160, 160), delta_x=230, delta_y=100."
				+ System.getProperty("line.separator")
				+ "6: Between rectangle 1, 3 and 4 at (160, 160), delta_x=190, delta_y=20."
				+ System.getProperty("line.separator")
				+ "7: Between rectangle 2, 3 and 4 at (160, 200), delta_x=210, delta_y=60.";
		
		IntersectionsComputer.findIntersections(rectangles);
		assertEquals(output, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testSixContributors() {
		List<Rectangle> rectangles = new ArrayList<>();
		Rectangle rect1 = new Rectangle(1, 10, 10, 70, 40);
		Rectangle rect2 = new Rectangle(2, 15, 15, 75, 45);
		Rectangle rect3 = new Rectangle(3, 20, 20, 75, 45);
		Rectangle rect4 = new Rectangle(4, 25, 25, 75, 45);
		Rectangle rect5 = new Rectangle(5, 30, 30, 75, 45);
		Rectangle rect6 = new Rectangle(6, 35, 35, 75, 45);
		
		rectangles.add(rect1);
		rectangles.add(rect2);
		rectangles.add(rect3);
		rectangles.add(rect4);
		rectangles.add(rect5);
		rectangles.add(rect6);
		
		String output ="Between rectangle 1, 2, 3, 4, 5 and 6 at (35, 35), delta_x=45, delta_y=15.";
		IntersectionsComputer.findIntersections(rectangles);
		assertTrue(outputStreamCaptor.toString().contains(output));
	}
	
	@Test
	public void testEdgeIntersctions() {
		List<Rectangle> rectangles = new ArrayList<>();
		Rectangle rect1 = new Rectangle(1, 10, 10, 20, 10);
		Rectangle rect2 = new Rectangle(2, 20, 20, 20, 10);
		
		rectangles.add(rect1);
		rectangles.add(rect2);
		
		String output ="No Intersections found";
		IntersectionsComputer.findIntersections(rectangles);
		assertTrue(outputStreamCaptor.toString().contains(output));
	}
}
