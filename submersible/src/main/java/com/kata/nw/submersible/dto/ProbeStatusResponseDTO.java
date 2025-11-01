package com.kata.nw.submersible.dto;

import java.util.List;

public class ProbeStatusResponseDTO {

	private Integer xAxis;
	private Integer yAxis;
	private String direction;
	private List<String> visitedCoordinates;

	public ProbeStatusResponseDTO(Integer xAxis2, Integer yAxis2, String direction2, List<String> visitedCoordinates2) {
		this.xAxis= xAxis2;
		this.yAxis = yAxis2;
		this.direction = direction2;
		this.visitedCoordinates = visitedCoordinates2;		
	}

	public Integer getxAxis() {
		return xAxis;
	}

	public void setxAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}

	public Integer getyAxis() {
		return yAxis;
	}

	public void setyAxis(Integer yAxis) {
		this.yAxis = yAxis;
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
