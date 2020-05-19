/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         PlusTwoDecorator.java             			                  *
* Purpose:          Handles all PlusTwoDecorator functionality.		              *                                                   *
* Unit:             OOSE                                                          *
* Last Modified:    28/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Weapon;
  
public class PlusTwoDecorator extends EnchantmentDecorator
{
	private int price;
	
	public PlusTwoDecorator(Weapon innerWeapon)
	{	
		super(innerWeapon);
		price = 5;
	}
	
	@Override
	public int calcDamage()
	{
		return (innerWeapon.calcDamage() + 2); 
	}

	@Override
	public int getCost()
	{
		return (innerWeapon.getCost() + price);
	}

}