package com.pablo.intersections;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
			JsonElement input = JsonParser.parseReader(reader);
			JsonObject inputObject = input.getAsJsonObject();
			JsonArray inputRects = inputObject.get("rects").getAsJsonArray();
			for (int i = 0; i < inputRects.size(); i++) {
				JsonRectangle r = gson.fromJson(inputRects.get(i), JsonRectangle.class);
				Rectangle rect = new Rectangle(i + 1, r);
				rects.add(rect);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rects;
	}
}
