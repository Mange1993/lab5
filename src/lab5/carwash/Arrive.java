package carwash;
import lab5.simulator.*;

/**
 * Class for the Event that a Car arrives
 * @author Sara
 */
public class Arrive extends Event {
	
	//CarWashState carState;
	EventQueue eventqueue;
	CarWashState carState;
	Event time;
	
        public Arrive(double _time, CarWashState carState, EventQueue eventqueue){
            super._time =time;
            this.carState = carState;
            this.eventqueue =eventqueue;
        }
        
        
        
        /*
        Method that executes the Arrive Event
        */
	public void run(){
            
            
            //A new car is made and arrives
			Car Arrive =carState.getCar();
			carState.setCar(Arrive);
                        
                        // changes view
                        carState.setChanged();
                        carState.notifyObservers();
                        
                        //Checks whether the queue is full or if car can be added
			if (carState.queueFull()){
				carState.TotalRejected++;
			} else{
				carState.Carqueue.add(Arrive);
				carState.totalcars++;
			}
                        
                        
                        //check to see if fast wash or slow wash is available
                       if(carState.washers()){
                        if(carState.emptyFastwash > 0 ){
                            carState.emptyFastWash--;}
                        else if(carState.emptySlowtwash >0 ){
                            carState.emptyFSlowWash--;}
                        
        
                        //car in machine leves queue
                  Car cleaning = carState.Carqueue.first();
                            carState.Carqueue.remove();
                            
                            
                            //new leave event is scheduled, when wash is finished.
                            Leave carLeave = new Leave();
                            eventqueue.add(carLeave);
	
		}
                       // New arrival
                       	Arrive nextArrive = new Arrive(carState.getNextArrivalTime(),
				carState, eventqueue);
		eventqueue.addEvent(nextArrive);
        
        }
        
       
        
	public String toString(){
		if (carState.queueFull()){
			return "Rejected";
		}else{
			return "Arrive";
		}
	}
	}


