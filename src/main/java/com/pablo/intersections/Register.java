package com.pablo.intersections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public final class Register {
	public ArrayDeque<Rectangle> rectQueue;
	private List<Rectangle> rectangles;
	private HashMap<Set<Integer>, Rectangle>  intersections;
	
	public Register() {
		this.rectQueue = new ArrayDeque<Rectangle>();
		this.rectangles = new ArrayList<Rectangle>();
		this.intersections = new HashMap<Set<Integer>, Rectangle>();
	}
	
	public void addRectangle(Rectangle rect) {
		this.rectangles.add(rect);
	}
	
	public void addIntersection(Set<Integer> rects, Rectangle rect) {
		this.intersections.put(rects, rect);
	}
	
	public boolean hasIntersection(Set<Integer> rects) {
		return this.intersections.containsKey(rects);
	}
	
	public int generateIndex(Rectangle baseRect) {
		int index = 1 + rectQueue.size() + baseRect.getIndex();
		return index;
	}
	
	public void printRectangles() {
		this.rectangles.stream().map(Rectangle::toString).forEach(System.out::println);
	}
	
	public String intersectionsToString() {
		String result = "";
		return result;
	}
	
}
