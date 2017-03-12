package algo;

import java.util.ArrayList;

public class Results 
{
	private double elapsedTime, totalDistance, swapCount;
	private ArrayList<Double> stepCost;
	private ArrayList<Double> stepTemp;
	
	public Results(ArrayList<Double> stepCost, ArrayList<Double> stepTemp, double elapsedTime, double totalDistance, double swapCount)
	{
		this.elapsedTime = elapsedTime;
		this.totalDistance = totalDistance;
		this.stepCost = stepCost;
		this.stepTemp = stepTemp;
		this.swapCount = swapCount;
	}
	
	public double getElapsedTime() { return this.elapsedTime; }
	public double getTotalDistance() { return this.totalDistance; }
	public double getSwapCount() { return this.swapCount; }
	public ArrayList<Double> getStepCost() { return this.stepCost; }
	public ArrayList<Double> getStepTemp() { return this.stepTemp; }
}
