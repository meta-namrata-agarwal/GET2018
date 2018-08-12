import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;

import DS_Assignment2ques.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

/**
 * In this program is assigned to a students
 * 
 * @author admin
 *
 */
public class Counselling {
    private List<CollegeData> listOfCollegeProgram;
    private QueueByLinkList<Student> listOfStudent;
    private List<AllocatedProgram> listOfAllocatedProgram;

    /**
     * constructor
     */
    public Counselling() {
        listOfCollegeProgram = new ArrayList<CollegeData>();
        listOfStudent = new QueueByLinkList<Student>();
        listOfAllocatedProgram = new ArrayList<AllocatedProgram>();

    }

    /**
     * read programs available from excel sheet
     */
    public void readCollegeProgram() {
        String name;
        int capacity = 0;

        try {

            Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Admin\\Desktop\\CollegeData.xls"));

            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            System.out.println(rows);
            for (int i = 0; i < rows - 1; i++) {
                name = sheet.getCell(0, i).getContents();

                capacity = Integer.parseInt(sheet.getCell(1, i).getContents());
                System.out.println(name + " " + capacity);
                listOfCollegeProgram.add(new CollegeData(name, capacity));
            }

        } catch (BiffException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * read name of student and their preferences from excel sheet
     */
    public void readStudentData() {
        String studentName;
        String[] choices;
        int size = 0;

        try {

            Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Admin\\Desktop\\StudentData.xls"));

            Sheet sheet1 = workbook.getSheet(0);
            int rows = sheet1.getRows();
            // System.out.println(rows);
            for (int i = 0; i < 5; i++) {
                studentName = sheet1.getCell(i, 0).getContents();
                choices = new String[5];
                choices[0] = sheet1.getCell(i, 1).getContents();
                choices[1] = sheet1.getCell(i, 2).getContents();
                choices[2] = sheet1.getCell(i, 3).getContents();
                choices[3] = sheet1.getCell(i, 4).getContents();
                choices[4] = sheet1.getCell(i, 5).getContents();
                listOfStudent.enqueue(new Student(studentName, choices));
                System.out.println(studentName + " " + choices[0] + " " + choices[1] + " " + choices[2] + " "
                        + choices[3] + " " + choices[4]);
            }

        } catch (BiffException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * assign particular program to student according to their rank
     */
    public void assignProgram() {
        while (!(listOfStudent.isEmpty())) {
            Student s = listOfStudent.deQueue();
            String preferences[] = s.getListOfChoices();
            String name = s.getName();

            loop: for (int i = 0; i < preferences.length; i++) {
                for (int j = 0; j < listOfCollegeProgram.size(); j++) {
                    if (listOfCollegeProgram.get(j).getProgramName().equals(preferences[i])) {
                        if (listOfCollegeProgram.get(j).getCapacity() > 0) {
                            listOfCollegeProgram.get(j).setCapacity(listOfCollegeProgram.get(j).getCapacity() - 1);
                            listOfAllocatedProgram.add(new AllocatedProgram(name, preferences[i]));
                            break loop;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < listOfAllocatedProgram.size(); i++) {

            System.out.println(
                    listOfAllocatedProgram.get(i).getName() + " " + listOfAllocatedProgram.get(i).getProgram());
        }
    }

    /**
     * write program Allocated to student in excel sheet
     * 
     * @throws RowsExceededException
     * @throws WriteException
     * @throws BiffException
     */
    public void writeDataInSheet() throws RowsExceededException, WriteException, BiffException {

        try {

            WritableWorkbook workbook = Workbook
                    .createWorkbook(new File("C:\\Users\\Admin\\Desktop\\ProgramAllocation.xls"));

            Sheet sheet = workbook.createSheet("firstSheet", 0);
            for (int i = 0; i < listOfAllocatedProgram.size(); i++) {
                Label label1 = new Label(0, i, listOfAllocatedProgram.get(i).getName());
                ((WritableSheet) sheet).addCell(label1);

                Label label2 = new Label(1, i, listOfAllocatedProgram.get(i).getProgram());
                ((WritableSheet) sheet).addCell(label2);
            }
            workbook.write();
            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}