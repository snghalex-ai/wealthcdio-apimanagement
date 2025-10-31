package com.kata.nw.submersible.SubModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SubProbe {

	private int x, y;
	private String direction;
	private final int gridWidth = 10;
	private final int gridHeight = 10;
	private final Set<String> obstacles = Set.of("2,2", "3,4");
	private final List<String> visitedCoordinates = new ArrayList<>();

	public SubProbe(int startX, int startY, String startDirection) {
		this.x = startX;
		this.y = startY;
		this.direction = startDirection;
		visitedCoordinates.add(x + "," + y);
	}

	public void executeCommand(String command) {
		switch (command.toUpperCase()) {
		case "MOVE_FORWARD" -> move(1);
		case "MOVE_BACKWARD" -> move(-1);
		case "TURN_LEFT" -> turnLeft();
		case "TURN_RIGHT" -> turnRight();
		}
	}

	private void move(int step) {
		int newX = x, newY = y;
		switch (direction) {
		case "NORTH" -> newY += step;
		case "SOUTH" -> newY -= step;
		case "EAST" -> newX += step;
		case "WEST" -> newX -= step;
		}

		if (isValidMove(newX, newY)) {
			x = newX;
			y = newY;
			visitedCoordinates.add(x + "," + y);
		}
	}

	private boolean isValidMove(int newX, int newY) {
		boolean withinBounds = newX >= 0 && newX < gridWidth && newY >= 0 && newY < gridHeight;
		boolean notObstacle = !obstacles.contains(newX + "," + newY);
		return withinBounds && notObstacle;
	}

	private void turnLeft() {
		direction = switch (direction) {
		case "NORTH" -> "WEST";
		case "WEST" -> "SOUTH";
		case "SOUTH" -> "EAST";
		case "EAST" -> "NORTH";
		default -> direction;
		};
	}

	private void turnRight() {
		direction = switch (direction) {
		case "NORTH" -> "EAST";
		case "EAST" -> "SOUTH";
		case "SOUTH" -> "WEST";
		case "WEST" -> "NORTH";
		default -> direction;
		};
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}

	public List<String> getVisitedCoordinates() {
		return visitedCoordinates;
	}

}
