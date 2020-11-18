package com.pablo.intersections;

public class JsonRectangle {
	private int x;
	private int y;
	private int delta_x;
	private int delta_y;

	public JsonRectangle(int x, int y, int delta_x, int delta_y) {
		this.x = x;
		this.y = y;
		this.delta_x = delta_x;
		this.delta_y = delta_y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDelta_x() {
		return delta_x;
	}

	public int getDelta_y() {
		return delta_y;
	}
}
