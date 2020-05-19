/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         PowerUpDecorator.java             			                  *
* Purpose:          Handles all PowerUpDecorator functionality.		              *                                                   *
* Unit:             OOSE                                                          *
* Last Modified:    28/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Weapon;
  
public class PowerUpDecorator extends EnchantmentDecorator
{
	private int price;
	
	public PowerUpDecorator(Weapon innerWeapon)
	{
		super(innerWeapon);
		price = 10;
	}
	
	@Override
	public int calcDamage()
	{
		return ((int)(innerWeapon.calcDamage() * 1.1)); 				//Need to check about whether this is rounding
	}
	
	@Override
	public int getCost()
	{
		return (innerWeapon.getCost() + price);
	}
}