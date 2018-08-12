import java.util.Arrays;

/**
 * 
 * @author Admin
 *
 */
public class Student {
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [name=" + name + ", choices=" + Arrays.toString(choices) + "]";
    }

    private String name;
    private String[] choices;

    /**
     * 
     * @param name
     *            is name of choices
     * @param choices
     *            is choices of courses by student in order
     */
    public Student(String name, String[] choices) {
        this.name = name;
        this.choices = choices;
    }

    /**
     * @return name of student
     */
    public String getName() {
        return name;
    }

    /**
     * @return order of choices made by student
     */
    public String[] getListOfChoices() {
        return choices;
    }

}