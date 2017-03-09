package algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

import city.City;

public class AStar 
{
	private PriorityQueue<City> fringe;
	private ArrayList<City> cities;
	private ArrayList<City> closedList;
	
	public AStar(ArrayList<City> cities)
	{
		this.cities = cities;
		this.fringe = new PriorityQueue<City>();
		this.closedList = new ArrayList<City>();
	}
	
	public void search()
	{
		// Start time
		long startTime = System.nanoTime();
		
		// Initial setup
		City start = this.cities.get(0);
		start.G = 0.0f;
		
	}
	
	private double heuristic(City s, City sprime)
	{
		double dx = Math.abs(s.X - sprime.X);
		double dy = Math.abs(s.Y - sprime.Y);

		return 0.25 * (dx + dy);
	}
}
