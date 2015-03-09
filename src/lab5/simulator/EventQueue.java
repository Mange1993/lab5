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
	
	private ArrayList <Event> eventqueue= new ArrayList<Event>();
		
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
	
	 public Event pop() {
		 return eventqueue.remove(0);
	 }

    /**
     * Returns the next event in the queue.
     *
     * @return Next event in the queue, or null otherwise.
     */
    public Event next() {
        if (hasNext()) {
            return eventqueue.pop(); // fix this, does not like pop or .next()
        } else {
            return null;
        }
    }

	 /**
     * Returns a boolean if the the SortedSequence has more events or not.
     *
     * @return True if more events exist, false otherwise.
     */
    public boolean hasNext() {
        return eventqueue.size() != 0;
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
