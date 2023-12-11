import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPACalculator {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> courses = new ArrayList<>();
        double totalQualityPoints = 0;
        int totalGradeUnits = 0;
        double overallGPA = 0.0;
        int qualityPoints = 0;
        int gradeUnit = 0;
        String grade = "";
        String remark = "";

        System.out.println("GRADE POINT AVERAGE (GPA) CALCULATOR");
        System.out.println("-----------------------------------");

        while (true) {
            System.out.print("Enter Course Name and Code: ");
            String courseNameAndCode = scanner.nextLine();

            // System.out.print("Enter Course Unit: ");
            // int courseUnit = scanner.nextInt();

            // System.out.print("Enter Course Score (0-100): ");
            // int score = scanner.nextInt();

            int courseUnit;
            do {
                System.out.print("Enter Course Unit: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer for Course Unit.");
                    scanner.next(); // Consume invalid input
                }
                courseUnit = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (courseUnit <= 0) {
                    System.out.println("Invalid input. Course Unit must be a positive integer.");
                }
            } while (courseUnit <= 0);


            int score;
            do {
                System.out.print("Enter Course Score (0-100): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer for Course Score.");
                    scanner.next(); // Consume invalid input
                }
                score = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (score < 0 || score > 100) {
                    System.out.println("Invalid input. Score must be between 0 and 100.");
                }
            }
            while (score < 0 || score > 100);

            if (score >= 70 && score <= 100) {
                gradeUnit = 5;
                grade = "A";
                remark = "Excellent";
            } else if (score >= 60 && score < 70) {
                gradeUnit = 4;
                grade = "B";
                remark = "Very Good";
            } else if (score >= 50 && score < 60) {
                gradeUnit = 3;
                grade = "C";
                remark = "Good";
            } else if (score >= 45 && score < 50) {
                gradeUnit = 2;
                grade = "D";
                remark = "Fair";
            } else if (score >= 40 && score < 45) {
                gradeUnit = 1;
                grade = "E";
                remark = "Pass";
            } else {
                gradeUnit = 0;
                grade = "F";
                remark = "Fail";
            }

            qualityPoints = courseUnit * gradeUnit;
            totalQualityPoints += qualityPoints;
            totalGradeUnits += courseUnit;

            if (totalGradeUnits > 0) {
                overallGPA = totalQualityPoints / totalGradeUnits;
            }

            String[] courseDetails = {
                    courseNameAndCode,
                    String.valueOf(courseUnit),
                    grade,
                    String.valueOf(gradeUnit)
            };
            courses.add(courseDetails);

            // System.out.print("Have you inputted all courses? (yes or no): ");
            // String userInput = scanner.nextLine().toLowerCase();
            System.out.print("Have you inputted all courses? (yes or no): ");
            String userInput;
    
             // Loop until valid input (either "yes" or "no") is provided
            while (true) {

                userInput = scanner.nextLine().toLowerCase();

                if (userInput.equals("yes") || userInput.equals("no")) {
                break; // Exit the loop if valid input is provided
                } 
                else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            if (userInput.equals("yes")) {
            break;
            }
        }
        System.out.println("|---------------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE                   | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|---------------------------------|-----------------------|------------|---------------------|");
        for (String[] course : courses) {
        System.out.printf("| %-31s| %-22s| %-11s| %-20s|%n", course[0], course[1], course[2], course[3]);
        }
        System.out.println("|--------------------------------------------------------------------------------------------|");
        System.out.println("\nYour Overall GPA is = " + String.format("%.2f", overallGPA) + " to 2 decimal places.");

    }
}
