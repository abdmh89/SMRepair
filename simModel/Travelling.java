package simModel;

import simulationModelling.ConditionalActivity;

public class Traveling extends ConditionalActivity
{
	private SMRepair model; // for referencing the model
	private int classId;
	private int employeeId;
	
	public Traveling(SMRepair model) 
	{
		this.model = model;
	}

	protected static boolean precondition(SMRepair model)
	{
		boolean out = false;
		
		if(model.udp.getAvailableEmployee() != null && model.udp.getScaledClock() <= 510)
		{
			out = true;
		}
		
		return out;
	}

	public void startingEvent()
	{
		int [] id = model.udp.getAvailableEmployee();
		classId = id[0];
		employeeId = id[1];
		model.employees[classId][employeeId].status = "TRAVELING";
		model.employees[classId][employeeId].assignedTo = model.udp.getNextCall(classId);
	}

	@Override
	protected double duration()
	{
		return model.rvp.uTravelTime();
	}

	@Override
	protected void terminatingEvent()
	{
		model.employees[classId][employeeId].assignedTo.arrivalTime = model.udp.getScaledClock();
		Call icCurrentCall =  model.employees[classId][employeeId].assignedTo;
		
		if(icCurrentCall.contractType == "BASIC")
		{
			model.output.servicedBasicCalls += 1;
			if(icCurrentCall.arrivalTime - icCurrentCall.timeRequested <= 1440)
			{
				model.output.numSatisfiedBasicCalls +=1;
			}
			model.output.basicCustomerSatisfaction = model.output.numSatisfiedBasicCalls/model.output.servicedBasicCalls;
		}
		else
		{
			model.output.servicedPremiumCalls += 1;
			if((icCurrentCall.arrivalTime - icCurrentCall.timeRequested) <= 180)
			{
				model.output.numSatisfiedPremiumCalls += 1;
			} 
			else if (icCurrentCall.arrivalTime > 900 && icCurrentCall.arrivalTime <= 1080)
			{
				model.output.numSatisfiedPremiumCalls += 1;
			}
			model.output.premiumCustomerSatisfaction = model.output.numSatisfiedPremiumCalls/model.output.servicedPremiumCalls;
		}

	}
}
