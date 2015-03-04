package lab5.carwash;
import lab5.simulator.*;
/**
 * Class for the Event that a Car arrives
 * @author Sara
 */
public class Arrive extends Event {
	
	//CarWashState carState;
	EventQueue eventqueue;
	CarWashState carState;
	private double time;
	
        /*
        Method that executes the Arrive Event
        */
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


