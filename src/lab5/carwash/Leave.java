package lab5.carwash;

import lab5.simulator.EventQueue;

public class Leave {
	
	EventQueue eventqueue;
	CarWashState carState;
	
	public void run(){	
		Car Arrive =carState.getCar();
		carState.setCar(Arrive);
	
	
		
	}
	public String toString(){
			return "Leave";
}

}

