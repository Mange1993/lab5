package lab5.simulator;

import java.util.*;

public abstract class Simview implements Observer{
	
	public Simview(SimState state){
	
	state.addObserver(this);
	}
	
	public void update(Observable arg,  Object arg1 ){
 
}
}