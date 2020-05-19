/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         PlusFiveDecorator.java             			                  *
* Purpose:          Handles all PlusFiveDecorator functionality.		          *                                                   *
* Unit:             OOSE                                                          *
* Last Modified:    29/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Weapon;
  
public class PlusFiveDecorator extends EnchantmentDecorator
{
	private int price;
	
	public PlusFiveDecorator(Weapon innerWeapon)
	{
		super(innerWeapon);
		price = 20;
	}
	
	@Override
	public int calcDamage()
	{
		return (innerWeapon.calcDamage() + 5); 
	}
	
	@Override
	public int getCost()
	{
		return (innerWeapon.getCost() + price);
	}
}

