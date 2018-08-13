import java.util.Scanner;

/**
 * main method
 * @author Namrata Agarwal
 *
 */
public class Main {

    public static void main(String[] args) {
        PostfixEvaluate postfix = new PostfixEvaluate();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE STRING WITH WHITE SPACES BETWEEN THE CHARACTERS");
        System.out.println(postfix.evaluate(sc.next()));

    }

}
