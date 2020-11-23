package com.pablo.intersections;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectRectangle extends Rectangle {

	private Set<Rectangle> parents;

	public IntersectRectangle(int index, int x, int y, int deltax, int deltay, Set<Rectangle> parents) {
		super(index, x, y, deltax, deltay);
		this.parents = parents;
	}

	public Set<Rectangle> getParents() {
		return this.parents;
	}

	public Set<Integer> getParentsIndex() {
		return parents.stream().map(Rectangle::getIndex).collect(Collectors.toSet());
	}

	public boolean isChildOf(Rectangle rect) {
		return parents.stream().anyMatch(r -> r.equals(rect));
	}

	@Override
	public String toString() {
		String parentString = createParentString();

		return this.index + ": Between rectangle " + parentString + " at " + pointOne + ", delta_x=" + this.deltax
				+ ", delta_y=" + this.deltay + ".";
	}

	private String createParentString() {
		int length = this.parents.size();
		List<Rectangle> sortedParents = this.parents.stream().sorted().collect(Collectors.toList());
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sortedParents.size() - 2; i++) {
			builder.append(sortedParents.get(i).getIndex() + ", ");
		}
		builder.append(sortedParents.get(length - 2).getIndex());
		builder.append(" and " + sortedParents.get(length - 1).getIndex());
		return builder.toString();
	}
}
