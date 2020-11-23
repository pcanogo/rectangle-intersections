package com.pablo.intersections;

import java.util.HashSet;
import java.util.Set;

public final class RectUtils {
	public static boolean validDeltas(Point[] points) {
		int deltax = points[1].getX() - points[0].getX();
		int deltay = points[1].getY() - points[0].getY();

		return deltax > 0 && deltay > 0;
	}

	public static Set<Rectangle> getParents(Rectangle rectOne, Rectangle rectTwo) {
		Rectangle rects[] = { rectOne, rectTwo };
		Set<Rectangle> parents = new HashSet<Rectangle>();

		for (Rectangle rect : rects) {
			if (rect instanceof IntersectRectangle) {
				IntersectRectangle interRect = (IntersectRectangle) rect;
				parents.addAll(interRect.getParents());
			} else {
				parents.add(rect);
			}
		}
		return parents;
	}
}