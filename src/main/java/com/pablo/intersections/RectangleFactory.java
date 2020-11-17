package com.pablo.intersections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleFactory {
	
	public static IntersectRectangle getIntersectRectangle(int index, Point[] points ,Rectangle[] parents) {
		int deltax = points[1].getX() - points[0].getX();
		int deltay = points[1].getY() - points[0].getY();
		
		List<Rectangle> allParents = getParents(parents[0], parents[1]);
		
		return new IntersectRectangle(index, points[0].getX(), points[0].getY(), deltax, deltay, allParents);
	}
	
	public static boolean isIntersect(Rectangle rect) {
		return rect instanceof IntersectRectangle;
	}
	
	public static boolean validDeltas(Point[] points) {
		int deltax = points[1].getX() - points[0].getX();
		int deltay = points[1].getY() - points[0].getY();
		
		return deltax > 0 && deltay > 0;
	}
	
	public static List<Rectangle> getParents(Rectangle rectOne, Rectangle rectTwo) {
		Rectangle rects[] = {rectOne, rectTwo};
		List<Rectangle> parents = new ArrayList<Rectangle>();
		
		for(Rectangle rect : rects) {
			if(rect instanceof IntersectRectangle) {
				IntersectRectangle interRect = (IntersectRectangle) rect;
				parents.addAll(interRect.getParents());
			} else {
				parents.add(rect);
			}
		}
		Collections.sort(parents);
		return parents;
	}
}
