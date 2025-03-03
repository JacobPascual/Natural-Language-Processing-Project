import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class NLPRunner {
  public static void main(String[] args) {
    myNLP nathan = new myNLP("ingrediants.txt", "category.txt", "size.txt", "cuisine.txt", "method.txt", "difficulty.txt");
    nathan.runProgram();

    /*
    *One error I had was that I would get an index out of range exception when I tried to filter my list down
    *I noticed that two seperate filters had the same keyword, "medium", which caused both methods to run and
    *interfere with the length of the overall list length. I fixed this by changing the "medium" keyword that represented the size 
    *to "mid" so that the two filters wouldn't both be called
    */


  }
}