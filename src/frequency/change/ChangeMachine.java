package frequency.change;

import java.util.HashMap;
import java.util.Set;

public class ChangeMachine {
	
	  public static HashMap <Float, Integer> retrunChange (HashMap <Float, Integer> coins, float change) {
		  HashMap <Float, Integer> returnCoins = new HashMap<>() ;
		    Set<Float> types = coins.keySet();
		    System.out.println(coins);
		    int totCoins =  1*coins.get(new Float(0.01)) + 5*coins.get(new Float(0.05)) + 10*coins.get(new Float(0.1)) + 25*coins.get(new Float(0.25));
		   
            if (totCoins < change) {
            	return coins;
            } 
            for (float d : coins.keySet()) {
            	int coinsNeed = (int) (change/d);
            if (coins.get(d)- coinsNeed >= 0) {
            	returnCoins.put(d, coinsNeed);
            	change = (change*100 - d*100*coinsNeed)/100;
            } else {
            	returnCoins.put(d, coins.get(d));
            	change = (change*100 - d*100*coins.get(d))/100;
            }
              System.out.println("change: " + change);
            }

		  return returnCoins;
		 		   
	   }
	   
	  
	  
	
	  


	  
	  
	  public static void main (String [] args) {
		  
		  HashMap<Float, Integer> coins = new HashMap<>();
		  coins.put((float) 0.25, 4);
		  coins.put((float) 0.1, 10);
		  coins.put((float) 0.05, 20);
		  coins.put((float) 0.01, 100);
		  
		  System.out.println(retrunChange(coins, (float) 0.86));
		  
		  coins.put((float) 0.25, 2);
		  coins.put((float) 0.1, 1);
		  coins.put((float) 0.05, 20);
		  coins.put((float) 0.01, 100);
		  
		  System.out.println(retrunChange(coins, (float) 0.960));
		  
		  coins.put((float) 0.25, 2);
		  coins.put((float) 0.1, 1);
		  coins.put((float) 0.05, 2);
		  coins.put((float) 0.01, 5);
		  
		  System.out.println(retrunChange(coins, (float) 0.96));
		  
	  }
	
	

}

/*

Title: Keep Your Coins! I Want Change!

Problem
============================
- Write a method for the ChangeMachine class that will determine how change is given out.

- Write appropriate unit tests in the ChangeMachineTest class to verify your implementation.

An input will be a set of available coins (coin value and number of each coin value).
Another input is the change that needs to be made from the coins.

The method should try and minimize the number of coins to give out.

E.g. if the input is:

available coins: 3 x 0.25, 5 x 0.05, 85 x 0.01
change: 0.86

Then, your method should return an appropriate data structure to represent:
3 x 0.25, 5 x 0.05, 85 x 0.01

It is up to you to define the method signature and name it appropriately.


Cases:
1. If there is not enough coins, then give away everything.
2. If there is no way to divide evenly (need to give 0.80 but you only have 4 x 0.25),
   return as much as you can (3 x 0.25).
*/