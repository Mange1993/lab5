package lab5.simulator;

import java.util.*;


/**
 * Class that keeps track of the future events that are about to happen
 * @author Magnus Wahllöf
 * @author Johan Hammas
 * @author Sara Nilsson
 *
 */
public class EventQueue {
	
	ArrayList <Event> eventqueue= new ArrayList<Event>();
		
	/**
	 * Event added to queue
	 *@param event event to be added to queue
	 */
	public void addEvent(Event event) {
		eventqueue.add(event);
	}
	/**
	 * 
	 * @return queue size
	 */
	public int size(){
		return eventqueue.size();
	}
	/**
	 * Is the queue empty?
	 * @return true if queue is empty, otherwise false
	 */
	public boolean isEmpty(){
		if (eventqueue.size() ==0){
			return true;
		}return false;
	}
	/**
	 * Removes the first event from the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public void removeFirstEvent()throws NoSuchElementException {
		if(eventqueue.isEmpty()){
			throw new NoSuchElementException();
		}else{
			eventqueue.remove(0);
		}
	}
	/**
	 * 
	 * @return the first event in the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public Event getFirstEvent() throws NoSuchElementException{
		if(eventqueue.isEmpty()){
			throw new NoSuchElementException();
		}else{
			return eventqueue.get(0);
		}
	}
	

	}
	
	
	
	
	
	
