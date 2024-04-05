
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
        System.out.println("Enter the number of UG Students: ");
        UGnumber = studentNum.nextLine();
        System.out.println("Enter the number of Graduate students: ");
        gradNumber = studentNum.nextLine();
        System.out.println("Enter the number of Online students: ");
        onlineNumber = studentNum.nextLine();
        
        //id, name, enrolled, courses enrolled, scholarship, scholarship amt
        //String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled
        int count = 0;
        while(input.hasNext()){
            if(count < 5){
                String UG = input.nextLine();
                System.out.println(UG);
                count ++;
                //UG[1].equals(underGrad1.getStudentName());
                
                
            }
        }
        
        
        
        
        
        
        
        
        /*
        while
        //Closing the input file
        input.close();
*/
        
    }

}
