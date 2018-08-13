import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {
    EmployeeCollection employeeCollection;

    @Test(expected = AssertionError.class)
    public void addtest() {
        employeeCollection = new EmployeeCollection();
        assertTrue(employeeCollection.addEmployee("mary", 4, "kanpur"));
        assertTrue(employeeCollection.addEmployee("anand", 41, "jaipur"));
        assertFalse(employeeCollection.addEmployee("mary", 41, "kanpur"));
    }

    @Test//(expected = AssertionError.class)
    public void getListTest() {
        employeeCollection = new EmployeeCollection();
        //assertTrue(employeeCollection.addEmployee("mary", 4, "kanpur"));
        employeeCollection.addEmployee("mary", 41, "kanpur");
        List<Employee> listcheck = new ArrayList<Employee>();
        listcheck.add(new Employee("RAM", 8, "JAIPUR"));
        listcheck.add(new Employee("SHAM", 12, "AJMER"));
        listcheck.add(new Employee("NAMRATA", 3, "DELHI"));
        listcheck.add(new Employee("DEEPA", 4, "JAIPUR"));
        listcheck.add(new Employee("ABHI", 5, "DELHI"));
        listcheck.add(new Employee("mary", 41, "kanpur"));
        for (int i = 0; i < listcheck.size(); i++) {
            assertEquals(listcheck.get(i).toString(), employeeCollection
                    .getList().get(i).toString());
        }
    }
}
