
/**
 * class employee with the information of employee
 * 
 * @author Namrata Agarwal
 * 
 *
 */
public class Employee {

    String empName;
    int empId;
    String empAddress;

    public Employee(String empName, int empId, String empAddress) {
        this.empAddress = empAddress;
        this.empId = empId;
        this.empName = empName;
    }

    /**
     * getter method for employee name
     * 
     * @return empName
     */
    public String getEmpName() {
        return empName;

    }

    /**
     * getter method for employee address
     * 
     * @return empAddress
     */
    public String getempAddress() {
        return empAddress;
    }

    /**
     * getter method for employee address
     * 
     * @return empId
     */
    public int getempId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empId=" + empId
                + ", empAddress=" + empAddress + "]";
    }

}
