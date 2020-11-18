package com.pablo.intersections;

import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Register rg = new Register();

		Rectangle A = new Rectangle(1, 100, 100, 250, 80);
		Rectangle B = new Rectangle(2, 120, 200, 250, 150);
		Rectangle C = new Rectangle(3, 140, 160, 250, 100);
		Rectangle D = new Rectangle(4, 160, 140, 350, 190);
		
		rg.rectQueue.add(A);
		rg.addRectangle(A);
		
		rg.rectQueue.add(B);
		rg.addRectangle(B);
		
		rg.rectQueue.add(C);
		rg.addRectangle(C);
		
		rg.rectQueue.add(D);
		rg.addRectangle(D);

		while (!rg.rectQueue.isEmpty()) {
			Rectangle currentRect = rg.rectQueue.poll();

			if (RectangleFactory.isIntersect(currentRect)) break;

			for (Rectangle rect : rg.rectQueue) {
				if (RectangleFactory.isIntersect(rect)) {
					IntersectRectangle intersect = (IntersectRectangle) rect;
					if (intersect.isChildOf(currentRect))
						continue;
				}
				if (Intersecter.hasIntersections(currentRect, rect)) {
					Point points[] = Intersecter.getIntersections(currentRect, rect);
					if (RectangleFactory.validDeltas(points)) {
						int index = rg.generateIndex(currentRect);
						Rectangle parents[] = { currentRect, rect };
						IntersectRectangle newRect = RectangleFactory.getIntersectRectangle(index, points, parents);
						Set<Integer> parentSet = newRect.getParentsIndex();
						if (!rg.hasIntersection(parentSet)) {
							rg.addIntersection(parentSet, newRect);
							rg.rectQueue.add(newRect);
//							System.out.println(newRect);
						}
					}
				}
			}
		}
		
		rg.printRectangles();
	}
}
