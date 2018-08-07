package ds_Assignment3JulyQues3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BowLersSequenceTest {

    @Test
    public void test() {
        BowLersSequence bowlersSequence = new BowLersSequence(5, 6);
        bowlersSequence.addBowlerAndBalls("b1", 8);
        bowlersSequence.addBowlerAndBalls("b2", 7);
        bowlersSequence.addBowlerAndBalls("b3", 6);
        bowlersSequence.addBowlerAndBalls("b4", 6);
        bowlersSequence.addBowlerAndBalls("b5", 7);

        List<String> list = new ArrayList<String>();
        list = bowlersSequence.ViratScore();
        List<String> listcheck = new ArrayList<String>();
        listcheck.add("b1");
        listcheck.add("b1");
        listcheck.add("b2");
        listcheck.add("b5");
        listcheck.add("b5");
        assertEquals(list, listcheck);
    }

}
