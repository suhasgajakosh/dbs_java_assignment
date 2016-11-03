package gordon;

import java.util.Comparator;
/************************************************************************
 * 
 * Class Dish represents a single item from the menu received as menu.
 * 
 * 
 * Class Dish implements Comparator in order to make it sortable class 
 * 
 * in Collections.sort method.
 * 
 * @author sgajakos
 * 
 *************************************************************************/
public class Dish implements Comparator<Dish> {

	private int satisfaction;
	private int timeToEat;
	
	public Dish() {
		
	}	

	public Dish(int satisfaction, int timeToEat) {
		this.satisfaction = satisfaction;
		this.timeToEat = timeToEat;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public int getTimeToEat() {
		return timeToEat;
	}

	public void setTimeToEat(int timeToEat) {
		this.timeToEat = timeToEat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + satisfaction;
		result = prime * result + timeToEat;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (satisfaction != other.satisfaction)
			return false;
		if (timeToEat != other.timeToEat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [satisfaction=" + satisfaction + ", timeToEat=" + timeToEat + "]";
	}

	@Override
	public int compare(Dish o1, Dish o2) {
		
		// Calculating satisfaction rate for comparison and sorting
		float f1 = (float) o1.satisfaction / o1.timeToEat;
		float f2 = (float) o2.satisfaction / o2.timeToEat;
		if (f1 < f2) {
			return 1;
		} else {
			return -1;
		}
	}

}
