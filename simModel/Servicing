package simModel;

import simulationModelling.ExtSequelActivity;

public class Servicing extends ExtSequelActivity
{
	private Employee employee;
	private Call icCurrentCall;
	private SMRepair model; // for referencing the model
	
	public Servicing(SMRepair model, Employee employee)
	{
		this.model = model;
		this.employee = employee;
		this.icCurrentCall = employee.assignedTo;
	}

	public int interruptionPreCond()
	{
		int out = 0;
		int timeCompleted = model.udp.getScaledTime((int)icCurrentCall.arrivalTime + (int)model.rvp.uServiceTime(icCurrentCall.equipmentType));
		if (icCurrentCall.contractType == "BASIC" && timeCompleted > 570)
		{
			out = 1;
		}
		
		return out;
	}

	public void interruptionSCS(int interruptID)
	{
		if(interruptID == 1)
		{
			employee.numOvertimeHours += 0.5;
			employee.status = "AVAILABLE";
		}
	}


	public void startingEvent()
	{
		//empty event
	}

	@Override
	protected double duration()
	{
		return model.rvp.uServiceTime(icCurrentCall.equipmentType);
	}

	@Override
	protected void terminatingEvent()
	{
		int timeCompleted = (int)model.getClock();
		if (icCurrentCall.contractType == "BASIC")
		{
			if(540 < timeCompleted && timeCompleted < 570)
			{
				employee.numOvertimeHours += (timeCompleted - 540)/60;
			}
		}
		else
		{
			if(timeCompleted > 540)
			{
				employee.numOvertimeHours += (timeCompleted - 540)/60;
			}
		}
		employee.status = "AVAILABLE";
		employee.assignedTo = null;
	}

}
