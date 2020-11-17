package com.pablo.intersections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public final class Registor {
	public static List<Rectangle> rectangles = new ArrayList<Rectangle>();
	private static HashMap<Set<Integer>, Boolean>  intersections = new HashMap<Set<Integer>, Boolean>();
	
	public static void addIntersection(Set<Integer> rects) {
		intersections.put(rects, true);
	}
	
	public static boolean hasIntersection(Set<Integer> rects) {
		return intersections.containsKey(rects);
	}
}
