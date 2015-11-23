package simModel;

import simulationModelling.ScheduledAction;

class Initialize extends ScheduledAction
{
	SMRepair model;
	
	// Constructor
	protected Initialize(SMRepair smRepair) 
	{ 
		this.model = smRepair; 
	}

	double [] ts = { 0.0, -1.0 }; // -1.0 ends scheduling
	int tsix = 0;  // set index to first entry.
	protected double timeSequence() 
	{
		return ts[tsix++];  // only invoked at t=0
	}

	protected void actionEvent() 
	{
		
		// System Initialization
	    model.employees = new Employee[2][];
	    
	    model.employees[Constants.CLASSA] = new Employee[model.numClassAEmployees];
	    model.employees[Constants.CLASSB] = new Employee[model.numClassBEmployees];
	    
	    model.queues = new ServiceRequests[8];
        
	}
	

}
