package com.pablo.intersections;

import java.util.List;

public class IntersectRectangle extends Rectangle{

	private List<Rectangle> parents;

	public IntersectRectangle(int index, int x, int y, int deltax, int deltay, List<Rectangle> parents) {
		super(index, x,y, deltax, deltay);
		this.parents =  parents;
	}
	
	public List<Rectangle> getParents(){
		return this.parents;
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
