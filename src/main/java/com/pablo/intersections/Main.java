package com.pablo.intersections;

public class Main 
{
    public static void main( String[] args )
    {
        Rectangle A = new Rectangle(1, 100, 100, 250, 80);
        Rectangle B = new Rectangle(2, 120, 200, 250, 150);
        Rectangle C = new Rectangle(3, 140, 160, 250, 100);
        Rectangle D = new Rectangle(4, 160, 140, 350, 190);
        
        Intersector.rectangles.add(A);
        Intersector.rectangles.add(B);
        Intersector.rectangles.add(C);
        Intersector.rectangles.add(D);

        while(!Intersector.rectangles.isEmpty()) {
        	Rectangle currentRect = Intersector.rectangles.poll();
        	
        	if(currentRect instanceof IntersectRectangle) continue;
        	
        	for(Rectangle rect : Intersector.rectangles) {
        		
        		if(RectangleFactory.isIntersect(rect)) {
        			IntersectRectangle intersect = (IntersectRectangle) rect;
        			if(intersect.isChildOf(currentRect)) continue;
        		}
        		if(Intersector.hasIntersections(currentRect, rect)) {
        			Point points[] = Intersector.getIntersections(currentRect, rect);
        			if(RectangleFactory.validDeltas(points)) {
        				int index = Intersector.generateIndex(currentRect);
            			Rectangle parents[] = {currentRect, rect};
            			IntersectRectangle intersectRect = RectangleFactory.getIntersectRectangle(index, points, parents);
        				Intersector.rectangles.add(intersectRect);
        				System.out.println(intersectRect);
        			}
        		}
        	}
        }
    }
}
