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
	
	
        public Arrive(double time, CarWashState carState, EventQueue eventqueue){
            super.time =time;
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
                        if(carState.emptyFastwash > 0  && carState.emptyFastwash < totalfastwsash ){
                            carState.emptyFastWash--;
                            boolean fastwash = true;
                        	double finishtime = carState.NewFastWashTime();
                        }
                        else if(carState.emptySlowtwash > 0 && carState.emptySlowtwash < totalslowwash ){
                            carState.emptyFSlowWash--;
                        	   double finishtime = carState.NewSlowWashTime();
                        	     boolean fastwash = false;
                        }
                        
                        
                     
        
                        //car in machine leves queue
                  Car cleaning = carState.Carqueue.first();
                            carState.Carqueue.remove();
                            
                            
                            
                            
                            
                            //new leave event is scheduled, when wash is finished.
                            Leave carLeave = new Leave(finishtime ,carState, eventqueue, cleaning,fastwash);
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


