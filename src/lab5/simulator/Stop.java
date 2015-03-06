package lab5.simulator;

/**
 *Stop that stops the current simulation that it is being processed in. 
 *
 */
public class Stop extends Event {
		   public Stop(double time) {
			   super("Stop", time);
		    }
		    @Override
		    public void execute(Simulator sim) {
		        super.execute(sim);
		        sim.stop();
		    }
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
	}
}
