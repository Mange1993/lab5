package lab5.main;

import lab5.carwash.CarWashState;
import lab5.simulator.EventQueue;
import lab5.simulator.Simulator;

public class MainSim {

	public static void main(String[] args) {
		
		EventQueue eventqueue = new EventQueue();
		
		CarWashState state1 = new CarWashState(2,2);
		state1.FastCarWash(2.8,4.6, 1234);
		state1.SlowCarWash(3.5, 6.7, 1234);
		state1.changeMaxQueueSize(5);
		
		Simulator simulation = new Simulator(eventqueue);
		simulation.run();
	}

}
