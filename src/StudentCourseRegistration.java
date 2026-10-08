import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    double calculateFee() {
        return courseCredits * 1500.0;
    }


    boolean checkEligibility() {
        return marks >= 50;
    }


    double calculateScholarship() {
        if (marks >= 85) {
            return 0.20;  
        } else if (marks >= 70) {
            return 0.10;   
        } else {
            return 0.0;    
        }
    }


    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarshipAmount = fee * calculateScholarship();
        return fee - scholarshipAmount;
    }


    void displayDetails() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship() * 100;
        double scholarshipAmount = totalFee * calculateScholarship();
        double finalFee = calculateFinalFee();

        System.out.println("\n===== Student Course Registration Details =====");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Roll Number      : " + rollNumber);
        System.out.println("Marks            : " + marks);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Course Credits   : " + courseCredits);
        System.out.println("Eligibility      : " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("Total Fee        : Rs. " + totalFee);
        System.out.println("Scholarship      : " + scholarshipPercent + "% (Rs. " + scholarshipAmount + ")");
        System.out.println("Final Fee        : Rs. " + finalFee);
        System.out.println("==============================================");
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

    
        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility()) {
                   s.displayDetails();
        } else {
            System.out.println("\nStudent is NOT eligible for registration.");
            System.out.println("Marks are below 50. Registration denied.");
        }

        sc.close();
    }
}