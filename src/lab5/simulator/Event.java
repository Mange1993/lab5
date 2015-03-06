package lab5.simulator;

/**
 * An abstract named and timed Event representation. References the simulator.
 */

public abstract class Event {
	
	public abstract void run();
		
	public abstract String toString();
	
	protected String _type;
	protected double _time;
    protected Simulator _simulator;
    
    public Event(String type, double time) {
        _type = type;
        _time = time;
    }

	public void execute(Simulator sim) {
        _simulator = sim;
    }
}
