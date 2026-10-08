import java.util.Scanner;

class Student {
    
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

   
    public double calculateFee() {
        return courseCredits * 1500.0;
    }


    public boolean checkEligibility() {
        return this.marks >= 50;
    }

  
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return 0.20 * fee; // 20% scholarship
        } else if (marks >= 70 && marks <= 84) {
            return 0.10 * fee; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

   
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.println("Total Course Fee   : Rs. " + calculateFee());
        System.out.println("Scholarship Amount : Rs. " + calculateScholarship());
        System.out.println("Final Fee Payable  : Rs. " + calculateFinalFee());
    }

    public String getStudentName() {
        return studentName;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent " + student.getStudentName() + " is NOT eligible for course registration (Marks < 50).");
        }

        scanner.close();
    }
}