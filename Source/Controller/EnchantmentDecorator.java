/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnchantmentDecorator.java             			              *
* Purpose:          Handles all Parent EnchantmentDecorator functionality.		  *                                                   *
* Unit:             OOSE                                                          *
* Last Modified:    28/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Weapon;

public abstract class EnchantmentDecorator extends Weapon
{
	protected Weapon innerWeapon;
	
	public EnchantmentDecorator(Weapon innerWeapon)
	{
		this.innerWeapon = innerWeapon;
	}
	
	@Override
	public String getWeaponType()
	{
		return innerWeapon.getWeaponType();
	}
	
	@Override
	public int getMinDamage()
	{
		return innerWeapon.getMinDamage();
	}
	
	@Override
	public int getMaxDamage()
	{
		return innerWeapon.getMaxDamage();
	}
	
	@Override
	public int calcDamage()
	{
		return innerWeapon.calcDamage();
	}
	
	@Override
	public String getDamageType()
	{
		return innerWeapon.getDamageType();
	}
	
	@Override
	public String getItemType()
	{
		return innerWeapon.getItemType();
	}
	
	@Override
	public String toString()
	{
		return innerWeapon.toString();
	}
	
	@Override
	public int getCost()
	{
		return innerWeapon.getCost();
	}
	
	/*protected getRandomValue(int inMinimum, int inMaximum);
	{*/
		
}