package dictionaryApi;
//imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class ignoreWords {
	
	 Set<String> ignoreTree = new TreeSet<String>();//treeset ignoreTree to hold ignore words from file
	
	public ignoreWords(){
		File ignoreWordsFile = new File("stopwords.txt"); 
		
		// Build ignore treeset 
		wordsToMap(ignoreWordsFile);
		
	}
	
	public void wordsToMap(File ignoreWordsFile){
		//this methods takes in each word from the stopWords file and puts it into the tree map
		
		try {//try catch
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ignoreWordsFile)));
			//create variable ignore word and set to null
			String ignoreWord = null;
			//keep looping until ignoreWord equals null
			while((ignoreWord = br.readLine())!= null)
			{
				ignoreTree.add(ignoreWord.toLowerCase());//add to treeset and set to lowercase
			}
			
			br.close();//close buffered reader
			
		} catch (IOException e) {
			System.out.println("Error opening File");
		}
	}
	
	//returns true or false statement if word is in the tree set//this gives you log(n) speed . its not the fastest but because the file is small it is fine for this action
	public boolean containsIgnoreWord(String Word)
	{
		return ignoreTree.contains(Word);//calls method contains
	}

}
