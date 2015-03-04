package lab5.carwash;


/*
 * CarFactory creates a new car
 */
public class CarFactory {
		
	private int id = 0;
	
	public Car newCar(){
		return new Car(id++);
		
	}
	
	

}
