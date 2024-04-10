
package studentdriver;


public class GraduateStudent extends StudentFees{
    //Declare variables
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES = 654.45;
    
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, 
            String graduateAssistantType, int coursesEnrolled){
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;

    }
   
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, 
            int coursesEnrolled){
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }
    
    //Returns true or false whether or not the person is a graduate assistant or not
    public boolean isIsGraduateAssistant(){
        return isGraduateAssistant;
    }
    
    //Returns how many courses the student is enrolled in
    public int getCoursesEnrolled(){
        return coursesEnrolled;
    }
    
    //Returns the amount that is to be paid
    public double getPayableAmount(){
        if(isIsGraduateAssistant() == true){
            if (graduateAssistantType.equals("full")){
                return ADDITIONAL_FEES;
            }
            else if (graduateAssistantType.equals("half")){
                return((coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_FEE()) / 2) + ADDITIONAL_FEES;
            }
        }
        return coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_FEE() + ADDITIONAL_FEES;
    }
    
    //Returns the information shared by all students as well as only information that grad students have
    public String toString(){
        return super.toString() + "\nGraduate assistant: " + isIsGraduateAssistant() + 
                "\nGraduate assistant type: " + graduateAssistantType + "\nCourses enrolled: " + 
                getCoursesEnrolled() + "\nPayable amount: " + String.format("%.2f",getPayableAmount());
    }
            
}
