package app;

import java.util.ArrayList;
import java.util.Arrays;

import algo.SimulatedAnnealing;
import city.City;
import city.CityInformation;

public class Main 
{
	public static void main(String[] args) 
	{
		/*System.out.print("Creating cities......");
		CityInformation.create(10,  "cities/c010");
		CityInformation.create(25,  "cities/c025");
		CityInformation.create(50,  "cities/c050");
		CityInformation.create(100, "cities/c100");
		System.out.println("[DONE]");*/
		
		// List of cities
		
		
		
		ArrayList<City> cities = (ArrayList<City>) Arrays.asList(CityInformation.read("cities/c100/c100_01", 100));
		SimulatedAnnealing tsp = new SimulatedAnnealing(cities, 10000.0, 0.003);
		tsp.run();
	}
}
