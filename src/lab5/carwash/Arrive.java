package lab5.carwash;
import lab5.simulator.*;
/**
 * Class for the Event Carr arrives
 * @author Sara(test)2
 */
public class Arrive extends Event {
	
	//CarWashState carState;
	EventQueue eventqueue;
	CarWashState carState;
	private double time;
	
	public void run(){	
			Car Arrive =carState.getCar();
			carState.setCar(Arrive);
		
			if (carState.queueFull()){
				carState.TotalRejected++;
			} else{
				carState.Carqueue.add(Arrive);
				carState.totalcars++;
			}
	
		}
	public String toString(){
		if (carState.queueFull()){
			return "Rejected";
		}else{
			return "Arrive";
		}
	}
	}


