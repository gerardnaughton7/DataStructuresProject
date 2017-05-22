package dictionaryApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookApi {
	//variables
	private int page = 0;
	private int lineCounter = 0;

	private HashMap<String, wordDetail> bookMap = new HashMap<String, wordDetail>();// hashMap to hold word and wordDetails of Book
	private dictionary bookDictionary = new dictionary(); // create new instance of dictionary
	private ignoreWords iW = new ignoreWords();//create instance of wordDetail
	
	//creates bookMap
	public BookApi(String filePath) {
		
		// Access book  file
		File bookFile = new File(filePath); 
		
		// Build bookMap 
		Parse(bookFile); 
	}

	//parses the book and attaches the wordDetail(definition and page numbers)//speed should o(n)
	public void Parse(File bookFile) {
		// this methods takes in each word from the stopWords file and puts it
		// into the tree map

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(bookFile)));//read in file

			page = 1;//initialize page to 1
			String bookLine = null;//set bookLine to null

			//while bookline not equals null continue
			while ((bookLine = br.readLine()) != null) {
				lineCounter++;//counts the lines
				if (lineCounter % 40 == 0) //modulous if 0 means 1 page is reached and increment
				{
					page++;//increment page
				}

				String[] bookWord = bookLine.split(" ");//every time space is met take in new bookWord into array

				for (int i = 0; i < bookWord.length; i++)//loop through each word in the line 
				{
					bookWord[i] = bookWord[i].toLowerCase();
					// if bookWord is equal to ignoreWords then continue and move on to the next
					if (iW.containsIgnoreWord(bookWord[i]))
						continue;

					// Check bookMap already has key word and word detail
					if (bookMap.containsKey(bookWord[i]))//
					{
						// Update word detail object with new page number
						wordDetail wD = bookMap.get(bookWord[i]);
						//and index page
						wD.addIndex(page);
						//update wordDetail
						bookMap.put(bookWord[i], wD);

					}// end if
					else//if bookWord does not contain key
					{
						// Create word detail object
						wordDetail wD = new wordDetail();
						
						// if dictionary contains definition for word
						if(bookDictionary.dictionaryMap.containsKey(bookWord[i])){
							// add definition
							wD.addDefinitionList(bookDictionary.dictionaryMap.get(bookWord[i]));
							
						}//end if
						else// else tell the user no definition found
						{ 
							// Add no definition found text
							List<String> noDefList = new ArrayList<String>();
							noDefList.add("No Definition found");
							//add to wordDetail
							wD.addDefinitionList(noDefList);
						}//end else

						// add page number
						wD.addIndex(page);

						// Create key
						bookMap.put(bookWord[i], wD);
					}// end else

				} // end for
				
			} // end while

			br.close();//close buffered reader

		} catch (IOException e) {
			System.out.println("Error opening File");
		} // try catch
	}//end PARSE

	//search for word//speed should be in o(1) time
	public wordDetail search(String key){
		//search book
		//if bookMap contain key return wordDetail
		if(bookMap.containsKey(key))
		{
			return bookMap.get(key);
		}
		else//word not found ask user for definition
		{	
			return null;
		}
				
	}
	//to add to the hashMap should only take o(1) speed
	public void Add(String word, String definition){ 
		
		// Add word detail obj to bookMap
		wordDetail wD = new wordDetail();
		List<String> newDefList = new ArrayList<String>();
		//add definition to list
		newDefList.add(definition);
		//create new wordDetail for word
		wD.addDefinitionList(newDefList);
		//add word and wordDetail to bookMap
		bookMap.put(word, wD);
		//add new definition if not found in the book
		bookDictionary.addDefinition(word, definition);
	}
	
}