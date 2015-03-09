package carwash;

import lab5.simulator.*;

public class Leave extends Event {
	
	EventQueue eventqueue;
	CarWashState carState;
        Car car;
        boolean fastwasher = false;
        
        public Leave(double time, CarWashState carState, EventQueue eventqueue, Car car){
            super.time = time;
                this.carState = carState;
		this.eventqueue = eventqueue;
		this.car = car;  
		this.fastwash = fastwash
            
            
        }
	/*
	*checks if there are any cars in line to the washers, if there are, a new leveevent is scheduled 
	*/
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
                        if(!(carState.Carqueue.isEmpty)){
                        	if(fastwash){
                        		carState.ewmptyFastwash ++;
                        	}
                        	else{ carState.ewmptySlowwash ++;
                        }
                        else{
                        	if(fastwash){
                        	 double finishtime = carState.NewFastWashTime();                        	}
                        }else{ finishtime = carState.NewSlowWashTime();
            
			 Car cleaning = carState.Carqueue.first();
		 	carState.Carqueue.remove();
	
			
			 Leave carLeave = new Leave(finishtime ,carState, eventqueue, cleaning,fastwash);
				eventqueue.add(carLeave);
	
		
	}
	public String toString(){
			return "Leave";
}

}

