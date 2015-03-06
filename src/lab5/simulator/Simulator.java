package lab5.simulator;

public class Simulator {
	private EventQueue eq;
	private boolean running = false;
	
	public void run(){
		
		while(!(eq.eventqueue.isEmpty())){
			Event thisevent = eq.getFirstEvent();
			eq.removeFirstEvent();
			thisevent.run();
		}
	}

	public void stop() {
		running = true;
	}
}
