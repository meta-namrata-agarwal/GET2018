import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * employee collection class containing the list of all employees with details
 * 
 * @author Namrata Agarwal
 *
 */
public class EmployeeCollection {
    List<Employee> employeeCollection;

    public EmployeeCollection() {
        employeeCollection = new ArrayList<Employee>();
        employeeCollection.add(new Employee("RAM", 8, "JAIPUR"));
        employeeCollection.add(new Employee("SHAM", 12, "AJMER"));
        employeeCollection.add(new Employee("NAMRATA", 3, "DELHI"));
        employeeCollection.add(new Employee("DEEPA", 4, "JAIPUR"));
        employeeCollection.add(new Employee("ABHI", 5, "DELHI"));
    }

    /**
     * method to add employee details to the collection
     * 
     * @param empName
     * @param empId
     * @param empAddress
     */
    public boolean addEmployee(String empName, int empId, String empAddress) {
        
        boolean check = true;
        for (Employee employee : employeeCollection) {
            if (employee.getempId() == empId) {
                check = false;
                throw new AssertionError("id exsists");
            }
        }
        if (check)
            employeeCollection.add(new Employee(empName, empId, empAddress));
        return check;
    }

    /**
     * 
     * @return list of employees
     */
    public List<Employee> getList() {
        return employeeCollection;
    }

    /**
     * display method
     */
    public void display() {
        System.out.println("EMPLOYEE ID\t" + "EMPLOYEE NAME\t"
                + "EMPLOYEE ADDRESS");
        for (Employee employee : employeeCollection) {
            System.out
                    .println("\t" + employee.getempId() + "\t"
                            + employee.getEmpName() + "\t\t"
                            + employee.getempAddress());
        }
    }

    public static void main(String args[]) {
        EmployeeCollection emp = new EmployeeCollection();
        emp.addEmployee("anand", 41, "jaipur");
        //emp.addEmployee("EMP7", 10, "MUMBAI");
        
        System.out.println("NATURAL SORTING BY ID");
        NaturalSorting naturalsort = new NaturalSorting();
        Collections.sort(emp.getList(), naturalsort);
        emp.display();
        
        System.out.println("SORTING BY NAME");
        SortByName sortbyname = new SortByName();
        Collections.sort(emp.getList(), sortbyname);
        emp.display();
    }
}
