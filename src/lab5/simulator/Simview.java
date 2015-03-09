package lab5.simulator;


import java.util.Observable;
import java.util.Observer;

/**
 * An abstraction of a View for the Simulator.
 * The constructor adds the View as an observer to the state.
 */
public abstract class Simview implements Observer {
    public Simview(SimState state) {
        state.addObserver(this);
    }
}
