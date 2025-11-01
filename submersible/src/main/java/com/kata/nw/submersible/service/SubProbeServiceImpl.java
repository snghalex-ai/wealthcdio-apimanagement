package com.kata.nw.submersible.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kata.nw.submersible.dto.ProbeStatusResponseDTO;

@Service
public class SubProbeServiceImpl implements ISubProbeService {

	private Integer xAxis, yAxis;
	private String direction;
	private final Integer gridWidth = 10;
	private final Integer gridHeight = 10;
	private final Set<String> obstacles = Set.of("2,2", "3,4");
	private final List<String> visitedCoordinates = new ArrayList<>();

	public SubProbeServiceImpl() {
		this.xAxis = 0;
		this.yAxis = 0;
		this.direction = "NORTH";
		visitedCoordinates.add(xAxis + "," + yAxis);
	}

	private void executeCommand(String command) {
		switch (command.toUpperCase()) {
		case "MOVE_FORWARD" -> move(1);
		case "MOVE_BACKWARD" -> move(-1);
		case "TURN_LEFT" -> turnLeft();
		case "TURN_RIGHT" -> turnRight();
		}
	}

	private void move(Integer nextStep) {
		Integer newX = xAxis, newY = yAxis;

		switch (direction) {
		case "NORTH" -> newY = newY + nextStep;
		case "SOUTH" -> newY = newY - nextStep;
		case "EAST" -> newX = newX + nextStep;
		case "WEST" -> newX = newX - nextStep;
		}

		if (isValidMoveOrWithoutObstaclesAhead(newX, newY)) {
			xAxis = newX;
			yAxis = newY;
			visitedCoordinates.add(xAxis + "," + yAxis);
		}
	}

	private boolean isValidMoveOrWithoutObstaclesAhead(Integer newX, Integer newY) {

		boolean withinBounds = false, notObstacle = false, isValid = false;

		if (newX >= 0 && newX < gridWidth && newY >= 0 && newY < gridHeight)
			withinBounds = true;
		if (!obstacles.contains(newX + "," + newY))
			notObstacle = true;
		if (withinBounds && notObstacle) {
			isValid = true;
		}
		return isValid;
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

	@Override
	public ProbeStatusResponseDTO processCommands(List<String> commands) {

		if (commands == null || commands.isEmpty()) {
			throw new IllegalArgumentException("Command list cannot be empty");
		}

		for (String cmd : commands) {
			executeCommand(cmd);
		}
		return new ProbeStatusResponseDTO(xAxis, yAxis, direction, visitedCoordinates);
	}
}
