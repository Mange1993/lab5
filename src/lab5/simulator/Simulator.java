package lab5.simulator;

public class Simulator {

    private boolean _running = false;

    private SimState _simState;
    private Simview _simView;

    private EventQueue _queue;

    public Simulator(SimState simState, Simview simView) {
        _simState = simState;
        _simView = simView;

        _queue = new EventQueue();
    }

    public Simulator(SimState simState, Simview simView, EventQueue queue) {
        _simState = simState;
        _simView = simView;

        _queue = queue;
    }

    /**
     * Sets the running state to true, queues a StartEvent at time 0, and starts the event loop
     */
    public void run() {
        _running = true;

        enqueue(new Start(0));

        while(_queue.hasNext() && _running) {
            Event e = _queue.next();
            _simState.setEvent(e);
            e.execute(this);
        }
    }

    /**
     * Sets the running state to false, effectively stopping the event loop
     */
    public void stop() {
        _running = false;
    }

    /**
     * Shorthand method to queue an event in the Simulators event queue
     *
     * @param event The event to queue
     */
    public void enqueue(Event event) {
        _queue.addEvent(event);
    }

    /**
     * Returns the current state of the simulator
     *
     * @return SimState or a deriviate of SimState
     */
    public SimState getState() {
        return _simState;
    }
}
