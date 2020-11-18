package com.pablo.intersections;

import java.util.Arrays;
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
		String parentString = createParentString();
		
		return this.getIndex() 
				+ ": Between rectangle " + parentString
				+ " at " + pointOne 
				+ ", delta_x=" + this.getDeltaX() 
				+ ", delta_y=" + this.getDeltaY()
				+ ".";
	}
	
	private String createParentString() {
		String parentString = "";
		int length = this.parents.size();
		Rectangle[] parentArray = this.parents.toArray(new Rectangle[length]);
		Arrays.sort(parentArray);
		for (int i=0; i < parentArray.length - 2; i++) {
			parentString += parentArray[i].getIndex() + ", ";
		}
		parentString += parentArray[length - 2].getIndex();
		parentString += " and " + parentArray[length - 1].getIndex();
		return parentString;
	}
}
