package dictionaryApi;
//imports
import java.util.Scanner;
import java.util.List;

public class Main {
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		/// Word detail member
		wordDetail wD;
		//variables
		int exit = 0;

		// Print asking user for the File
		System.out.println("Enter the name of File you want to Search: \n");
		String file = scanner.next();

		// Create book API
		BookApi bookAPI = new BookApi(file);
		//while loop to keep search or exit
		while(exit == 0)
		{
			// Get Name of word to search
			System.out.println("Enter word to search: \n");
			String searchWord = scanner.next();
	
			// Use bookAPI to search for word
			wD = bookAPI.search(searchWord.toLowerCase());
			//if word found output the definition
			if (wD != null) {
				// Get definition
				List<String> definitionList = wD.getDefinition();
				List<Integer> wordPages = wD.getIndex();
				// Print out details from WordDetails
				System.out.println("Definition: ");
				//loop through the definitionList
				for (String def : definitionList) {
					// loop and print
					System.out.println(def);
				}// end for
				//output pages the word appears
				System.out.println("Pages :");
				//loop through list of pages
				for (int page : wordPages){
					System.out.println(page);
				}
				
			}//end if
			else {//output no def and input new def
				// No definition found
				System.out.println("No definition found!!"); 
				//ask user for new def
				System.out.println("Add new definition for this word?\n");
				//take in new definition
				String newDef = scanner.next();
				//add new word and definition
				bookAPI.Add(searchWord, newDef);
				//output the word has been added
				System.out.println("The word and definition has been added to the book dictionary!!");
	
			}//end else
			//ask user if they want to continue or exit
			System.out.println("Would you like to keep searching(Enter 0 to continue and -1 to exit)?");
			exit = scanner.nextInt();
		}//end while
		
		scanner.close();//close scanner
	}//end main

}
