package simModel;

import simulationModelling.ConditionalActivity;

public class Lunch extends ConditionalActivity
{

	SMRepair model;
	
	private int [] id;

	public Lunch(SMRepair model)
	{
		this.model = model;
	}

	protected static boolean precondition(SMRepair model)
	{
		boolean out = false;
		
		if(model.udp.getEmployeeForLunch() != null)
		{
			out = true;
		}
		
		return out;
	}

	public void startingEvent()
	{
		id = model.udp.getEmployeeForLunch();
	
		model.employees[id[0]][id[1]].status = "LUNCH";
	}
	
	protected double duration()
	{
		return Constants.LUNCH_DURATION;
	}

	protected void terminatingEvent()
	{
		model.employees[id[0]][id[1]].status = "AVAILABLE";	
	}

}
