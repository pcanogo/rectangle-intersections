package com.pablo.intersections;

import java.util.Set;
import java.util.stream.Collectors;

public class IntersectRectangle extends Rectangle{

	private Set<Rectangle> parents;

	public IntersectRectangle(int index, int x, int y, int deltax, int deltay, Set<Rectangle> parents) {
		super(index, x, y, deltax, deltay);
		this.parents =  parents;
	}
	
	public Set<Rectangle> getParents(){
		return this.parents;
	}
	
	public Set<Integer> getParentsIndex(){
		return parents.stream().map(Rectangle::getIndex).collect(Collectors.toSet());
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
				+ ", parents=[" + parentsIndexes + "]"
				+ ", pointOne=" + pointOne + ", pointTwo=" + pointTwo 
				+ ", deltax=" + this.getDeltaX() + ", deltay=" + this.getDeltaY()
				+ "]";
	}
}
