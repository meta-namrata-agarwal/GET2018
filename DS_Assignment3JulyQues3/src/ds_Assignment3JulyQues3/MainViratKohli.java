package ds_Assignment3JulyQues3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author Namrata Agarwal
 *
 */
public class MainViratKohli {

    public static void main(String[] args) {
        int ballsViratGoingToPlay;
        int numberOfBowlers;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of balls for virat");
        ballsViratGoingToPlay = sc.nextInt();
        System.out.println("enter the number of bowlers");
        numberOfBowlers=sc.nextInt();
        BowLersSequence bowlersSequence = new BowLersSequence(ballsViratGoingToPlay,numberOfBowlers);
        bowlersSequence.addBowlerAndBalls("bowler1", 4);
        bowlersSequence.addBowlerAndBalls("bowler2", 6);
        bowlersSequence.addBowlerAndBalls("bowler3", 3);
        bowlersSequence.addBowlerAndBalls("bowler4", 7);
        bowlersSequence.addBowlerAndBalls("bowler5", 5);
        bowlersSequence.addBowlerAndBalls("bowler6", 7);
        List<String> list=new ArrayList<String>();
        list=bowlersSequence.ViratScore();
        for(String l:list)
        System.out.println(l);
        bowlersSequence.display();
        sc.close();
        
    }

}
