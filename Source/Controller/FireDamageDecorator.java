/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         FireDamageDecorator.java             			              *
* Purpose:          Handles all FireDamageDecorator functionality.	         	  *                                                   *
* Unit:             OOSE                                                          *
* Last Modified:    28/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Weapon;
  
public class FireDamageDecorator extends EnchantmentDecorator
{
	private int price;
	
	public FireDamageDecorator(Weapon innerWeapon)
	{
		super(innerWeapon);
		price = 20;
	}
	
	@Override 
	public int calcDamage()
	{
		return (innerWeapon.calcDamage() + getRandomValue(5,10)); 
	}

	@Override
	public int getCost()
	{
		return (innerWeapon.getCost() + price);
	}

}