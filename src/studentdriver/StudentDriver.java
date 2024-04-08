
package studentdriver;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class StudentDriver {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project02");
        String UGnumber;
        String gradNumber;
        String onlineNumber;
        //instantiate an array of StudentFees
        StudentFees[] students = new StudentFees[12];
        
        //opening input.csv
        File inputFile = new File("input.csv");
        //Reading input.csv
        Scanner input = new Scanner(inputFile);
        
        Scanner studentNum = new Scanner(System.in);
        System.out.print("Enter the number of UG Students: ");
        UGnumber = studentNum.nextLine();
        System.out.print("Enter the number of Graduate students: ");
        gradNumber = studentNum.nextLine();
        System.out.print("Enter the number of Online students: ");
        onlineNumber = studentNum.nextLine();
        
        
        int count = 0;
        while(input.hasNext()){
            String file = input.nextLine();
            String[] parts = file.split(",");
            if(count <= 5){
                int studentID = Integer.parseInt(parts[0]);
                String studentName = parts[1];
                boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                int coursesEnrolled = Integer.parseInt(parts[3]);
                boolean hasScholarship = Boolean.parseBoolean(parts[4]);
                int scholarshipAmount = Integer.parseInt(parts[5]);
                
                students[count] = new UGStudent(studentName, studentID, isEnrolled, hasScholarship,
                        scholarshipAmount, coursesEnrolled);
            }
            else if(count < 9){
                int studentID = Integer.parseInt(parts[0]);
                String studentName = parts[1];
                boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                int coursesEnrolled = Integer.parseInt(parts[3]);
                boolean isGraduateAssistant = Boolean.parseBoolean(parts[4]);
                String graduateAssistantType = parts[5];

                
                if(isGraduateAssistant){
                    students[count] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, 
                            graduateAssistantType, coursesEnrolled);
                }
                else{
                    students[count] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, 
                            coursesEnrolled);
                }
            }
            else if(count >= 9){
                int studentID = Integer.parseInt(parts[0]);
                String studentName = parts[1];
                boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                int noOfMonths = Integer.parseInt(parts[4]);
                
                students[count] = new OnlineStudent(studentName, studentID, isEnrolled, noOfMonths);
            }
            count ++;
        }
        
        

        
        //Closing the input file
        input.close();
        
    }

}
