package simModel;

import cern.jet.random.*;
import cern.jet.random.engine.MersenneTwister;

class RVPs 
{
	SMRepair model; // for accessing the clock
	private Exponential interArrDistT1000;  // Exponential distribution for interarrival times
	private Exponential interArrDistT2000;  // Exponential distribution for interarrival times
	private Exponential interArrDistT3000;  // Exponential distribution for interarrival times
	private Exponential interArrDistT4000;  // Exponential distribution for interarrival times
	
	private final double T1000_MEAN1 = 60/7;
	private final double T1000_MEAN2 = 60/12;
	private final double T1000_MEAN3 = 60/10;
	private final double T1000_MEAN4 = 60/7;
	private final double T1000_MEAN5 = 60/5;
	private final double T1000_MEAN6 = 60/4;
	private final double T1000_MEAN7 = 60/5;
	private final double T1000_MEAN8 = 60/4;
	private final double T1000_MEAN9 = 60/3;
	
	private final double T2000_MEAN1 = 60/8;
	private final double T2000_MEAN2 = 60/11;
	private final double T2000_MEAN3 = 60/8;
	private final double T2000_MEAN4 = 60/9;
	private final double T2000_MEAN5 = 60/6;
	private final double T2000_MEAN6 = 60/4;
	private final double T2000_MEAN7 = 60/3;
	private final double T2000_MEAN8 = 60/3;
	private final double T2000_MEAN9 = 60/2;
	
	private final double T3000_MEAN1 = 60/5;
	private final double T3000_MEAN2 = 60/6;
	private final double T3000_MEAN3 = 60/5;
	private final double T3000_MEAN4 = 60/4;
	private final double T3000_MEAN5 = 60/3;
	private final double T3000_MEAN6 = 60/3;
	private final double T3000_MEAN7 = 60/2;
	private final double T3000_MEAN8 = 60/2;
	private final double T3000_MEAN9 = 60/1;
	
	private final double T4000_MEAN1 = 60/2;
	private final double T4000_MEAN2 = 60/3;
	private final double T4000_MEAN3 = 60/4;
	private final double T4000_MEAN4 = 60/3;
	private final double T4000_MEAN5 = 60/2;
	private final double T4000_MEAN6 = 60/1;
	private final double T4000_MEAN7 = 60/1;
	private final double T4000_MEAN8 = 60/1;
	private final double T4000_MEAN9 = 60/1;
	
	private final double TRAVEL_MEAN = 30;
	private final double TRAVEL_STD_DEV = 20;
	private Normal travelTimeDist;
	
	private final double T1000_SERVICE_MEAN = 15;
	private final double T1000_SERVICE_STD_DEV = 6;
	private Normal serviceTimeDistT1000;
	
	private final double T2000_SERVICE_MEAN = 44;
	private final double T2000_SERVICE_STD_DEV = 15;
	private Normal serviceTimeDistT2000;
	
	private final double T3000_SERVICE_MEAN = 60;
	private final double T3000_SERVICE_STD_DEV = 27;
	private Normal serviceTimeDistT3000;
	
	
	private final double T4000_SERVICE_MEAN = 130;
	private final double T4000_SERVICE_STD_DEV = 30;
	private Normal serviceTimeDistT4000;
	
    // Data Models - i.e. random variate generators for distributions
	// are created using Colt classes, define 
	// reference variables here and create the objects in the
	// constructor with seeds


	// Constructor
	protected RVPs(SMRepair smRepair, Seeds sd) 
	{ 
		this.model = smRepair; 
		// Set up distribution functions
		interArrDistT1000 = new Exponential(1.0/T1000_MEAN1,new MersenneTwister(sd.seed1));
		interArrDistT2000 = new Exponential(1.0/T2000_MEAN1,new MersenneTwister(sd.seed2));
		interArrDistT3000 = new Exponential(1.0/T3000_MEAN1,new MersenneTwister(sd.seed3));
		interArrDistT4000 = new Exponential(1.0/T4000_MEAN1,new MersenneTwister(sd.seed4));
		travelTimeDist = new Normal(TRAVEL_MEAN,TRAVEL_STD_DEV, new MersenneTwister(sd.seed5));
		serviceTimeDistT1000 = new Normal(T1000_SERVICE_MEAN,T1000_SERVICE_STD_DEV, new MersenneTwister(sd.seed6));
		serviceTimeDistT2000 = new Normal(T2000_SERVICE_MEAN,T2000_SERVICE_STD_DEV, new MersenneTwister(sd.seed7));
		serviceTimeDistT3000 = new Normal(T3000_SERVICE_MEAN,T3000_SERVICE_STD_DEV, new MersenneTwister(sd.seed8));
		serviceTimeDistT4000 = new Normal(T4000_SERVICE_MEAN,T4000_SERVICE_STD_DEV, new MersenneTwister(sd.seed9));
	}
	
	/* Random Variate Procedure for Arrivals */

	protected double duType1000CallArrival()  // for getting next value
	{
	    double nxtInterArr;
	    double mean;
	    double out;
	    
	    if(model.udp.getScaledClock() > 0 && model.udp.getScaledClock() <= 60)
	    	mean = T1000_MEAN1;
	    else if(model.udp.getScaledClock() > 60 && model.udp.getScaledClock() <= 120)
	    	mean = T1000_MEAN2;	    	
	    else if(model.udp.getScaledClock() > 120 && model.udp.getScaledClock() <= 180)
	    	mean = T1000_MEAN3;	    		
	    else if(model.udp.getScaledClock() > 180 && model.udp.getScaledClock() <= 240)
	    	mean = T1000_MEAN4;	    	
	    else if(model.udp.getScaledClock() > 240 && model.udp.getScaledClock() <= 300)
	    	mean = T1000_MEAN5;	    	
	    else if(model.udp.getScaledClock() > 300 && model.udp.getScaledClock() <= 360)
	    	mean = T1000_MEAN6;	    	
		else if(model.udp.getScaledClock() > 360 && model.udp.getScaledClock() <= 420)
	    	mean = T1000_MEAN7;	    		
		else if(model.udp.getScaledClock() > 420 && model.udp.getScaledClock() <= 480)
	    	mean = T1000_MEAN8;			    	
	    else if(model.udp.getScaledClock() > 480 && model.udp.getScaledClock() <= 540)
	    	mean = T1000_MEAN9;
	    else
	    	mean = -1;

	    if(mean>0)
	    {
	    	nxtInterArr = interArrDistT1000.nextDouble(1.0/mean);
	    	// Note that interarrival time is added to current
	    	// clock value to get the next arrival time.
	    	out = nxtInterArr+model.getClock();
	    }
	    else
	    	out = -1;
	    
	    return out;
	}
	
	protected double duType2000CallArrival()  // for getting next value
	{
	    double nxtInterArr;
	    double mean;
	    double out;
	    
	    if(model.udp.getScaledClock() > 0 && model.udp.getScaledClock() <= 60)
	    	mean = T2000_MEAN1;
	    else if(model.udp.getScaledClock() > 60 && model.udp.getScaledClock() <= 120)
	    	mean = T2000_MEAN2;	    	
	    else if(model.udp.getScaledClock() > 120 && model.udp.getScaledClock() <= 180)
	    	mean = T2000_MEAN3;	    		
	    else if(model.udp.getScaledClock() > 180 && model.udp.getScaledClock() <= 240)
	    	mean = T2000_MEAN4;	    	
	    else if(model.udp.getScaledClock() > 240 && model.udp.getScaledClock() <= 300)
	    	mean = T2000_MEAN5;	    	
	    else if(model.udp.getScaledClock() > 300 && model.udp.getScaledClock() <= 360)
	    	mean = T2000_MEAN6;	    	
		else if(model.udp.getScaledClock() > 360 && model.udp.getScaledClock() <= 420)
	    	mean = T2000_MEAN7;	    		
		else if(model.udp.getScaledClock() > 420 && model.udp.getScaledClock() <= 480)
	    	mean = T2000_MEAN8;			    	
	    else if(model.udp.getScaledClock() > 480 && model.udp.getScaledClock() <= 540)
	    	mean = T2000_MEAN9;
	    else
	    	mean = -1;

	    if(mean>0)
	    {
	    	nxtInterArr = interArrDistT2000.nextDouble(1.0/mean);
	    	// Note that interarrival time is added to current
	    	// clock value to get the next arrival time.
	    	out = nxtInterArr+model.getClock();
	    }
	    else
	    	out = -1;
	    
	    return out;
	}
	
	protected double duType3000CallArrival()  // for getting next value
	{
	    double nxtInterArr;
	    double mean;
	    double out;
	    
	    if(model.udp.getScaledClock() > 0 && model.udp.getScaledClock() <= 60)
	    	mean = T3000_MEAN1;
	    else if(model.udp.getScaledClock() > 60 && model.udp.getScaledClock() <= 120)
	    	mean = T3000_MEAN2;	    	
	    else if(model.udp.getScaledClock() > 120 && model.udp.getScaledClock() <= 180)
	    	mean = T3000_MEAN3;	    		
	    else if(model.udp.getScaledClock() > 180 && model.udp.getScaledClock() <= 240)
	    	mean = T3000_MEAN4;	    	
	    else if(model.udp.getScaledClock() > 240 && model.udp.getScaledClock() <= 300)
	    	mean = T3000_MEAN5;	    	
	    else if(model.udp.getScaledClock() > 300 && model.udp.getScaledClock() <= 360)
	    	mean = T3000_MEAN6;	    	
		else if(model.udp.getScaledClock() > 360 && model.udp.getScaledClock() <= 420)
	    	mean = T3000_MEAN7;	    		
		else if(model.udp.getScaledClock() > 420 && model.udp.getScaledClock() <= 480)
	    	mean = T3000_MEAN8;			    	
	    else if(model.udp.getScaledClock() > 480 && model.udp.getScaledClock() <= 540)
	    	mean = T3000_MEAN9;
	    else
	    	mean = -1;

	    if(mean>0)
	    {
	    	nxtInterArr = interArrDistT3000.nextDouble(1.0/mean);
	    	// Note that interarrival time is added to current
	    	// clock value to get the next arrival time.
	    	out = nxtInterArr+model.getClock();
	    }
	    else
	    	out = -1;
	    
	    return out;
	}
	
	protected double duType4000CallArrival()  // for getting next value
	{
	    double nxtInterArr;
	    double mean;
	    double out;
	    
	    if(model.udp.getScaledClock() > 0 && model.udp.getScaledClock() <= 60)
	    	mean = T4000_MEAN1;
	    else if(model.udp.getScaledClock() > 60 && model.udp.getScaledClock() <= 120)
	    	mean = T4000_MEAN2;	    	
	    else if(model.udp.getScaledClock() > 120 && model.udp.getScaledClock() <= 180)
	    	mean = T4000_MEAN3;	    		
	    else if(model.udp.getScaledClock() > 180 && model.udp.getScaledClock() <= 240)
	    	mean = T4000_MEAN4;	    	
	    else if(model.udp.getScaledClock() > 240 && model.udp.getScaledClock() <= 300)
	    	mean = T4000_MEAN5;	    	
	    else if(model.udp.getScaledClock() > 300 && model.udp.getScaledClock() <= 360)
	    	mean = T4000_MEAN6;	    	
		else if(model.udp.getScaledClock() > 360 && model.udp.getScaledClock() <= 420)
	    	mean = T4000_MEAN7;	    		
		else if(model.udp.getScaledClock() > 420 && model.udp.getScaledClock() <= 480)
	    	mean = T4000_MEAN8;			    	
	    else if(model.udp.getScaledClock() > 480 && model.udp.getScaledClock() <= 540)
	    	mean = T4000_MEAN9;
	    else
	    	mean = -1;

	    if(mean>0)
	    {
	    	nxtInterArr = interArrDistT4000.nextDouble(1.0/mean);
	    	// Note that interarrival time is added to current
	    	// clock value to get the next arrival time.
	    	out = nxtInterArr+model.getClock();
	    }
	    else
	    	out = -1;
	    
	    return out;
	}
	
	// Random Variate Procedure:  uType1000Contract() - type of next contract
	private final double PERCENT_PREMIUM_T1000 = 0.65;
	// private final double PERCENT_BASIC_T1000 = 0.35;   // Not used
	MersenneTwister typeRandGen1;
	// Method
	public String uType1000Contract()
	{
		double randNum = typeRandGen1.nextDouble();
		String type;
		if(randNum < PERCENT_PREMIUM_T1000) 
			type = "PREMIUM";
		else 
			type = "BASIC";
		
		return(type);
	}
	
	// Random Variate Procedure:  uType2000Contract() - type of next contract
	private final double PERCENT_PREMIUM_T2000 = 0.65;
	// private final double PERCENT_BASIC_T2000 = 0.35;   // Not used
	MersenneTwister typeRandGen2;
	// Method
	public String uType2000Contract()
	{
		double randNum = typeRandGen2.nextDouble();
		String type;
		if(randNum < PERCENT_PREMIUM_T2000) 
			type = "PREMIUM";
		else 
			type = "BASIC";
		
		return(type);
	}
	
	// Random Variate Procedure:  uType3000Contract() - type of next contract
	private final double PERCENT_PREMIUM_T3000 = 0.75;
	// private final double PERCENT_BASIC_T3000 = 0.35;   // Not used
	MersenneTwister typeRandGen3;
	// Method
	public String uType3000Contract()
	{
		double randNum = typeRandGen3.nextDouble();
		String type;
		if(randNum < PERCENT_PREMIUM_T3000) 
			type = "PREMIUM";
		else 
			type = "BASIC";
		
		return(type);
	}
	
	// Random Variate Procedure:  uType4000Contract() - type of next contract
	private final double PERCENT_PREMIUM_T4000 = 0.85;
	// private final double PERCENT_BASIC_T4000 = 0.35;   // Not used
	MersenneTwister typeRandGen4;
	// Method
	public String uType4000Contract()
	{
		double randNum = typeRandGen4.nextDouble();
		String type;
		if(randNum < PERCENT_PREMIUM_T4000) 
			type = "PREMIUM";
		else 
			type = "BASIC";
		
		return(type);
	}
	
	public double uTravelTime()
	{
		  return travelTimeDist.nextDouble();
	}
	
	
	public double uServiceTime(String equipType)
	{
		  double serviceTime = 0.0;
		  if(equipType == "TYPE1000")
		  {serviceTime = serviceTimeDistT1000.nextDouble();}
		  else if(equipType == "TYPE2000")
		  {serviceTime = serviceTimeDistT2000.nextDouble();}
		  else if(equipType == "TYPE3000")
		  {serviceTime = serviceTimeDistT3000.nextDouble();}
		  else if (equipType == "TYPE4000")
		  {serviceTime = serviceTimeDistT4000.nextDouble();}
		  return serviceTime;
	}

}
