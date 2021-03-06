package lab5.simulator;

/**
 * 
 * Simulator "startEvent"
 * Should tell the simulator to start, can only execute when simulator.run() is called.
 *
 */
public class Start extends Event {

	    public Start(double time) {
	        super("Start", time);
	    }
	    @Override
	    public void execute(Simulator sim) {
	        super.execute(sim);
	}
}
