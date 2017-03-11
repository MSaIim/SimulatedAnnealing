package algo;

import java.util.ArrayList;

public class Results 
{
	private double elapsedTime;
	private double totalDistance;
	private ArrayList<Double> stepCost;
	private ArrayList<Double> stepTime;
	
	public Results(ArrayList<Double> stepCost, ArrayList<Double> stepTime, double elapsedTime, double totalDistance)
	{
		this.elapsedTime = elapsedTime;
		this.totalDistance = totalDistance;
		this.stepCost = stepCost;
		this.stepTime = stepTime;
	}
	
	public double getElapsedTime() { return this.elapsedTime; }
	public double getTotalDistance() { return this.totalDistance; }
	public ArrayList<Double> getStepCost() { return this.stepCost; }
	public ArrayList<Double> getStepTime() { return this.stepTime; }
}
