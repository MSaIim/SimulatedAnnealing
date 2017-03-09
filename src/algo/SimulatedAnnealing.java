package algo;

import java.util.ArrayList;

import city.City;

public class SimulatedAnnealing 
{
	private double temperature, coolingRate;
	private Path currentPath, nextPath, bestPath;
	
	public SimulatedAnnealing(ArrayList<City> cities, double temperature, double coolingRate)
	{
		this.temperature = temperature;
		this.coolingRate = coolingRate;
		
		this.currentPath = new Path(cities);
		this.bestPath = new Path(this.currentPath);
	}
	
	public void run()
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
			if(acceptByProbability(currentEnergy, newEnergy))
			{
				this.currentPath = this.nextPath;
			}
			
			// Keep track of best solution
			if(this.currentPath.calculatePathDistance() < this.bestPath.calculatePathDistance())
				this.bestPath = this.currentPath;
			
			// Drop the temperature
			this.temperature *= 1 - coolingRate;
		}
		
		// End time
		System.out.println("Final solution time: " + (System.nanoTime() - startTime) / 1000000.0 + "ms");
		System.out.println("Final solution distance: " + this.bestPath.calculatePathDistance());
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

