import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class myNLP {
  private ArrayList<String> ingrediants;
  private ArrayList<String> methods;
  private ArrayList<String> categories;
  private ArrayList<Integer> sizes;
  private ArrayList<String> cuisines;
  private ArrayList<String> difficulty;

  //Creates a myNLP object
  public myNLP(String ingrediants, String categories, String sizes, String cuisines, String methods, String difficulty){
    this.ingrediants = FileReader.toStringList(ingrediants);
    this.categories = FileReader.toStringList(categories);
    this.sizes = FileReader.toIntList(sizes);
    this.cuisines = FileReader.toStringList(cuisines);
    this.methods = FileReader.toStringList(methods);
    this.difficulty = FileReader.toStringList(difficulty);
  }
  
  //returns ingrediant list
  public ArrayList<String> getIngrediants(){
    return ingrediants;
  }
  //returns category list
  public ArrayList<String> getCategories(){
    return categories;
  }
  //returns size list
  public ArrayList<Integer> getSizes(){
    return sizes;
  }
  //returns cuisine list
  public ArrayList<String> getCuisines(){
    return cuisines;
  }
  //returns method list
  public ArrayList<String> getMethods(){
    return methods;
  }
  //returns difficulty list
  public ArrayList<String> getDifficulty(){
    return difficulty;
  }

  /*
  * Traverses categories list and removes all indexes that don't match category
  * Also removes corresponding indexes in every other list
  *
  * Precondition: categories is instantiated with values
  * @param category - represents a given food category (breakfast, lunch, etc.)
  */
  public void filterCategory(String category){
    for(int i = 0; i < categories.size(); i++){
      String cur = categories.get(i).toLowerCase();
      if(!(cur.equals(category.toLowerCase()))){
        removeIndex(i);
        i--;
      }
    }
  }
  
  /*
  * Traverses sizes and removes all indexes that don't meet a specific size requirement
  * Also removes corresponding indexes in every other list
  *
  * Precondition: sizes is instantiated will values
  * @param size - represents a given portion sizze (large, average, small)
  */
  public void filterSize(String size){
    for(int i = 0; i < sizes.size(); i++){
      int s = sizes.get(i);
      if(size.toLowerCase().equals("big") || size.toLowerCase().equals("large") || size.toLowerCase().equals("enormous")){
        if(!(s >= 5)){
          removeIndex(i);
          i--;
        }
      }else if(size.toLowerCase().equals("mid") || size.toLowerCase().equals("average")){
        if(!(s >= 3 && s < 5)){
          removeIndex(i);
          i--;
        }
      }else if(size.toLowerCase().equals("small") || size.toLowerCase().equals("tiny") || size.toLowerCase().equals("little")){
        if(!(s < 3)){
          removeIndex(i);
          i--;
        }
      }
    }
  }
  
  /*
  * Traverses cuisines and removes all indexes that don't match cuisine
  * Also removes corresponding indexes in every other list
  * 
  * Precondition: cuisines is instantiated with values
  * @param cuisine - represents a given type of cuisine (Japanese, Mexican, etc.)
  */
  public void filterCuisine(String cuisine){
    for(int i = 0; i < cuisines.size(); i++){
      String c = cuisines.get(i).toLowerCase();
      if(!(c.equals(cuisine.toLowerCase()))){
        removeIndex(i);
        i--;
      }
    }
  }

  /*
  * Traverses difficulty and removes all indexes that don't match diff
  * Also removes corresponding indexes in every other list
  * 
  * Precondition: difficulty is instantiated with values
  * @param diff - represents the difficulty of making the dish (easy, medium, hard)
  */
  public void filterDifficulty(String diff){
    for(int i = 0; i < difficulty.size(); i++){
    String d = difficulty.get(i).toLowerCase();
     if(!(d.equals(diff.toLowerCase()))){
       removeIndex(i);
       i--;
     }
    }
  }
  
  /*
  * Takes user input and filters all instance variable ArrayLists based on keywords found in the input
  *
  * Precondition: ingrediants, methods, categories, sizes, cuisines, and difficulty all have been instantiated with values
  * Precondition: user input in the form of a sentence with correct grammatical spacing
  * @param input - represents user input as a String
  */
  public void Filter(String input){
    ArrayList<String> sentence = getWordsFromSentence(input);
    
    for(int i = 0; i < sentence.size(); i++){
      String word = sentence.get(i);
      if(word.toLowerCase().equals("lunch") || word.equals("dinner") || word.equals("dessert") || word.equals("breakfast") || word.equals("snack")){
        filterCategory(word);
      }
      if(word.toLowerCase().equals("big") || word.toLowerCase().equals("large") || word.toLowerCase().equals("enormous") || 
         word.toLowerCase().equals("mid") || word.toLowerCase().equals("average") || word.toLowerCase().equals("small") || 
         word.toLowerCase().equals("tiny") || word.toLowerCase().equals("little")){
        filterSize(word);
      }
      if(word.toLowerCase().equals("hard") || word.toLowerCase().equals("easy") || word.toLowerCase().equals("medium")){
        filterDifficulty(word);
      }
      if(word.toLowerCase().equals("mediterranean") || word.toLowerCase().equals("french") || word.toLowerCase().equals("mexican") || 
         word.toLowerCase().equals("italian") || word.toLowerCase().equals("japanese") || word.toLowerCase().equals("chinese") || 
         word.toLowerCase().equals("american")|| word.toLowerCase().equals("indian") || word.toLowerCase().equals("thai")){
        filterCuisine(word);
      }
    }
    //Had an error where I called all filters unconditionally, causing an overlap of filters and removing more indexes than what was necessary
  }

  /*
  * Seperates a string into an ArrayList
  * 
  * Precondition: is provided a given String with spaces 
  * @param sentence - a String of words
  * @return words - a list containing each individual word of a sentence
  */
  public ArrayList<String> getWordsFromSentence(String sentence){
    ArrayList<String> words = new ArrayList<String>();
    int s = sentence.indexOf(" ");
    while(s != -1){
      String curWrd = sentence.substring(0, s);
      words.add(curWrd);
      sentence = sentence.substring(s + 1);
      s = sentence.indexOf(" ");
    }
    words.add(sentence.substring(0, sentence.length()));
    return words;
  }

  /*
  * Removes corresponding indexes across the ArrayLists: ingrediants, methods, categories, sizes, cuisines, and difficulty
  * 
  * Precondition: all ArrayLists must be instantiated with values
  * @param index - represents the index to be removed from the lists
  */
  public void removeIndex(int index){
    ingrediants.remove(index);
    methods.remove(index);
    categories.remove(index);
    sizes.remove(index);
    cuisines.remove(index);
    difficulty.remove(index);
  }
  
  public void runProgram(){
    System.out.println("Welcome to FoodGPT! What kind of recipe would you like? \n[Ex.] (Mid sized easy Mediterranean dessert)");
    Scanner input = new Scanner(System.in);
    String sentence = input.nextLine();
    Filter(sentence);
    
    //Do later: if none of the words in the sentence are one of the filter words,
    // remove all indexes inside the arrays
    if(ingrediants.size() == 0){
      System.out.println("Sorry, I didn't understand. Make sure you aren't contradicting yourself (Ex. Small mid sized french dinner)");
    }
      for(int i = 0; i < categories.size(); i++){
      System.out.println("\nCategory: " + categories.get(i) + "\nCuisine: " + cuisines.get(i) + "\nIngrediants: " + ingrediants.get(i) + 
                         "\nMethod: " + methods.get(i) + "\nServing Size: " + sizes.get(i) + " Person(s)\nDifficulty: " + difficulty.get(i));
      }
  }
  
}