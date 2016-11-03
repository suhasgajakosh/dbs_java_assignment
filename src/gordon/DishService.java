package gordon;

import java.util.Iterator;
import java.util.List;

/************************************************************************
 * 
 * Class DishService provides various methods to be used for 
 *
 * accomplishing certain tasks for Gordon Class
 *  
 * @author sgajakos
 * 
 *************************************************************************/
public class DishService {

	/**********************************************************************
	 *
	 * This method provides the list of dishes in the menu
	 * 
	 * 
	 * @param dishSatisfaction Dish satisfaction value for single dish
	 * @param timeRequiredToFinishDish Time required to finish a dish 
	 * @param list ArrayList of dishes or items from the menu
	 * @return list Same ArrayList with newly added item
	 * 
	 * 
	 **********************************************************************/	
	public static List<Dish> getListofDishes(int dishSatisfaction, int timeRequiredToFinishDish, List<Dish> list) {
		Dish dish = new Dish();
		dish.setSatisfaction(dishSatisfaction);
		dish.setTimeToEat(timeRequiredToFinishDish);

		list.add(dish);
		return list;
	}

	
	/**********************************************************************
	 *
	 * This method calculates and display the list of dishes 
	 * with highest satisfaction rate which Gordon is going to 
	 * consume for higher satisfaction  
	 * 
	 * 
	 * @param list ArrayList of dishes or items from the menu
	 * @param timeToEat Total time gordon has to finish the menu 
	 * @return 
	 * 
	 * 
	 **********************************************************************/
	public static void displaySatisfactionMenu(List<Dish> list, int timeToEat) {
		int totalSatisfaction = 0;
		int totalTimeRequired = 0;
		for (Iterator<Dish> iterator = list.iterator(); iterator.hasNext();) {
			Dish dish = (Dish) iterator.next();

			if (timeToEat - dish.getTimeToEat() <= 0) {
				break;
			} else {
				timeToEat = timeToEat - dish.getTimeToEat();
			}
			
			totalSatisfaction = totalSatisfaction + dish.getSatisfaction();
			totalTimeRequired = totalTimeRequired + dish.getTimeToEat();
			System.out.println();
			System.out.println("Satisfaction achieved: " + dish.getSatisfaction()
					+ " and time Required to finish dish: " + dish.getTimeToEat());
		}
		System.out.println();
		System.out.println("Total Satisfaction achived by Gordon Ramsay: " + totalSatisfaction);
		System.out.println("Total time consumed to achieve highest satisfaction: " + totalTimeRequired);

	}

}
