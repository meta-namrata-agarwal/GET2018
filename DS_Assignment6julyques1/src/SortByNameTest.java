import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SortByNameTest {
    EmployeeCollection employeeCollection;

    @Test
     (expected = AssertionError.class)
    public void test() {
        employeeCollection = new EmployeeCollection();
        SortByName sort = new SortByName();
         employeeCollection.addEmployee("mary", 4, "kanpur");
        employeeCollection.addEmployee("anand", 41, "jaipur");
         employeeCollection.addEmployee("mary", 41, "kanpur");
        Collections.sort(employeeCollection.getList(), sort);

        List<Employee> listcheck = new ArrayList<Employee>();
        listcheck.add(new Employee("ABHI", 5, "DELHI"));

        listcheck.add(new Employee("DEEPA", 4, "JAIPUR"));
        listcheck.add(new Employee("NAMRATA", 3, "DELHI"));

        listcheck.add(new Employee("RAM", 8, "JAIPUR"));
        listcheck.add(new Employee("SHAM", 12, "AJMER"));
        listcheck.add(new Employee("anand", 41, "jaipur"));

        for (int i = 0; i < listcheck.size(); i++) {
            assertEquals(listcheck.get(i).toString(), employeeCollection
                    .getList().get(i).toString());
        }

    }

}
