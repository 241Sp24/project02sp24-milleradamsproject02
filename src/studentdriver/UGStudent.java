
package studentdriver;


public class UGStudent extends StudentFees {
    //Declare variables
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, 
            double scholarshipAmount, int coursesEnrolled){
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
    }
    
    //Determines if student has a scholarship
    public boolean isHasScholarship(){
        return hasScholarship;
    }
    
    //Returns the amount of the scholarship
    public double getScholarshipAmount(){
        return scholarshipAmount;
    }
    
    //Returns how many courses the student is enrolled in
    public int getCourseEnrolled(){
        return coursesEnrolled;
    }
    
    //Returns how much the student 
    public double getPayableAmount(){
        if (isIsEnrolled() == false){
            return 0.00;
        }
        return (coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_FEE()) + ADDITIONAL_FEE - 
                scholarshipAmount;
    }
    
    //Returns the student information that all student have plus only information from UG Students
    public String toString(){
        return  super.toString() + "\nScholarship: "  + isHasScholarship() + "\nScholarship amount: " + 
                getScholarshipAmount() + "\nCourses enrolled: " + getCourseEnrolled() +
                "\nPayable amount: " + getPayableAmount();
    }
}