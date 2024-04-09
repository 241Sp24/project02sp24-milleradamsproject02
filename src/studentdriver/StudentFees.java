
package studentdriver;


public abstract class StudentFees {
    //Declare variables
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
    
    //Returns student name
    public String getStudentName(){
        return studentName;
    }
    
    //Returns student ID
    public int getStudentID(){
        return studentID;
    }
    
    //Returns true or false depending if student is enrolled or not
    public boolean isIsEnrolled(){
        return isEnrolled;
    }
    
    //Returns how many credits each course has
    public int getCREDITS_PER_COURSE(){
        return CREDITS_PER_COURSE;
    }
    
    //Returns the fee per each credit
    public double getPER_CREDIT_FEE(){
        return PER_CREDIT_FEE;
    }
    
    //Sets a new student name when adding a new student
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    
    //Sets a new student ID when adding a new student
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    
    //Returns true or false if the student is enrolled or not
    public void setIsEnrolled(boolean isEnrolled){
    }
    
    //Returns the payable amount
    public double getPayableAmount(){
        return CREDITS_PER_COURSE * PER_CREDIT_FEE ;
    }
    
    //Returns the student information that all classes contain
    public String toString(){
        return "Student name: " + getStudentName() + "\nStudent id: " + getStudentID() + 
                "\nEnrolled: " + isIsEnrolled();
    }
}
