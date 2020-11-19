package com.pablo.intersections;

import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		Register rg = new Register();

		String filePath = "C:\\Users\\pablo\\Documents\\rects.json";
		List<Rectangle> rectangles = RectangleFactory.rectanglesFromFile(filePath);

		for (Rectangle rect : rectangles) {
			rg.rectQueue.add(rect);
			rg.addRectangle(rect);
		}

		while (!rg.rectQueue.isEmpty()) {
			Rectangle currentRect = rg.rectQueue.poll();

			if (currentRect instanceof IntersectRectangle)
				break;

			for (Rectangle rect : rg.rectQueue) {
				if (rect instanceof IntersectRectangle) {
					IntersectRectangle intersect = (IntersectRectangle) rect;
					if (intersect.isChildOf(currentRect))
						continue;
				}
				if (Intersecter.hasIntersections(currentRect, rect)) {
					Point points[] = Intersecter.getIntersections(currentRect, rect);
					if (RectUtils.validDeltas(points)) {
						int index = rg.generateIndex();
						Rectangle parents[] = { currentRect, rect };
						IntersectRectangle newRect = RectangleFactory.getIntersectRectangle(index, points, parents);
						Set<Integer> parentSet = newRect.getParentsIndex();
						if (!rg.hasIntersection(parentSet)) {
							rg.addIntersection(parentSet, newRect);
							rg.rectQueue.add(newRect);
						}
					}
				}
			}
		}
		System.out.println("Input");
		rg.printRectangles();
		System.out.println("Intersections:");
		rg.printIntersections();
	}
}
