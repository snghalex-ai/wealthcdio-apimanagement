package com.kata.nw.submersible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.nw.submersible.dto.ProbeStatusResponseDTO;
import com.kata.nw.submersible.dto.SubCommandRequestDTO;
import com.kata.nw.submersible.service.ISubProbeService;

@RestController
@RequestMapping("/api/v1/probe")
public class SubProbeController {

	@Autowired
	private ISubProbeService probeService;

	@PostMapping("/move")
	public ResponseEntity<ProbeStatusResponseDTO> move(@RequestBody SubCommandRequestDTO request) {
		return ResponseEntity.ok(probeService.processCommands(request.getCommands()));
	}	
}
