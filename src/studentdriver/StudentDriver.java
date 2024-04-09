
package studentdriver;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class StudentDriver {

/**

 * Class: 44-241 Computer Programming II

 * Author: Reese Adams & Abby Miller

 * Description: This projects reads student information from a file. It sorts out the information and 
 *              prints the information so that it is easily understandable.

  * Due: 04/10/2024

  * I pledge that I have completed the programming assignment independently.

  * I have not copied the code from a student or any source.

  * I have not given my code to any other student and will not share this code with anyone under any circumstances.

 */
    public static void main(String[] args) throws FileNotFoundException {

        //instantiate an array of StudentFees
        StudentFees[] students = new StudentFees[12];
        
        //opening input.csv
        File inputFile = new File("input.csv");
        //Reading input.csv
        Scanner input = new Scanner(inputFile);
        
        Scanner studentNum = new Scanner(System.in);
        System.out.print("Enter the number of UG Students: ");
        String UGnumber = studentNum.nextLine();
        System.out.print("Enter the number of Graduate students: ");
        String gradNumber = studentNum.nextLine();
        System.out.print("Enter the number of Online students: ");
        String onlineNumber = studentNum.nextLine();
        
        //Declare extra variables
        int count = 0;
        int scholarshipCount = 0;
        double courseSum1 = 0;
        double enroll1 = 0;
        double enroll2 = 0;
        double enroll3 = 0;
        double cred = 3;
        double credFee = 543.5;
        double courseSum2 = 0;
        double fee = 654.45;
        double courseSum3 = 0;
        double courseNum1 = 0;
        double courseNum2 = 0;
        double courseNum3 = 0;
        double onlineFee = 1245.25;
        int assistCount = 0;
        
        //While loop that reads from the file to separate information and add then to the StudentFees list
        while(input.hasNext()){
            String file = input.nextLine();
            String[] parts = file.split(",");
            //Undergraduate Students
            if(count < 5){
                int studentID = Integer.parseInt(parts[0]);
                String studentName = parts[1];
                boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                int coursesEnrolled = Integer.parseInt(parts[3]);
                boolean hasScholarship = Boolean.parseBoolean(parts[4]);
                int scholarshipAmount = Integer.parseInt(parts[5]);
                
                students[count] = new UGStudent(studentName, studentID, isEnrolled, hasScholarship,
                        scholarshipAmount, coursesEnrolled);
                count++;
                if (isEnrolled == true){
                    courseNum1 += coursesEnrolled;
                    enroll1 ++;
                    courseSum1 += (coursesEnrolled * cred * credFee) - scholarshipAmount + 820.7;
                }
                if (scholarshipAmount >= 1){
                    scholarshipCount ++;
                }
            }
            //Graduate Students
            else if(count < 9){
                boolean isGraduateAssistant = Boolean.parseBoolean(parts[4]);
                if(isGraduateAssistant == true){
                    int studentID = Integer.parseInt(parts[0]);
                    String studentName = parts[1];
                    boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                    int coursesEnrolled = Integer.parseInt(parts[3]);
                    String graduateAssistantType = parts[5];

                    students[count] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, 
                            graduateAssistantType, coursesEnrolled);
                    courseNum2 += coursesEnrolled;
                    assistCount ++;
                    if (graduateAssistantType.equals("full")){
                        enroll2 ++;
                    }
                     else if (graduateAssistantType.equals("half")){
                        courseSum2 += (coursesEnrolled * cred * credFee) + fee / 2;
                        enroll2 ++;
                    }
                }
                else{
                    int studentID = Integer.parseInt(parts[0]);
                    String studentName = parts[1];
                    boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                    int coursesEnrolled = Integer.parseInt(parts[3]);
                    students[count] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, 
                            coursesEnrolled);
                    courseNum2 += coursesEnrolled;
                    courseSum2 += (coursesEnrolled * cred * credFee) + fee;
                    //enroll3 ++;
                }
                count++;
            }
            //Online students
            else if(count >= 9){
                int studentID = Integer.parseInt(parts[0]);
                String studentName = parts[1];
                boolean isEnrolled = Boolean.parseBoolean(parts[2]);
                int noOfMonths = Integer.parseInt(parts[3]);
                
                students[count] = new OnlineStudent(studentName, studentID, isEnrolled, noOfMonths);
                count++;
                courseSum3 += noOfMonths * onlineFee;
                enroll3 ++;
            }
        }
        System.out.println("");
        
        
        //For loop to print out the student list information
        int num = 0;
        for (StudentFees s : students) {
            if (s instanceof UGStudent) {
                if (num == 0) {
                    System.out.println("**********Undergraduate students list**********");
                }
                System.out.println(s);
                System.out.println("");
                num++;
                if (num >= 5) {
                    num = 0; // Reset num if it exceeds the desired count
                }
            }
            else if (s instanceof GraduateStudent){
                if (num == 0){
                    System.out.println("**********Graduate student list*************");
                }
                System.out.println(s);
                System.out.println("");
                num ++;
                if(num >= 4){
                    num = 0; // Reset num if it exceeds the desired count
                }
            }
            else if (s instanceof OnlineStudent){
                if (num == 0){
                    System.out.println("**********Online student list**************");
                }
                System.out.println(s);
                System.out.println("");
                num ++;
                if(num >= 3){
                    num = 0; // Reset num if it exceeds the desired count
                }
            }
        }
        
        //Statements that print out information about each student level 
        System.out.println("***********Undergraduate Student Details***********");
        double avgFee1 = courseSum1 / enroll1;
        System.out.println("Average Student fee: " + avgFee1);
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + courseNum1);
        
        System.out.println("***********Graduate Student Details*********");
        double avgFee2 = courseSum2 / 4;
        System.out.println("Average Student fee: " + avgFee2);
        System.out.println("Graduate Assistantship count: " + assistCount);
        System.out.println("Total number of courses: " + courseNum2);
        
        System.out.println("**********Online Student Details**********");
        double avgFee3 = courseSum3 / enroll3;
        System.out.printf("Average Student fee: %.2f\n", avgFee3);
        
        
        //Closing the input file
        input.close();   
    }

}
