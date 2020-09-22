package model;

public interface Subject {

	public void registerObserver(Observer o);	
	public void notifyObserver(int e);
}
