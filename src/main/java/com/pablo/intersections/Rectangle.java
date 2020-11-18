package com.pablo.intersections;

public class Rectangle implements Comparable<Rectangle>{
	private final Integer index;
	public final Point pointOne;
	public final Point pointTwo;
	private final int deltax;
	private final int deltay;
	
	public Rectangle(int index, int x, int y, int deltax, int deltay) {
		this.index = index;
		this.pointOne = new Point(x,y);
		this.pointTwo = new Point(x + deltax, y + deltay);
		this.deltax = deltax;
		this.deltay = deltay;
	}
	
	@Override
	public String toString() {
		return 	this.index 
				+ ": Rectangle at " + this.pointOne.toString()
				+ ", delta_x=" + this.deltax
				+ ", delta_y=" + this.deltay + ".";
	}

	public Integer getIndex() {
		return this.index;
	}
	
	public int getDeltaX() {
		return this.deltax;
	}

	public int getDeltaY() {
		return this.deltay;
	}


	
	
    @Override
    public int compareTo(Rectangle r) {
        return this.getIndex().compareTo(r.getIndex());
    }
}
