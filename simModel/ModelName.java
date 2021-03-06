package simModel;

import simulationModelling.AOSimulationModel;
import simulationModelling.Behaviour;
import simulationModelling.SequelActivity;

public class SMRepair extends AOSimulationModel
{

	// Constants available from Constants class
	/* Parameter */
    protected int numClassAEmployees;
    protected int numClassBEmployees;

	/*-------------Entity Data Structures-------------------*/
	/* Group and Queue Entities */
	// Define the reference variables to the various 
	// entities with scope Set and Unary
	// Objects can be created here or in the Initialize Action
    
    Employee [][] employees;
    
    ServiceRequests [] queues;
    
	/* Input Variables */
	// Define any Independent Input Variables here
    protected CallType1000 callType1000;
    protected CallType2000 callType2000;
    protected CallType3000 callType3000;
    protected CallType4000 callType4000;
	
	// References to RVP and DVP objects
	protected RVPs rvp;  // Reference to rvp object - object created in constructor
	protected DVPs dvp = new DVPs(this);  // Reference to dvp object
	protected UDPs udp = new UDPs(this);

	// Output object
	protected Output output = new Output(this);
	
	// Output values - define the public methods that return values
	// required for experimentation.


	// Constructor
	public SMRepair(double t0time, double tftime, /*define other args,*/ Seeds sd)
	{
		// Initialize parameters here
	    numClassAEmployees = 1;
	    numClassBEmployees = 1;
		
		// Create RVP object with given seed
		rvp = new RVPs(this,sd);
		
		// Initialize the simulation model
		initAOSimulModel(t0time,tftime);

		// Schedule the first arrivals and employee scheduling
		Initialize init = new Initialize(this);
		scheduleAction(init);  // Should always be first one scheduled.
		// Schedule other scheduled actions and activities here
		CallType1000 callType1000 = new CallType1000(this);
		scheduleAction(callType1000);
		
		CallType2000 callType2000 = new CallType2000(this);
		scheduleAction(callType2000);
		
		CallType3000 callType3000 = new CallType3000(this);
		scheduleAction(callType3000);
		
		CallType4000 callType4000 = new CallType4000(this);
		scheduleAction(callType4000);
		
	}

	/************  Implementation of Data Modules***********/	
	/*
	 * Testing preconditions
	 */
	protected void testPreconditions(Behaviour behObj)
	{
		reschedule(behObj);
		// Check preconditions of Conditional Activities

		// Check preconditions of Interruptions in Extended Activities
	}
	
	public void eventOccured()
	{
		//this.showSBL();
		// Can add other debug code to monitor the status of the system
		// See examples for suggestions on setup logging

		// Setup an updateTrjSequences() method in the Output class
		// and call here if you have Trajectory Sets
		// updateTrjSequences() 
	}

	// Standard Procedure to start Sequel Activities with no parameters
	protected void spStart(SequelActivity seqAct)
	{
		seqAct.startingEvent();
		scheduleActivity(seqAct);
	}

}
