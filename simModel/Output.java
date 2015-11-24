package simModel;

class Output 
{
	SMRepair model;
	public int servicedBasicCalls;
	public int numSatisfiedBasicCalls;
	public double basicCustomerSatisfaction;
	public int servicedPremiumCalls;
	public int numSatisfiedPremiumCalls;
	public double premiumCustomerSatisfaction;
	
	protected Output(SMRepair smRepair) 
	{ 
		model = smRepair; 
	}
    // Use OutputSequence class to define Trajectory and Sample Sequences
    // Trajectory Sequences

    // Sample Sequences

    // DSOVs available in the OutputSequence objects
    // If seperate methods required to process Trajectory or Sample
    // Sequences - add them here

    // SSOVs
}
