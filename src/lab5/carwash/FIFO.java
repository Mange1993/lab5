package lab5.carwash;

import java.util.NoSuchElementException;
import java.util.*;
/**
 * Class FIFO implementing a First in First Out queue
*/
public class FIFO {
	ArrayList <Car> FIFOlst= new ArrayList<Car>();
	int FIFOsize;
	private int maxsize = 5;

	public void add(Car arg0) {
		FIFOlst.add(arg0);

	}

	public Car first() throws NoSuchElementException {
		if(FIFOlst.size()==0){
			throw new NoSuchElementException("The queue is empty");
		}
		return FIFOlst.get(0);
	}

	public boolean isEmpty() {
		if (FIFOlst.size()==0){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if (FIFOlst.size()== maxsize){
			return true;
		}
		return false;
	}



	public void remove() throws NoSuchElementException {
		if (FIFOlst.size()==0){
			throw new NoSuchElementException("The queue is empty");
		}
		try{
			FIFOlst.remove(FIFOlst.get(0));
		}
		catch(NoSuchElementException e){
			System.out.println("The queue is empty");
		}
	}

	public int size() {
		return FIFOlst.size();
	}
	
	
	public String toString(){
		String Queue ="Queue: ";
		for (Car item:FIFOlst){
			Queue = Queue +"(" + String.valueOf(item) + ") ";
		}
		return Queue;

	}





}
