import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== STUDENT LIST MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Specific Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student (by Name or Index)");
            System.out.println("5. Display Student List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    students.add(nameToAdd);
                    System.out.println("Student added successfully!");
                    displayList(students);
                    break;

                case 2:
                    System.out.print("Enter student name to insert: ");
                    String nameToInsert = sc.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int indexToInsert = sc.nextInt();
                    sc.nextLine();
                    if (indexToInsert >= 0 && indexToInsert <= students.size()) {
                        students.add(indexToInsert, nameToInsert);
                        System.out.println("Student inserted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    displayList(students);
                    break;

                case 3:
                    System.out.print("Enter index of student to update: ");
                    int indexToUpdate = sc.nextInt();
                    sc.nextLine();
                    if (indexToUpdate >= 0 && indexToUpdate < students.size()) {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        students.set(indexToUpdate, newName);
                        System.out.println("Student name updated successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    displayList(students);
                    break;

                case 4:
                    System.out.println("Remove by:");
                    System.out.println("1. Name");
                    System.out.println("2. Index");
                    System.out.print("Choose option: ");
                    int removeOption = sc.nextInt();
                    sc.nextLine();

                    if (removeOption == 1) {
                        System.out.print("Enter name to remove: ");
                        String nameToRemove = sc.nextLine();
                        if (students.remove(nameToRemove)) {
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                    } else if (removeOption == 2) {
                        System.out.print("Enter index to remove: ");
                        int indexToRemove = sc.nextInt();
                        sc.nextLine();
                        if (indexToRemove >= 0 && indexToRemove < students.size()) {
                            students.remove(indexToRemove);
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    } else {
                        System.out.println("Invalid option!");
                    }
                    displayList(students);
                    break;

                case 5:
                    displayList(students);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // Method to display all students
    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent Student List:");
        if (list.isEmpty()) {
            System.out.println("[No students in the list]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ": " + list.get(i));
            }
        }
    }
}
