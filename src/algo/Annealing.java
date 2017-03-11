package algo;

import java.util.ArrayList;

import city.City;

public class Annealing 
{
	private double temperature, coolingRate;
	private Path currentPath, nextPath, bestPath;
	
	private ArrayList<Double> stepCost;
	private ArrayList<Double> stepTime;
	
	public Annealing(ArrayList<City> cities, double temperature, double coolingRate)
	{
		this.temperature = temperature;
		this.coolingRate = coolingRate;
		
		this.currentPath = new Path(cities);
		this.bestPath = new Path(this.currentPath);
		
		this.stepCost = new ArrayList<Double>();
		this.stepTime = new ArrayList<Double>();
	}
	
	public Results run()
	{
		// Get start time
		long startTime = System.nanoTime();
		
		// Run algorithm
		while(this.temperature > 0.1)
		{
			// Get new path
			this.nextPath = this.currentPath.getNewPath();
			
			// Calculate the fitness (distance)
			double currentEnergy = this.currentPath.calculatePathDistance();
			double newEnergy = this.nextPath.calculatePathDistance();
			
			// Should we accept new path?
			if(this.acceptByProbability(currentEnergy, newEnergy))
			{
				this.currentPath = this.nextPath;
			}
			
			// Keep track of best solution
			if(this.currentPath.calculatePathDistance() < this.bestPath.calculatePathDistance())
			{
				this.bestPath = this.currentPath;
				
				// Save cost for charts
				this.stepCost.add(this.bestPath.calculatePathDistance());
			}
			
			// Drop the temperature
			this.temperature *= (1 - coolingRate);
			
			// Save time for charts
			this.stepTime.add((System.nanoTime() - startTime)/1000000.0);
		}
		
		// End time
		//System.out.println("Final solution time: " + (System.nanoTime() - startTime) / 1000000.0 + "ms");
		//System.out.println("Final solution distance: " + this.bestPath.calculatePathDistance());
		
		return new Results(this.stepCost, this.stepTime, ((System.nanoTime() - startTime) / 1000000.0), this.bestPath.calculatePathDistance());
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

