package city;

public class City
{
	public int ID;
	public int X, Y;
	public double F, G, H;
	public City Parent;
	
	public City(int id, int x, int y)
	{
		this.ID = id;
		this.X = x;
		this.Y = y;
		
		this.F = 0.0f;
		this.G = 0.0f;
		this.H = 0.0f;
	}
	
	 public double distanceTo(City city)
	 {
		 int xDistance = Math.abs(this.X - city.X);
		 int yDistance = Math.abs(this.Y - city.Y);
		 double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

		 return distance;
	 }
}
