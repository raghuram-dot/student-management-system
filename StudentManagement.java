import java.util.*;

class Student {
    int id;
    String name;
    String rollNo;
    int age;

    Student(int id, String name, String rollNo, int age) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Roll No: " + rollNo + " | Age: " + age);
    }
}

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("👋 Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(idCounter++, name, rollNo, age));
        System.out.println("✅ Student Added Successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No Students Found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Roll No: ");
                s.rollNo = sc.nextLine();
                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                System.out.println("✅ Student Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("🗑️ Student Deleted Successfully!");
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }
}
