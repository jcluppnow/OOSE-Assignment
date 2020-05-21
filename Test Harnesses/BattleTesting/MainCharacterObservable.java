/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         IObservable.java                                              *
* Purpose:          Interface for the Class MainCharacterObservable, part of the  *
* 					Observer Pattern.											  *
* Unit:             OOSE                                                          *
* Last Modified:	21/05/2020                                                    *
**********************************************************************************/
/*package Controller;

//Import Custom Packages
import View.MainCharacterObserver;
*/
public interface MainCharacterObservable
{
	public void add(MainCharacterObserver observer);
	
	public void notifyObservers();
}
