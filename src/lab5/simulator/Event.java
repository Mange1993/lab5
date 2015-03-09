package lab5.simulator;

/**
 * An abstract named and timed Event representation. References the simulator.
 */

public abstract class Event {
	
    protected String _type;
    protected double _time;
    protected Simulator _simulator;
    protected double _time;
    
    public double getTime(){
    	return _time;
    }
    
    public Event(String type, double time) {
        _type = type;
        _time = time;
    }
    /**
     * Executes the event, supposed to be overridden and called by super.
     * @param sim The simulator executing the event.
     */
    public void execute(Simulator sim) {
        _simulator = sim;
    }
}
