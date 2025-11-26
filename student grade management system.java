import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {

    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- STUDENT GRADE MANAGEMENT ----");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).name +
                                " - Marks: " + students.get(i).marks);
                    }
                }
                break;

            case 2:
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();
                students.add(new Student(name, marks));
                System.out.println("Student Added Successfully!");
                break;

            case 3:
                System.out.print("Enter student number to update: ");
                int index = sc.nextInt() - 1;
                sc.nextLine();

                if (index >= 0 && index < students.size()) {
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();
                    students.set(index, new Student(newName, newMarks));
                    System.out.println("Student Updated Successfully!");
                } else {
                    System.out.println("Invalid student number.");
                }
                break;

            case 4:
                System.out.print("Enter student number to delete: ");
                int deleteIndex = sc.nextInt() - 1;
                if (deleteIndex >= 0 && deleteIndex < students.size()) {
                    students.remove(deleteIndex);
                    System.out.println("Student Deleted Successfully!");
                } else {
                    System.out.println("Invalid student number.");
                }
                break;

            case 5:
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid choice.");
            }
        }
    }
}
