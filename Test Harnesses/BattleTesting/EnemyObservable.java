/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         IObservable.java                                              *
* Purpose:          Interface for the Class EnemyObservable, part of the Observer *
* 					Pattern.													  *
* Unit:             OOSE                                                          *
* Last Modified:	21/05/2020                                                    *
**********************************************************************************/
/*package Controller;

//Import Custom Packages
import View.EnemyObserver;
*/
public interface EnemyObservable
{
	public void add(EnemyObserver observer);
	
	public void notifyObservers();
}
