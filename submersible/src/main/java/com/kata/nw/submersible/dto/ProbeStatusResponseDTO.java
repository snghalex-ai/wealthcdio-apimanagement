package com.kata.nw.submersible.dto;

import java.util.List;

public class ProbeStatusResponseDTO {

	private int x;
	private int y;
	private String direction;
	private List<String> visitedCoordinates;

	public ProbeStatusResponseDTO(int x2, int y2, String direction2, List<String> visitedCoordinates2) {
		this.x= x2;
		this.y = y2;
		this.direction = direction2;
		this.visitedCoordinates = visitedCoordinates2;
				
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<String> getVisitedCoordinates() {
		return visitedCoordinates;
	}

	public void setVisitedCoordinates(List<String> visitedCoordinates) {
		this.visitedCoordinates = visitedCoordinates;
	}

}
