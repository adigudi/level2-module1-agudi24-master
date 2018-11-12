package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> array = new ArrayList<String>();
		//2. Add five Strings to your list
		String one = "H";
		String two = "E";
		String three = "L";
		String four = "L";
		String five = "O";
		array.add(one);
		array.add(two);
		array.add(three);
		array.add(four);
		array.add(five);
		//3. Print all the Strings using a standard for-loop
		System.out.println(array);
		//4. Print all the Strings using a for-each loop
		for (String string : array) {
			
		}
		//5. Print only the even numbered elements in the list.
		
		//6. Print all the Strings in reverse order.
		
		//7. Print only the Strings that have the letter 'e' in them.
	}
}
