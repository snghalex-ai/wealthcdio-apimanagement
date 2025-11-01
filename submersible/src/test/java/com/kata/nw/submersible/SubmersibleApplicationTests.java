package com.kata.nw.submersible;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.nw.submersible.dto.ProbeStatusResponseDTO;
import com.kata.nw.submersible.service.ISubProbeService;

@SpringBootTest
class SubmersibleApplicationTests {

	@Autowired
	private ISubProbeService probeService;

	@Test
	public void testMoveForwardSuccess() {
		List<String> commands = List.of("MOVE_FORWARD");
		ProbeStatusResponseDTO response = probeService.processCommands(commands);
		assertEquals(0, response.getxAxis());
		assertEquals(1, response.getyAxis());
		assertEquals("NORTH", response.getDirection());
	}

	@Test
	public void testTurnLeft() {
		List<String> commands = List.of("TURN_LEFT");
		ProbeStatusResponseDTO response = probeService.processCommands(commands);
		assertEquals("SOUTH", response.getDirection());
		assertEquals(0, response.getxAxis());
		assertEquals(0, response.getyAxis()); 
	}

	@Test
	public void testEmptyCommandList_throwsException() {
		List<String> emptyCommands = Collections.emptyList();

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			probeService.processCommands(emptyCommands);
		});
		assertEquals("Command list cannot be empty", exception.getMessage());
	}

	@Test
	public void testNullCommandList_throwsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			probeService.processCommands(null);
		});
		assertEquals("Command list cannot be empty", exception.getMessage());
	}

	@Test
	public void testObstacleBlock() {
		// Should not move to 2/2 so last should be 1,2 combination
		List<String> commands = List.of("MOVE_FORWARD", "TURN_RIGHT", "MOVE_FORWARD", "MOVE_FORWARD" );
		ProbeStatusResponseDTO response = probeService.processCommands(commands);
		assertEquals("EAST", response.getDirection());
		assertEquals(1, response.getxAxis());
		assertEquals(2, response.getyAxis()); 
	}

	@Test
	public void testXBoundaryBlock() {
		// Should not move below grid -1,0, last will be 0,0
		List<String> commands = List.of("TURN_LEFT", "MOVE_FORWARD", "MOVE_FORWARD");
		ProbeStatusResponseDTO response = probeService.processCommands(commands);
		assertEquals("WEST", response.getDirection());
		assertEquals(0, response.getxAxis()); 
		assertEquals(0, response.getyAxis());
	}
	
	@Test
	public void testYBoundaryBlock() {
		// Should not move below grid 0,-1, last will be 1,0
		List<String> commands = List.of("TURN_LEFT", "MOVE_BACKWARD", "MOVE_BACKWARD");
		ProbeStatusResponseDTO response = probeService.processCommands(commands);
		assertEquals("NORTH", response.getDirection());
		assertEquals(1, response.getxAxis()); 
		assertEquals(0, response.getyAxis());
	}

}
