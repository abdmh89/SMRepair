package simModel;

import cern.jet.random.engine.RandomSeedGenerator;

public class Seeds 
{
	int seed1;   // comment 1
	int seed2;   // comment 2
	int seed3;   // comment 3
	int seed4;   // comment 4
	int seed5;   // comment 5
	int seed6;   // comment 6
	int seed7;   // comment 7
	int seed8;   // comment 8
	int seed9;   // comment 9

	public Seeds(RandomSeedGenerator rsg)
	{
		seed1=rsg.nextSeed();
		seed2=rsg.nextSeed();
		seed3=rsg.nextSeed();
		seed4=rsg.nextSeed();
		seed5=rsg.nextSeed();
		seed6=rsg.nextSeed();
		seed7=rsg.nextSeed();
		seed8=rsg.nextSeed();
		seed9=rsg.nextSeed();
	}
}
