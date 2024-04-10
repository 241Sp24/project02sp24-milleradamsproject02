
package studentdriver;


public class OnlineStudent extends StudentFees {
    //Declare variables
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
    
    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths){
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }
    
    //Return the amount that is to be paid
    public double getPayableAmount(){
        return MONTHLY_FEE * noOfMonths;
    }
    
    //Return the information shared by all students plus information only online student have
    public String toString(){
        return super.toString() + "\nNo of months: " + noOfMonths + "\nPayable amount: " + 
                String.format("%.2f", getPayableAmount());
    }
            
    
}
