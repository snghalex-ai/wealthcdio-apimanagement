package com.kata.nw.submersible.service;

import java.util.List;

import com.kata.nw.submersible.dto.ProbeStatusResponseDTO;

public interface ISubProbeService {
	
	ProbeStatusResponseDTO processCommands(List<String> commands);
}
