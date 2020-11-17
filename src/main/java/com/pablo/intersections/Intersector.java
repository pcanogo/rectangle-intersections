package com.pablo.intersections;

import java.util.ArrayDeque;

public final class Intersector {
	
	public static ArrayDeque<Rectangle> rectangles = new ArrayDeque<Rectangle>();
	
	public static boolean hasIntersections(Rectangle rectOne, Rectangle rectTwo) {
		int a3x = Math.max(rectOne.pointOne.getX(), rectOne.pointTwo.getX());
		int a3y = Math.max(rectOne.pointOne.getY(), rectOne.pointTwo.getY());
		
		int b3x = Math.min(rectTwo.pointOne.getX(), rectTwo.pointTwo.getX());
		int b3y = Math.min(rectTwo.pointOne.getY(), rectTwo.pointTwo.getY());
		
		Point pointA = new Point(a3x, a3y);
		Point pointB = new Point(b3x, b3y);
		return pointA.equals(rectOne.pointTwo) && pointB.equals(rectTwo.pointOne);
	}
	
	public static Point[] getIntersections(Rectangle rectOne, Rectangle rectTwo) {
		Point points[] = new Point[2];
		
		int PointOneX = Math.max(rectOne.pointOne.getX(), rectTwo.pointOne.getX());
		int PointOneY = Math.max(rectOne.pointOne.getY(), rectTwo.pointOne.getY());
		points[0] = new Point(PointOneX, PointOneY);
		
		int PointTwoX = Math.min(rectOne.pointTwo.getX(), rectTwo.pointTwo.getX());
		int PointTwoY = Math.min(rectOne.pointTwo.getY(), rectTwo.pointTwo.getY());
		points[1] = new Point(PointTwoX, PointTwoY);
		
		return points;
	}
	
	public static int generateIndex(Rectangle baseRect) {
		int index = 1 + rectangles.size() + baseRect.getIndex();
		return index;
	}
}
