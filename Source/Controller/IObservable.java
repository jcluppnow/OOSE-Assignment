/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         IObservable.java                                              *
* Purpose:          Interface for the Class IObservable, part of the Observer 	  *
* 					Pattern.													  *
* Unit:             OOSE                                                          *
* Last Modified:	18/05/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import View.IObserver;

public interface IObservable
{
	public void add(IObserver observer);
	
	public void notifyObservers();
}
