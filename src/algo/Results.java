package algo;

public class Results 
{
	private double elapsedTime;
	private double totalDistance;
	
	public Results(double elapsedTime, double totalDistance)
	{
		this.elapsedTime = elapsedTime;
		this.totalDistance = totalDistance;
	}
	
	public double getElapsedTime() { return this.elapsedTime; }
	public double getTotalDistance() { return this.totalDistance; }
}
