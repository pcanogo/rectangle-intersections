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
	public String toString() {
		return "[index=" + index + ", pointOne=" + pointOne + ", pointTwo=" + pointTwo + ", deltax=" + deltax
				+ ", deltay=" + deltay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deltax;
		result = prime * result + deltay;
		result = prime * result + index;
		result = prime * result + ((pointOne == null) ? 0 : pointOne.hashCode());
		result = prime * result + ((pointTwo == null) ? 0 : pointTwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			boolean result;
			result = deltax == r.deltax;
			result = deltay == r.deltay;
			result = index == r.index;
			result = pointOne == null ? false : pointOne.equals(r.pointOne);
			result = pointTwo == null ? false : pointTwo.equals(r.pointTwo);
			return result;
		}
		return false;
	}
	
    @Override
    public int compareTo(Rectangle r) {
        return this.getIndex().compareTo(r.getIndex());
    }
}
