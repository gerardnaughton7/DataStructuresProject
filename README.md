# DataStructuresProject
Dictionary Api for looking up words and there meanings in books.

Gerard Naughton Data Structure project

Ive created a dictionary API using 5 classes
 
1. ignoreWords
which takes in all the ignore words from the ignoreWords file and parses then into a tree set and has a
method to check if the word is contained in the treeset and it will return a boolean value.

2. dictionary
dictionary takes in words and definitions from a dictionary csv file. it parses the file and inputs
it into a hasMap. it then offer methods to add defintions to wordDetails and check if word is in the dictionary.

3. wordDetail
takes in the details for the word from the book and holds the definitions and page numbers for that word

4. bookApi
this class calls the 2 instances of the other classes ignoreWords and dictionary. this sets them up
it then create its own bookMap hashMap and from parsing the book. It ignores all the words it comes accross int the
book and takes in the rest and find there definetions and page numbers. it stores them in a wordDetail and then
adds it to its hashMap.
it contains the a search method to search the bookMap for this word and output its definition and indexes
it also allows the user to add a defintion to a word that was searched but wasnt found. and then add to the bookMap

5. Main(user instructions)
the user is asked to enter the book they would like to search 
the user can then search the bookMap for the word and it will return a definition and page numbers.
if the word is not found the user is then asked to enter a definition for this word and its added to the bookMap.
At the end of each search the user is asked if they would like to search another word by typing zero or typing -1 to exit the program

