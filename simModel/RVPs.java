package simModel;

import cern.jet.random.Exponential;
import cern.jet.random.engine.MersenneTwister;

class RVPs 
{
	SMRepair model; // for accessing the clock
    // Data Models - i.e. random veriate generators for distributions
	// are created using Colt classes, define 
	// reference variables here and create the objects in the
	// constructor with seeds


	// Constructor
	protected RVPs(ModelName model, Seeds sd) 
	{ 
		this.model = model; 
		// Set up distribution functions
		interArrDist = new Exponential(1.0/WMEAN1,  
				                       new MersenneTwister(sd.seed1));
	}
	
	/* Random Variate Procedure for Arrivals */
	private Exponential interArrDist;  // Exponential distribution for interarrival times
	private final double WMEAN1=10.0;
	protected double duInput()  // for getting next value of duInput
	{
	    double nxtInterArr;

        nxtInterArr = interArrDist.nextDouble();
	    // Note that interarrival time is added to current
	    // clock value to get the next arrival time.
	    return(nxtInterArr+model.getClock());
	}
	
//DuType1000CallArrival()
	private int DuType1000CallArrival(){
		if(0 <= UDP.getScaledClock() < 60){
			// return next arrival time with mean 60/7
		}
		else if(60 <= UDP.getScaledClock() < 120){
			//return next arriva time with mean 60/12
		
		else if(120 <= UDP.getScaledClock() < 180){
			//return next arriva time with mean 60/10
		else if(180 <= UDP.getScaledClock() < 240){
			//return next arriva time with mean 60/7
		else if(240 <= UDP.getScaledClock() < 300){
			//return next arriva time with mean 60/5
		else if(300 <= UDP.getScaledClock() < 360){
			//return next arriva time with mean 60/4
		else if(360 <= UDP.getScaledClock() < 420){
			//return next arriva time with mean 60/5
		else if(420 <= UDP.getScaledClock() < 480){
			//return next arriva time with mean 60/4
		else if(480 <= UDP.getScaledClock() < 540){
			//return next arriva time with mean 60/3		
		}
		
	//DuType2000CallArrival()
	private int DuType2000CallArrival(){
		if(0 <= UDP.getScaledClock() < 60){
			// return next arrival time with mean 60/8
		}
		else if(60 <= UDP.getScaledClock() < 120){
			//return next arriva time with mean 60/11
		
		else if(120 <= UDP.getScaledClock() < 180){
			//return next arriva time with mean 60/8
		else if(180 <= UDP.getScaledClock() < 240){
			//return next arriva time with mean 60/9
		else if(240 <= UDP.getScaledClock() < 300){
			//return next arriva time with mean 60/6
		else if(300 <= UDP.getScaledClock() < 360){
			//return next arriva time with mean 60/4
		else if(360 <= UDP.getScaledClock() < 420){
			//return next arriva time with mean 60/3
		else if(420 <= UDP.getScaledClock() < 480){
			//return next arriva time with mean 60/3
		else if(480 <= UDP.getScaledClock() < 540){
			//return next arriva time with mean 60/2		
		}	
		
		
	}
	
      //DuType3000CallArrival()
	private int DuType1000CallArrival(){
		if(0 <= UDP.getScaledClock() < 60){
			// return next arrival time with mean 60/5
		}
		else if(60 <= UDP.getScaledClock() < 120){
			//return next arriva time with mean 60/6
		
		else if(120 <= UDP.getScaledClock() < 180){
			//return next arriva time with mean 60/5
		else if(180 <= UDP.getScaledClock() < 240){
			//return next arriva time with mean 60/4
		else if(240 <= UDP.getScaledClock() < 300){
			//return next arriva time with mean 60/3
		else if(300 <= UDP.getScaledClock() < 360){
			//return next arriva time with mean 60/3
		else if(360 <= UDP.getScaledClock() < 420){
			//return next arriva time with mean 60/2
		else if(420 <= UDP.getScaledClock() < 480){
			//return next arriva time with mean 60/2
		else if(480 <= UDP.getScaledClock() < 540){
			//return next arriva time with mean 60/1		
		}	
	}
	//DuType4000CallArrival()
	private int DuType1000CallArrival(){
		if(0 <= UDP.getScaledClock() < 60){
			// return next arrival time with mean 60/2
		}
		else if(60 <= UDP.getScaledClock() < 120){
			//return next arriva time with mean 60/3
		
		else if(120 <= UDP.getScaledClock() < 180){
			//return next arriva time with mean 60/4
		else if(180 <= UDP.getScaledClock() < 240){
			//return next arriva time with mean 60/3
		else if(240 <= UDP.getScaledClock() < 300){
			//return next arriva time with mean 60/2
		else if(300 <= UDP.getScaledClock() < 360){
			//return next arriva time with mean 60/1
		else if(360 <= UDP.getScaledClock() < 420){
			//return next arriva time with mean 60/1
		else if(420 <= UDP.getScaledClock() < 480){
			//return next arriva time with mean 60/1
		else if(480 <= UDP.getScaledClock() < 540){
			//return next arriva time with mean 60/1		
		}
}
	//uType1000Contract()
	private int uType1000Contract(){


}
