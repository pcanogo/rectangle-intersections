package com.pablo.intersections;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntersectionsComputerTest {
	private Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
	private Rectangle rect2 = new Rectangle(2, 120, 200, 250, 150);
	private Rectangle rect3 = new Rectangle(3, 140, 160, 250, 100);
	private Rectangle rect4 = new Rectangle(4, 160, 140, 350, 190);
	
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
	public void testFindintersections() {
		List<Rectangle> rectangles = new ArrayList<>();
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
}
