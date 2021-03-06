package algo;

import java.util.ArrayList;
import city.City;

public class Annealing 
{
	private double temperature, coolingRate, swapCount;
	private Path currentPath, nextPath, bestPath;
	
	private ArrayList<Double> stepCost;
	private ArrayList<Double> stepTemp;
	
	public Annealing(ArrayList<City> cities, double temperature, double coolingRate)
	{
		this.temperature = temperature;
		this.coolingRate = coolingRate;
		this.swapCount = 0.0;
		
		this.currentPath = new Path(cities);
		this.bestPath = new Path(this.currentPath);
		
		this.stepCost = new ArrayList<Double>();
		this.stepTemp = new ArrayList<Double>();
	}
	
	public Results run()
	{
		// Get start time
		long startTime = System.nanoTime();
		
		// Run algorithm
		while(this.temperature > 1.0)
		{
			// Get new path
			this.nextPath = this.currentPath.getNewPath();
			
			// Calculate the fitness (distance)
			double currentEnergy = this.currentPath.calculatePathDistance();
			double newEnergy = this.nextPath.calculatePathDistance();
			
			// Should we accept new path?
			if(this.acceptByProbability(currentEnergy, newEnergy))
			{
				this.swapCount++;
				this.currentPath = this.nextPath;
			}
			
			// Keep track of best solution
			if(this.currentPath.calculatePathDistance() < this.bestPath.calculatePathDistance())
			{
				this.bestPath = this.currentPath;
				
				// Save cost for charts
				this.stepCost.add(this.bestPath.calculatePathDistance());
			}

			// Save temperature for charts
			this.stepTemp.add(this.temperature);
			
			// Drop the temperature
			this.temperature *= (1 - coolingRate);
		}
		
		// End time
		//System.out.println("Final solution time: " + (System.nanoTime() - startTime) / 1000000.0 + "ms");
		//System.out.println("Final solution distance: " + this.bestPath.calculatePathDistance());
		
		return new Results(this.stepCost, this.stepTemp, ((System.nanoTime() - startTime) / 1000000.0), this.bestPath.calculatePathDistance(), this.swapCount);
	}
	
	// See if we should accept the new path
	public boolean acceptByProbability(double currentFitness, double newFitness)
	{
		if(newFitness < currentFitness)
			return true;
		else
		{
			double delta = currentFitness - newFitness;
			double probability = Math.exp(delta/this.temperature);
			return probability > Math.random();
		}
	}
}
