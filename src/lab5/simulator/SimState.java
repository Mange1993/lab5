package lab5.simulator;


import java.util.Observable;

/**
 * Represents the state of a Simulator
 * Handles Events and Times
 */
public abstract class SimState extends Observable {

    protected int numEvents;
    protected Event lastEvent;
    protected Event currentEvent;

    /**
     * Set current event and notify observers.
     *
     * @param e The event to set.
     */
    public void setEvent(Event e) {
        setEvent(e, true);
    }

    /**
     * Set current event and determine wheter to notify observers.
     * Always sets the Observable to changed in any case.
     *
     * @param e The event to set.
     * @param notify A boolean representing wheter to notify observers or not.
     */
    public void setEvent(Event e, boolean notify) {
        lastEvent = currentEvent;
        currentEvent = e;
        numEvents++;

        setChanged();
        if(notify) {
            notifyObservers();
        }
    }

    public Event getEvent() {
        return currentEvent;
    }

    public int getNumEvents() {
        return numEvents;
    }

    /**
     * Get the time of the current event.
     *
     * @return Time of current event expressed as a double.
     */
    public double getTime() {
        return currentEvent.getTime();
    }

    /**
     * Returns the deltaTime between the last event and the current event.
     * If there is no lastEvent, lastEvent.time is assumed to be 0.
     *
     * @return DeltaTime between currentEvent and lastEvent, expressed as a double.
     */
    public double getDeltaTime() {
        return currentEvent.getTime() - (lastEvent != null ? lastEvent.getTime() : 0);
    }
}
