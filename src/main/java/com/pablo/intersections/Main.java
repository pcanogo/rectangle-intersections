package com.pablo.intersections;

import java.io.File;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Please provide a file path as argument!");
		} else {
			String filePath = new File(args[0]).getAbsolutePath();
			List<Rectangle> rectangles = RectangleFactory.rectanglesFromFile(filePath);
			IntersectionsComputer.findIntersections(rectangles);
		}
	}
}
