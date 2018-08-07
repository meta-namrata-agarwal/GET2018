package ds_Assignment3JulyQues3;

import java.util.ArrayList;
import java.util.List;

/**
 * class bowlersSequeqnce to detect the list of sequence of bowlers such that
 * team wins against virat kohli conditions is Virat scores minimum with the
 * bowler having maximum bowls
 * 
 * @author Namrata Agarwal
 *
 */

public class BowLersSequence {
    private int ballsViratGoingToPlay;
    private int numberOfBowlers;

    private int rear = -1;
    private ArrayOfBowlers[] QueueBowlers;
    List<String> list;

    /**
     * constructor taking parameter when object is created
     * 
     * @param ballsViratGoingToPlay
     * @param numberOfBowlers
     */
    public BowLersSequence(int ballsViratGoingToPlay, int numberOfBowlers) {
        this.ballsViratGoingToPlay = ballsViratGoingToPlay;
        this.numberOfBowlers = numberOfBowlers;

        QueueBowlers = new ArrayOfBowlers[numberOfBowlers];
        list = new ArrayList<String>();
    }

    /**
     * function to add name of bowler and quota of balls associated to them
     * 
     * @param name
     * @param balls
     */
    public void addBowlerAndBalls(String name, int balls) {
        if (isFull())
            throw new StackOverflowError("Limit is reached");
      
        ArrayOfBowlers array = new ArrayOfBowlers(name, balls);
        if (rear == -1) {
            QueueBowlers[++rear] = array;
        } else {
            rear++;
            check(array);
        }

    }

    /**
     * function for the sequence of bowlers for virat to score minimum
     */
    public List ViratScore() {
        for (int i = ballsViratGoingToPlay; i > 0; i--) {
            list.add(QueueBowlers[0].element);
            QueueBowlers[0].priority--;
            sortByPriority(QueueBowlers);

        }
        return list;
    }

    /**
     * private method to sort the list of bowlers with their balls
     * 
     * @param QueueBowlers
     */
    private void sortByPriority(ArrayOfBowlers[] QueueBowlers) {
        for (int i = 0; i < rear; i++) {
            for (int j = i; j < rear; j++) {
                if (QueueBowlers[i].priority < QueueBowlers[j].priority) {
                    ArrayOfBowlers temp = QueueBowlers[i];
                    QueueBowlers[i] = QueueBowlers[j];
                    QueueBowlers[j] = temp;
                }
            }

        }
    }

    /**
     * private method to add element in the queue priority wise
     * 
     * @param array
     */
    private void check(ArrayOfBowlers array) {
        int i, j;
        for (i = 0; i < rear; i++) {
            if (array.priority > QueueBowlers[i].priority) {
                for (j = rear; j > i; j--) {
                    QueueBowlers[j] = QueueBowlers[j - 1];

                }
                QueueBowlers[i] = array;
                return;
            }
        }
        QueueBowlers[i] = array;
    }

    /**
     * checks the queue is full or not
     * 
     * @return
     */
    private boolean isFull() {
        return rear == numberOfBowlers - 1;
    }

    /**
     * display method
     */
    public void display() {
        int i = 1;
        for (String l : list) {
            System.out.println(i + ": " + l);
            i++;
        }
    }
}
