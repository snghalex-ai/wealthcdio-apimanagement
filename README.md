# wealthcdio-apimanagement
# Description
This application is for submersbible Probe where an object can be moved starting from NORTH, (0,0) coordinates which is by default setting
to any 4 directions (NORTH, SOUTH, EAST, EAST)** one step each move** through valid commands in ["MOVE_FORWARD", "TURN_LEFT", "MOVE_BACKWARD", "TURN_RIGHT"].
**Every API request will be able to present** 
	1. coordinates of current position
	2. Current Direction Facing
	3. All visited coordinates so far.
	
# Environment and Setup
# Tomcat Configuration
Port : 8080

# Build
	MAVEN -e clean install
	
# API for Use Step
1. POST: http://localhost:8080/api/v1/auth/login (Generates JWT Token)
   Body: {
          "userName":"John"
         }
2. POST: http://localhost:8080/api/v1/probe/move (Accepts List of 4 Valid Commands, Can be single command or multiple)
   Auth: Bearer Token: Take from 1st login request, else it will give exception of Invalidation.
   Body: {
          "commands": ["MOVE_FORWARD", "TURN_LEFT", "MOVE_BACKWARD", "TURN_RIGHT"]
         }
   Response: {
		"xAxis": 0,
		"yAxis": 0,
		"direction": "WEST",
		"visitedCoordinates": [
			"0,0",
			"0,1",
			"0,0"]
		}
3. GET: http://localhost:8080/actuator/health (Actuator for health)
