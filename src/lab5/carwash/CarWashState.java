package lab5.carwash;
import lab5.simulator.*;


public class CarWashState extends SimState {
	public int TotalRejected = 0;
	public int totalcars=0;
	//public static final int CLEAN =0, DIRTY =1;
	private double queuetime, idletime, currenttime;
	private Car currentcar;
	private  int maxQueueSize = 5;


	private CarFactory CarFactory = new CarFactory();

	//random str
	private double lambda = 2;
	private long seed = 1234;
	private double[] fastDB = new double[]{2.8 , 4.6};
	private double[] slowDB = new double[]{3.5 , 6.7};
	private UniformRandomStream fastmachine;
	private UniformRandomStream slowmachine;
	private ExponentialRandomStream randomE;
	
	private int totalfastwash = 2;
	private int totalslowwash = 2;
	protected int emptyFastwash;
	protected int emptySlowwash;
	
	public FIFO Carqueue = new FIFO();

	private Event previousEvent;
	private Event currentEvent;
	

	public double getQueueTime(){
		return queuetime;
	}

	public double getIdleTime(){
		return idletime;
	}

	private int getQueueSize(){
		return Carqueue.size();	
	}
	private void changeMaxQueueSize(int maxsize){
		maxsize=maxQueueSize;
	}

	public boolean queueFull(){
		if(Carqueue.isFull()){
			return true;
		}
		return false;

	}
	/**
	 * make new car from car factory
	 * @return new car
	 */
	public Car getCar(){
		return CarFactory.newCar(); 	
	}
	/**
	 * 
	 * @return current car
	 */
	public Car currentCar(){
		return currentcar ;
	}
	/**
	 * set the car to the currentcar
	 * @param car 
	 */
	public void setCar(Car car){
		currentcar=car;
	}
	/**
	 * 
	 * @return Totalrejected
	 */
	public int Rejections(){
		return TotalRejected ;

	}
	/**
	 * 
	 * @return currentEvent
	 */
	public Event getcurrentEvent(){
		return currentEvent;
	}
	/**
	 * 
	 * @return lambda
	 */
	public double getLambda(){
		return lambda;
	}
	/**
	 * 
	 * @return seed
	 */
	public long getSeed(){
		return seed;
	}
	/**
	 * 
	 * @param lower
	 * @param upper
	 * @param seed
	 */
	
	public void FastCarWash(double lower,double upper,long seed){
		fastDB[0]=lower;
		fastDB[1]=upper;
		this.seed=seed;
		fastmachine= new UniformRandomStream(lower,upper,seed);
	}
	/**
	 * 
	 * @param lower
	 * @param upper
	 * @param seed
	 */
	public void SlowCarWash(double lower,double upper,long seed){
		slowDB[0]=lower;
		slowDB[1]=upper;
		this.seed=seed;
		slowmachine= new UniformRandomStream(lower,upper,seed);
	}
	/**
	 * 
	 * @return slow wash distribution
	 */
	public double[] getSlowDist(){
		return slowDB;
		
	}
	/**
	 * 
	 * @return fast wash distribution
	 */
	public double[] getFastDist(){
		return fastDB;
	}
	
	
	
	
}



