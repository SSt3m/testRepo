//'
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook recipeBook;
        UserInterface userInterface;
        
        System.out.print("File to read: ");
        String fileName = scanner.nextLine();
        
        recipeBook = new RecipeBook(fileName);
        userInterface = new UserInterface(scanner, recipeBook);
        
        userInterface.start();
    }

}
