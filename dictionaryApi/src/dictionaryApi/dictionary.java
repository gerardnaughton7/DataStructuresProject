package dictionaryApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dictionary {
	
	HashMap<String, List<String>> dictionaryMap = new HashMap<String, List<String>>();//hash map to hold words and definition of dictionary file
	
	// Default constructor
	// Constructor to build dictionary object
	public dictionary()
	{
		File dictionary = new File("dictionary.csv");//take in file 
		
		dictionaryToMap(dictionary);//call dictionaryToMap method and pass in file
	}
	
	private void dictionaryToMap(File dictionary)//should be at o(n) speed
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dictionary)));//create buffered reader
			StringBuilder definition = new StringBuilder();//and string builder to take in strings for the definition
			
			br.readLine();//take in the first line
			
			String nextLine = br.readLine();//create variable nextline
			
			while(nextLine != null)//keep looping while nextline doesn equal null
			{
				if(nextLine.charAt(0)=='"')//if charecter at possition 0 is "take in the word
				{
					String word = nextLine.substring(1,nextLine.indexOf('"', 1));// finish word when you meet another "
					
					do{
						definition.append(nextLine +"\n");
						nextLine = br.readLine();
						
					}while(nextLine != null && nextLine.charAt(0) != '"');//keep adding on to the definition string until the first character of the new line is "
					
					addDefinition(word.toLowerCase(), definition.toString());//call adddefinition and add word(key) and defintion to the dictionaryMap
					definition = new StringBuilder();//reset definition to take in new one
				}
			}
			br.close();//close buffered reader
			//System.out.println(dictionaryMap.toString());
		} catch (IOException e) {
			System.out.println("Error opening File");
		}
	}
	
	//add definition to map(should be o(1) speed)
	public void addDefinition(String word, String definition){
		if(dictionaryMap.containsKey(word)){ // word already here
			// add to list of existing definitions
			dictionaryMap.get(word).add(definition);
		} else{ // otherwise create new list
			List<String> defList = new ArrayList<String>();
			defList.add(definition);
			dictionaryMap.put(word, defList);
		}
		
	}
	
}

