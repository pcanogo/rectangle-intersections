package com.pablo.intersections;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.pablo.intersections.JsonRectangles.JsonRectangle;

public final class RectangleFactory {

	public static IntersectRectangle getIntersectRectangle(int index, Point[] points, Rectangle[] parents) {
		int deltax = points[1].getX() - points[0].getX();
		int deltay = points[1].getY() - points[0].getY();

		Set<Rectangle> allParents = RectUtils.getParents(parents[0], parents[1]);

		return new IntersectRectangle(index, points[0].getX(), points[0].getY(), deltax, deltay, allParents);
	}

	public static List<Rectangle> rectanglesFromFile(String filePath) {
		Gson gson = new Gson();
		List<Rectangle> rects = new ArrayList<Rectangle>();
		try (Reader reader = new FileReader(filePath)) {
			try {
				List<JsonRectangle> rectangles = gson.fromJson(reader, JsonRectangles.class).rects;
				for (int i = 0; i < rectangles.size(); i++) {
					Rectangle rect = new Rectangle(i + 1, rectangles.get(i));
					rects.add(rect);
				}
			} catch (JsonSyntaxException e) {
				System.err.println("Wrong JSON format in file");
			} catch (JsonParseException e) {
				System.err.println("Cannot parse JSON file");
			}
		} catch (IOException | JsonIOException e) {
			throw new IllegalStateException(e);
		}

		return rects;
	}
}
