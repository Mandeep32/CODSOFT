import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    while (name.isEmpty()) {
                        System.out.print("Name cannot be empty. Enter name: ");
                        name = scanner.next();
                    }
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    while (rollNumber <= 0) {
                        System.out.print("Roll number must be positive. Enter roll number: ");
                        rollNumber = scanner.nextInt();
                    }
                    System.out.print("Enter grade: ");
                    String grade = scanner.next();
                    while (grade.isEmpty()) {
                        System.out.print("Grade cannot be empty. Enter grade: ");
                        grade = scanner.next();
                    }
                    sms.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    rollNumber = scanner.nextInt();
                    sms.removeStudent(rollNumber);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    rollNumber = scanner.nextInt();
                    Student student = sms.searchStudent(rollNumber);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}