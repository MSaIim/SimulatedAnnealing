package city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityInformation 
{
	// Create the city information
	public static void create(int numOfCities, String folder)
	{
		int counter = 0;
		
		// Create directory
		File dir = new File(folder);
		dir.mkdir();
		
		for(int i = 0; i < 25; i++)
		{
			try {
				// Get the file number
				String fileNumber = (i < 9) ? "0" + Integer.toString((i+1)) : Integer.toString((i+1));
				String path = folder + "/c" + numOfCities + "_" + fileNumber;
				
				// Create the file
				
				try {
					File file = new File(path);
					file.createNewFile();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				PrintWriter writer = new PrintWriter(path, "UTF-8");
				List<Integer[]> coords = new ArrayList<Integer[]>();
				
				// Write number of cities
				writer.println(numOfCities);
				
				// Loop until number of cities is reached
				while(counter < numOfCities)
				{
					// Get two random coordinates
					Random random = new Random();
					int x = random.nextInt(101);
					int y = random.nextInt(101);
					
					// Check if coordinates not already used
					if(!coords.contains(new Integer[] {x, y}))
					{
						// Write to file
						counter++;
						coords.add(new Integer[] {x, y});
						writer.println(counter + " " + x + " " + y);
					}
				}
				
				// Reset
				counter = 0;
				
				// Close file
				writer.close();
				
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Read the city information
	public static ArrayList<City> read(String file, int numOfCities)
	{
		ArrayList<City> cities = new ArrayList<City>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// Skip first line and read the rest
			br.readLine();
		    String line = br.readLine();

		    // Read each line
		    while (line != null) 
		    {
		    	String[] str = line.split(" ");

		    	int id = Integer.parseInt(str[0]);
		    	int x = Integer.parseInt(str[1]);
		    	int y = Integer.parseInt(str[2]);
		    	
		    	cities.add(new City(id, x, y));
		    	
		    	// Go to next line
		    	line = br.readLine();
		    }
		    
		    // Close the file
		    br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cities;
	}
}
