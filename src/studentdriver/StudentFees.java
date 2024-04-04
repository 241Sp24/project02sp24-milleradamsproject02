/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author S552370
 */
public class StudentFees {
    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private int CREDITS_PER_COURSE = 3;
    private double PER_CREDIT_FEE = 543.50;
    
    public StudentFees(String studentName, int studentID, boolean isEnrolled){
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
        
    }
    
    public String getStudentName(){
        return studentName;
    }
    
    public int getStudentID(){
        return studentID;
    }
    
    public boolean isIsEnrolled(){
        return isEnrolled;
    }
    
    public int getCREDITS_PER_COURSE(){
        return CREDITS_PER_COURSE;
    }
    
    public double getPER_CREDIT_FEE(){
        return PER_CREDIT_FEE;
    }
    
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    
    public void setIsEnrolled(boolean isEnrolled){
    }
    
    public double getPayableAmount(){
        return coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE;
    }
    
    public String toString(){
        
    }
}
