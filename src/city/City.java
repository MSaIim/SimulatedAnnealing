package city;

public class City
{
	private int id;
	private int x, y;
	
	public City(int id, int x, int y)
	{
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	 public double distanceTo(City city)
	 {
		 int xDistance = Math.abs(this.x - city.getX());
		 int yDistance = Math.abs(this.y - city.getY());
		 double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

		 return distance;
	 }
	 
	 public int getId() { return this.id; }
	 public int getX()  { return this.x; }
	 public int getY()  { return this.y; } 
}
