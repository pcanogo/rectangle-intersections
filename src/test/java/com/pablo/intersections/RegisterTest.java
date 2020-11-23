package com.pablo.intersections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
	Register register = new Register();
	private Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
	private Rectangle rect2 = new Rectangle(2, 140, 160, 250, 100);
	private Rectangle rect3 = new Rectangle(3, 160, 140, 350, 190);

	private IntersectRectangle intersect1;
	private IntersectRectangle intersect2;

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUpRegister() {
		System.setOut(new PrintStream(outputStreamCaptor));
		
		register.addRectangle(rect1);
		register.addRectangle(rect2);
		register.addRectangle(rect3);

		Set<Rectangle> parents1 = new HashSet<>();
		parents1.add(rect1);
		parents1.add(rect2);
		intersect1 = new IntersectRectangle(1, 140, 160, 210, 20, parents1);

		Set<Rectangle> parents2 = new HashSet<>();
		parents2.add(rect1);
		parents2.add(rect3);
		intersect2 = new IntersectRectangle(2, 160, 140, 190, 40, parents2);

		Set<Integer> indexes1 = new HashSet<>();
		indexes1.add(1);
		indexes1.add(2);
		register.addIntersection(indexes1, intersect1);

		Set<Integer> indexes2 = new HashSet<>();
		indexes2.add(1);
		indexes2.add(3);
		register.addIntersection(indexes2, intersect2);
	}
	
	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	public void testHasIntersection() {
		Set<Integer> indexes = new HashSet<>();
		indexes.add(1);
		indexes.add(2);
		assertTrue(register.hasIntersection(indexes));
		indexes.clear();
		indexes.add(1);
		indexes.add(3);
		assertTrue(register.hasIntersection(indexes));
		indexes.clear();
		indexes.add(2);
		indexes.add(3);
		assertFalse(register.hasIntersection(indexes));
	}

	@Test
	public void testGenerateIndex() {
		assertEquals(3, register.generateIndex());
	}

	@Test
	public void testPrintRectangles() {
		String output = "1: Rectangle at (100, 100), delta_x=250, delta_y=80." 
				+ System.getProperty("line.separator")
				+ "2: Rectangle at (140, 160), delta_x=250, delta_y=100."
				+ System.getProperty("line.separator")
				+ "3: Rectangle at (160, 140), delta_x=350, delta_y=190.";
		register.printRectangles();
		assertEquals(output, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testPrintIntersections() {
		String output = "1: Between rectangle 1 and 2 at (140, 160), delta_x=210, delta_y=20."
				+ System.getProperty("line.separator")
				+ "2: Between rectangle 1 and 3 at (160, 140), delta_x=190, delta_y=40.";
		register.printIntersections();
		assertEquals(output, outputStreamCaptor.toString().trim());
	}
}
