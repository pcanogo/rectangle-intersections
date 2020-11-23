package com.pablo.intersections;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	private static final int LIST_MAX = 10;
	
	public static void main(String[] args) {
		
		
		if(args.length == 0) {
			System.out.println("Please provide a file path as argument!");
		} else {
			String filePath = new File(args[0]).getAbsolutePath();
			List<Rectangle> rectangles = RectangleFactory.rectanglesFromFile(filePath);
			rectangles = rectangles.stream().limit(LIST_MAX).collect(Collectors.toList());
			IntersectionsComputer.findIntersections(rectangles);
		}
	}
}
