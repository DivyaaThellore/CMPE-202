
public class TheEconomy {
	Optimist o=new Optimist();
	private String TheEconomicStatus;
	
	public void setState(String str)
	{
		this.TheEconomicStatus=str;
		showState();
		o.display(str);
	}
	
	public void showState()
	{
		System.out.println(this.getClass().getName()+" = " + TheEconomicStatus);
		
	}
	
	
/*	public void attach(Pessimist obj)
	{
		
	}*/

}
