import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CharacterCountTest {
    List<Data> cache = new ArrayList<>();
    CharacterCount characterCount = new CharacterCount();

    @Test
    public void getUniqueCounttestPositive() {

        int count = characterCount.getUniqueCount("happy");
        assertEquals(4, count);

        int count2 = characterCount.getUniqueCount("namrata");
        assertEquals(5, count2);
    }

    @Test(expected = AssertionError.class)
    public void getUniqueCountTestNegative() {

        int count = characterCount.getUniqueCount("happy");
        assertEquals(4, count);
        int count2 = characterCount.getUniqueCount("namrata");
        assertEquals(5, count2);

        int count1 = characterCount.getUniqueCount("happy");
        assertEquals(4, count1);

    }

}
