package app;

import java.io.File;
import java.util.ArrayList;

import algo.Results;
import algo.Annealing;
import city.CityInformation;

public class Main 
{
	public static void main(String[] args) 
	{
		//System.out.print("Creating cities......");
		//CityInformation.create(10,  "cities/c010");
		//CityInformation.create(25,  "cities/c025");
		//CityInformation.create(50,  "cities/c050");
		//CityInformation.create(100, "cities/c100");
		//System.out.println("[DONE]");
		
		// List of results
		@SuppressWarnings("unchecked")
		ArrayList<Results>[] resultList  = new ArrayList[] { new ArrayList<Results>(),  new ArrayList<Results>(), new ArrayList<Results>(), new ArrayList<Results>()};
		
		// List of cities
		File[] c10  = new File("cities/c010").listFiles();
		File[] c25  = new File("cities/c025").listFiles();
		File[] c50  = new File("cities/c050").listFiles();
		File[] c100 = new File("cities/c100").listFiles();
		
		// Run algorithm given the files
		System.out.print("Working ");
		double temperature = 10000.0;
		double coolingRate = 0.00003;
		
		for(int i = 0; i < 5; i++)
		{
			System.out.print(".");
			
			// 10 cities
			//Annealing tsp10 = new Annealing(CityInformation.read(c10[i].getPath(), 10), temperature, coolingRate);
			//resultList[0].add(tsp10.run());
			
			// 25 cities
			Annealing tsp25 = new Annealing(CityInformation.read(c25[i].getPath(), 25), temperature, coolingRate);
			resultList[1].add(tsp25.run());
			
			// 50 cities
			//Annealing tsp50 = new Annealing(CityInformation.read(c50[i].getPath(), 50), temperature, coolingRate);
			//resultList[2].add(tsp50.run());
			
			// 100 cities
			//Annealing tsp100 = new Annealing(CityInformation.read(c100[i].getPath(), 100), temperature, coolingRate);
			//resultList[3].add(tsp100.run());
		}
		System.out.println(" [Done]\n");
		
		// Print out results
		for(int i = 0; i < resultList.length; i++)
		{
			double totalTime = 0.0;
			double totalQuality = 0.0;
			double totalNodes = 0.0;
			
			for(int j = 0; j < resultList[i].size(); j++)
			{
				totalTime += resultList[i].get(j).getElapsedTime();
				totalQuality += resultList[i].get(j).getTotalDistance();
			}
			
			System.out.println("Average Time: " + (totalTime / (double) resultList[i].size()));
			System.out.println("Average Quality: " + (totalQuality / (double) resultList[i].size()));
			System.out.println("");
		}
		
		// Create chart
		Chart chart = new Chart("", resultList[1]);
		chart.createStepCostChart("Distance Change Over Time");
	}
}
