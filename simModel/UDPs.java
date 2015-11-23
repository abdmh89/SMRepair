package simModel;

//import java.util.ArrayList;

class UDPs 
{
	
	SMRepair model;  // for accessing the clock
	
	// Constructor
	protected UDPs(SMRepair smRepair) 
	{ 
		this.model = smRepair; 
	}


	protected int[] getAvailableEmployee()
	{
		int out[] = new int[2];

		boolean found = false;
		
		for(int i = 0;i<model.numClassAEmployees;i++)
		{
			if(model.employees[Constants.CLASSA][i].status == "AVAILABLE")
			{
				found = true;
				out[0] = Constants.CLASSA;
				out[1] = i;
			}
		}
		
		if(!found)
		{
			for(int j = 0;j<model.numClassBEmployees;j++)
			{
				if(model.employees[Constants.CLASSB][j].status == "AVAILABLE")
				{
					found = true;
					out[0] = Constants.CLASSB;
					out[1] = j;
				}
			}
			
		}
		
		return out;
	}
	
	protected Call getNextCall(int classId)
	{
		Call icCall = null;
		
		return icCall;
	}
	
	protected int [] getEmployeeForLunch()
	{
		int id[] = new int[2];

		boolean found = false;
		
		for(int i = 0;i<model.numClassAEmployees;i++)
		{
			if(model.employees[Constants.CLASSA][i].status == "AVAILABLE" &&
			   model.employees[Constants.CLASSA][i].hadLunch == false &&
			   model.udp.getScaledClock()>= 210 &&
			   model.udp.getScaledClock()<= 330)
			{
				found = true;
				id[0] = Constants.CLASSA;
				id[1] = i;
				break;
			}
		}
		
		if(!found)
		{
			for(int j = 0;j<model.numClassBEmployees;j++)
			{
				if(model.employees[Constants.CLASSB][j].status == "AVAILABLE" &&
				   model.employees[Constants.CLASSB][j].hadLunch == false &&
				   model.udp.getScaledClock()>= 210 &&
				   model.udp.getScaledClock()<= 330)
				{
					found = true;
					id[0] = Constants.CLASSB;
					id[1] = j;
					break;
				}
			}
			
		}
		
		return id;
	}
	
	public int getScaledClock()
	{
		int days = (int)model.getClock()/1440;
		return (int)model.getClock() - days*1440;
	}
	
	public int getScaledTime(int time)
	{
		int days = time/1440;
		return time - days*1440;
	}
	
}
