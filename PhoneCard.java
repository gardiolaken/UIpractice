import java.lang.*;
import java.util.*;

/** Shows the balance on a phone card after call and weekly charges are deducted */

public class PhoneCard
{
	
	private static final double zoneCostAfrica=0.4;
	private static final double zoneCostAnz= 0.3;
	private static final double zoneCostAisa= 0.4;
	private static final double zoneCostLatinam= 0.3;
	private static final double zoneCostEurope= 0.2;
	private static final double zoneCostCanada= 0.05;
	private static final double weeklyfeecharge= 1.00;
	private static final double zoneCostUSA= 0.1;
	private double limitbalance;
	private long id;
	private double balance= 25.00;
	private int pass;
	private int minutelimit;

    /** Adds a unique no. to the phonecard as an ID and password of the card
        @param no the unique number sets as id of the card 
        @param passwd the unique number to access the card
    */        
	public PhoneCard(long no, int passwd)
	{
		
	    if (no > 0 && passwd > 0 )
	    {
	    	
	    	id=no;
	    	pass=passwd;


	    }
	}
	/** the distinct number of each card is returned by this accessor
	*/
	public long getNumber()
	{
		
		return id;
	}
	/** the password of the card is returned by the accessor */
	public int getPassword()
	{
		return pass;
		
	}
	/** the method returns the balance on the card */

	public double getBalance()
	{
		return balance; 
	}
	/** the balance of the card is set to the amount bala by the mututaor
	    @param bala the amount to which the card balance is set to 
	*/    
	
	public double setbalance (double bala)
	{
		balance=bala;
		return balance;
	}
	/** The method returns the cost per minute of the zone mentioned in the arguement
        @param zone the specific zone for which the cost per min is to be returned
    */    	
	public double costPerMin(CallZone zone)
	{
		if( zone == CallZone.ASIA)
		{
			return zoneCostAisa;
		}
		else if (zone == CallZone.USA)
		{
			return zoneCostUSA;
		}
		else if (zone == CallZone.EUROPE)
		{
			return zoneCostEurope;
		}
		else if (zone == CallZone.AFRICA)
		{
			return zoneCostAfrica;
		}
		else if (zone == CallZone.ANZ)
		{
			return zoneCostAnz;
		}
		else if (zone == CallZone.CANADA)
		{
			return zoneCostCanada;
		}
		else if (zone == CallZone.LATINAM)
		{
			return zoneCostLatinam;
		}
		else
		{
			return 0;
		}
	}
	/** returns the maximum amount of minutes a card can be charged given the amount of balance in it 
	    @param zone the specific zone for which the call is charged for 
	 */   
	public int getLimit (CallZone zone)
	{
		limitbalance= balance;
		minutelimit = 0;
		if (zone == CallZone.ANZ)
		{
			while(limitbalance> zoneCostAnz)
			{
				limitbalance-=zoneCostAnz;
				minutelimit++;

			}
		}
		else if (zone == CallZone.EUROPE)
		{
			while (limitbalance > zoneCostEurope)
			{
				limitbalance=-zoneCostEurope;
				minutelimit++;
			}
		}
		else if (zone== CallZone.USA)
		{
			while ( limitbalance> zoneCostUSA)
			{
				limitbalance=-zoneCostUSA;
				minutelimit++;
			}
		}
		else if (zone == CallZone.CANADA)
		{
			while( limitbalance > zoneCostCanada)
			{
				limitbalance-=zoneCostCanada;
				minutelimit++;
			}
		}
		else if (zone == CallZone.AFRICA)
		{
			while(limitbalance > zoneCostAfrica)
			{
				limitbalance-=zoneCostAfrica;
				minutelimit++;
			}
		}
		else if (zone == CallZone.LATINAM)
		{
			while (limitbalance > zoneCostLatinam)
			{
				limitbalance-=zoneCostLatinam;
				minutelimit++;
			}
		}
		else if (zone== CallZone.ASIA)
		{
			while (limitbalance> zoneCostAisa)
			{
				limitbalance-= zoneCostAisa;
				minutelimit++;
			}
		}
		return minutelimit;
	}
	/** it charges the card for the given amount of minutes provided that the balance on the card is sufficent and minutes is positive. If so, it returns true or else false
	    @param minutes the minutes for which the card is charged for
	    @param zone the specified zone whos rate is charged 
	 */   
	public boolean charge (int minutes, CallZone zone)
	{
		if (minutes>= 0)
		{
			if(zone == CallZone.EUROPE)
			{
				if(balance > zoneCostEurope*minutes)
				{
					balance-= zoneCostEurope*minutes;
					return true;
				}
				else
				{
					return false;
				}
			}
			else if (zone == CallZone.USA)
			{
				if(balance> zoneCostUSA*minutes)
				{
					balance-= zoneCostUSA*minutes;
					return true;
				}
				else 
				{
					return false;
				}
			}
			else if (zone == CallZone.CANADA)
			{
				if(balance > zoneCostCanada*minutes)
				{
					balance-= zoneCostCanada*minutes;
					return true;
				}
				else
				{
					return false;

				}
			}
			else if (zone == CallZone.AFRICA)
			{
				if(balance > zoneCostAfrica*minutes)
				{
					balance-= zoneCostAfrica*minutes;
					return true;
				}
				else 
				{
					return false;
				}
			}
			else if (zone == CallZone.ANZ)
			{
				if ( balance > zoneCostAnz*minutes)
				{
					balance-= zoneCostAnz*minutes;
					return true;
				}
				else 
				{
					return false;
				}
			}
			else if (zone == CallZone.LATINAM)
			{
				if(balance> zoneCostLatinam*minutes)
				{
					balance-= zoneCostLatinam*minutes;
					return true;
				}
				else 
				{
					return false;
				}
			}
			else if (zone == CallZone.ASIA)
			{
				if(balance> zoneCostAisa*minutes)
				{
					balance-= zoneCostAisa*minutes;
					return true;
				}
				else 
				{
					return false;
				}

			}
		}
		return false; // returns error if condition not fulfilled
	}
	/** it deducts the specified weekly fees from the card leavimg it non-negative
	*/
	public void deductWeeklyFee()
	{
		if((balance-weeklyfeecharge) >=0)
		{
			balance-=weeklyfeecharge;
		}
		else
		{
			balance=0;
		}
	}
	/** The method prints a statement stating the card no. and balance remaining in it 
	*/
	public String toString()
	{
		String print= "The Card no." + id + "has the balance of" + balance + "dollars remaining in it";
		return print;

	}	
}