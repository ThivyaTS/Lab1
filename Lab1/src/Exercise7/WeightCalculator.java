package Exercise7;

public class WeightCalculator {

	private double earthWeight;
	private double marsWeight;
	
	public WeightCalculator()
	{}
	
	public WeightCalculator(double earthWeight)
	{
		this.earthWeight=earthWeight;
		
	}
	public double calcWeightOnMars()
	{
		marsWeight=(this.earthWeight/9.81)*3.711;
		return marsWeight;
	}
	
}
