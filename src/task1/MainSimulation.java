package task1;

import java.util.*;
import java.io.*;

public class MainSimulation extends GlobalSimulation {

	public static void main(String[] args) throws IOException {
		Event actEvent;
		State actState = new State(); // The state that should be used
		// Some events must be put in the event list at the beginning
		insertEvent(ARRIVAL, 0);
		insertEvent(MEASURE, 5);

		// The main simulation loop
		while (time < 10000) {
			actEvent = eventList.fetchEvent();
			time = actEvent.eventTime;
			actState.treatEvent(actEvent);
		}

		// Printing the result of the simulation, in this case a mean value
		System.out.println(1.0 * actState.accumulated1 / actState.noMeasurements);
		System.out.println(1.0 * actState.accumulated2 / actState.noMeasurements);
		System.out.println(
				"Probability of rejection: " + (1 - (1.0 * actState.accumulated1) / (1.0 * actState.nrOfArrivals)));
	}
}