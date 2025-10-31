package com.kata.nw.submersible.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kata.nw.submersible.SubModel.SubProbe;
import com.kata.nw.submersible.dto.ProbeStatusResponseDTO;

@Service
public class SubProbeService {

	private SubProbe probe = new SubProbe(0, 0, "NORTH");

	public ProbeStatusResponseDTO processCommands(List<String> commands) {
		for (String cmd : commands) {
			probe.executeCommand(cmd);
		}
		return new ProbeStatusResponseDTO(probe.getX(), probe.getY(), probe.getDirection(), probe.getVisitedCoordinates());
	}
}
