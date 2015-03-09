package carwash;

import lab5.simulator.*;

public class Leave extends Event {
	
	EventQueue eventqueue;
	CarWashState carState;
        Car car;
        
        public Leave(double time, CarWashState carState, EventQueue eventqueue, Car car){
            super.time = time;
                this.carState = carState;
		this.eventqueue = eventqueue;
		this.car = car;  
            
            
        }
	
	public void run(){
            
            // Update the state data
		carState.setCurrentEvent(this);
		carState.setTime(time);
		carState.updateIdleTime();
		carState.updateQueueTime();
		carState.setCar(car);
            
                 // changes view
                        carState.setChanged();
                        carState.notifyObservers();
                        
                        // if queue is not empty, schedule a new leave event
                        // else, increase available washers
                        
                        
            
		
	
	
		
	}
	public String toString(){
			return "Leave";
}

}

