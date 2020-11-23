package com.pablo.intersections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IntersectionsComputer {
	public static void findIntersections(List<Rectangle> rectangles) {
		Register register = new Register();

		for (Rectangle rect : rectangles) {
			register.rectQueue.add(rect);
			register.addRectangle(rect);
		}

		while (!register.rectQueue.isEmpty()) {
			Rectangle currentRect = register.rectQueue.poll();
			List<Rectangle> intersects = new ArrayList<>();

			if (currentRect instanceof IntersectRectangle)
				break;

			for (Rectangle rect : register.rectQueue) {
				if (rect instanceof IntersectRectangle) {
					IntersectRectangle intersect = (IntersectRectangle) rect;
					if (intersect.isChildOf(currentRect))
						continue;
				}
				if (Intersecter.hasIntersections(currentRect, rect)) {
					Point points[] = Intersecter.getIntersections(currentRect, rect);
					if (RectUtils.validDeltas(points)) {
						int index = register.generateIndex();
						Rectangle parents[] = { currentRect, rect };
						IntersectRectangle newRect = RectangleFactory.getIntersectRectangle(index, points, parents);
						Set<Integer> parentSet = newRect.getParentsIndex();
						if (!register.hasIntersection(parentSet)) {
							register.addIntersection(parentSet, newRect);
							intersects.add(newRect);
						}
					}
				}
			}
			register.rectQueue.addAll(intersects);
		}
		System.out.println("Input");
		register.printRectangles();
		System.out.println("Intersections:");
		register.printIntersections();
	}
}
