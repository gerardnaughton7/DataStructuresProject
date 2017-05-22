package dictionaryApi;
//import arrayList
import java.util.ArrayList;
import java.util.List;


public class wordDetail {
	//create a list of pages and definitions
	private List<Integer> pages = new ArrayList<Integer>();
	private List<String> definitionList = new ArrayList<String>();	
	
	// Default constructor
	public wordDetail() {
	}
	
	public wordDetail(List<Integer> pgs, List<String> definitionL) {
		pages = pgs;
	}
	//adds all the page numbers to the pages arrayList
	public void addIndex(int page) {
		pages.add(page);
	}
	//gets the index for the word
	public List<Integer> getIndex() {
		return pages;
	}
	
	// adds definitions to the definitionList
	public void addDefinitionList(List<String> definitionL){ 
		
		definitionList = definitionL; 
	}
	
   // Getter for definition list	
   public List<String> getDefinition(){ 
	   
	   return definitionList;
	   
   }
	
}
