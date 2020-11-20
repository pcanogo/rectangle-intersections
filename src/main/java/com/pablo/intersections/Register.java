package com.pablo.intersections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public final class Register {
	public ArrayDeque<Rectangle> rectQueue;
	private List<Rectangle> rectangles;
	private HashMap<Set<Integer>, Rectangle> intersections;

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

	public int generateIndex() {
		int index = 1 + this.intersections.size();
		return index;
	}

	public void printRectangles() {
		this.rectangles.stream().map(Rectangle::toString).forEach(System.out::println);
	}

	public void printIntersections() {
		int lenght = this.intersections.size();
		if(lenght > 0) {
			Rectangle[] intersects = this.intersections.values().toArray(new Rectangle[lenght]);
			Arrays.sort(intersects);
			Arrays.stream(intersects).map(Rectangle::toString).forEach(System.out::println);	
		} else {
			System.out.println("No Intersections found");
		}
	}
}
