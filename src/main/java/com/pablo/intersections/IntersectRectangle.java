package com.pablo.intersections;

import java.util.HashSet;
import java.util.Set;

public class IntersectRectangle extends Rectangle{

	private Set<Rectangle> parents;

	public IntersectRectangle(int index, int x, int y, int deltax, int deltay, Set<Rectangle> parents) {
		super(index, x,y, deltax, deltay);
		this.parents =  parents;
	}
	
	public Set<Rectangle> getParents(){
		return this.parents;
	}
	
	public Set<Integer> getParentsIndex(){
		Set<Integer> parentIndexes = new HashSet<Integer>();
		for(Rectangle parent : parents) {
			parentIndexes.add(parent.getIndex());
		}
		return parentIndexes;
	}
	
	public boolean isChildOf(Rectangle rect) {
		for(Rectangle parent : parents) {
			if (parent.equals(rect)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String parentsIndexes = "";
		for (Rectangle parent : parents) {
			parentsIndexes += parent.getIndex() + ", ";
		}
		parentsIndexes = parentsIndexes.substring(0, parentsIndexes.length() - 2);
		
		return "Intersect [index=" + this.getIndex()
				+ ", parents=[ " + parentsIndexes + "]"
				+ ", pointOne=" + pointOne + ", pointTwo=" + pointTwo 
				+ ", deltax=" + this.getDeltaX() + ", deltay=" + this.getDeltaY()
				+ "]";
	}
}
