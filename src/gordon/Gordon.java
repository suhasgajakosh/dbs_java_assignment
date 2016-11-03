package gordon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/************************************************************************
 * 
 * Class Gordon implements the logic for achieving highest 
 * 
 * satisfaction of eating items from menu.   
 *
 * 
 * @author sgajakos 
 * 
 *************************************************************************/
public class Gordon {

	public static void main(String[] args) {

		BufferedReader inputReader = null;
		List<Dish> list = new ArrayList<>();
		int timeToEat = 0;
		int numOfItems = 0;
		int dishSatisfaction = 0;
		int timeRequiredToFinishDish = 0;
		try {
			inputReader = new BufferedReader(new FileReader("D:/Users/sgajakos/Desktop/text.txt"));

			// Reading first inputs from file
			String input = inputReader.readLine();
			String inputArr[] = input.split(" ");

			if (null != inputArr[0]) {
				timeToEat = Integer.parseInt(inputArr[0]);
			}

			if (null != inputArr[1]) {
				numOfItems = Integer.parseInt(inputArr[1]);
			}

			System.out.println("Time to eat:" + timeToEat + " Number of Items:" + numOfItems);

			for (int i = 0; i < numOfItems; i++) {

				// Reading each item from file
				String item = inputReader.readLine();
				String itemArr[] = item.split(" ");
				if (null != itemArr[0]) {
					dishSatisfaction = Integer.parseInt(itemArr[0]);
				}

				if (null != itemArr[1]) {
					timeRequiredToFinishDish = Integer.parseInt(itemArr[1]);
				}

				// Initialize Dish object using received values
				list = DishService.getListofDishes(dishSatisfaction, timeRequiredToFinishDish, list);
			}

			// Sorting list based on satisfaction achieved per unit of time
			Collections.sort(list, new Dish());

			// Dishes with highest satisfaction rate are printed as output
			System.out.println("Dishes / Items consumed from menu for achieving highest satisfaction: ");
			System.out.println();
			
			DishService.displaySatisfactionMenu(list, timeToEat);
			
		} catch (FileNotFoundException e) {
			System.out.println("Exception occured as file not found in path: " + e.getStackTrace());
		} catch (IOException e) {
			System.out.println("Exception occured while reading file: " + e.getStackTrace());
		} finally {
			if (null != inputReader) {
				try {
					inputReader.close();
				} catch (IOException e) {
					System.out.println("Exception occured closing file reader: " + e.getStackTrace());
				}
			}
		}
	}

}
