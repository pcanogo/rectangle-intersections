package com.pablo.intersections;

public class Rectangle implements Comparable<Rectangle> {
	private final Integer index;
	public final Point pointOne;
	public final Point pointTwo;
	private final int delta_x;
	private final int delta_y;

	public Rectangle(int index, int x, int y, int delta_x, int delta_y) {
		this.index = index;
		this.pointOne = new Point(x, y);
		this.pointTwo = new Point(x + delta_x, y + delta_y);
		this.delta_x = delta_x;
		this.delta_y = delta_y;
	}

	public Rectangle(int index, JsonRectangle r) {
		this.index = index;
		this.pointOne = new Point(r.getX(), r.getY());
		this.pointTwo = new Point(r.getX() + r.getDelta_x(), r.getY() + r.getDelta_y());
		this.delta_x = r.getDelta_x();
		this.delta_y = r.getDelta_y();
	}

	@Override
	public String toString() {
		return this.index + ": Rectangle at " + this.pointOne.toString() + ", delta_x=" + this.delta_x + ", delta_y="
				+ this.delta_y + ".";
	}

	public Integer getIndex() {
		return this.index;
	}

	public int getDeltaX() {
		return this.delta_x;
	}

	public int getDeltaY() {
		return this.delta_y;
	}

	@Override
	public int compareTo(Rectangle r) {
		return this.getIndex().compareTo(r.getIndex());
	}
}
