package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import city.City;

public class Path 
{
	// Represent path from city to city
	private ArrayList<City> path;
	
	public Path(ArrayList<City> cities)
	{
		this.path = new ArrayList<City>();
		
		for(int i = 0; i < cities.size(); i++)
		{
			path.add(cities.get(i));
		}
		
		// Reorder path
		Collections.shuffle(path);
	}
	
	// Copy constructor for the state
	public Path(Path prevPath)
	{
		this.path = new ArrayList<City>();
		for(int i = 0; i < prevPath.getPath().size(); i++)
		{
			this.path.add(prevPath.getPath().get(i));
		}
	}
	
	// Get total path distance
	public double calculatePathDistance()
	{
		double totalDistance = 0.0;
		
		for(int i = 0; i < this.path.size(); i++)
		{
			int indexOne = i;
			int indexTwo = (i+1) % this.path.size();
			
			totalDistance += this.path.get(indexOne).distanceTo(this.path.get(indexTwo));
		}
		
		return totalDistance;
	}
	
	// Swap two cities and return new path
	public Path getNewPath()
	{
		// Save current state
		Path newState = new Path(this);
		
		// Get two random indices
		int indexOne = new Random().nextInt(newState.getPath().size());
		int indexTwo = new Random().nextInt(newState.getPath().size());
		
		// Keep searching if the same indices
		while(indexOne == indexTwo) {
			indexTwo = new Random().nextInt(newState.getPath().size());
		}
		
		// Swap the cities
		newState.swap(indexOne, indexTwo);
		
		// Return new state
		return newState;
	}
	
	// Swap the cities
	public void swap(int indexOne, int indexTwo)
	{
		City temp = this.path.get(indexOne);
		this.path.set(indexOne, this.path.get(indexTwo));
		this.path.set(indexTwo, temp);
	}
	
	// Clone the current path
	public ArrayList<City> getPath() { return this.path; }
}
