package school;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Result> results = new ArrayList<>();

        while (true) {
            System.out.println("\nSchool Management System : ");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Add Result");
            System.out.println("5. View Students");
            System.out.println("6. View Teachers");
            System.out.println("7. View Courses");
            System.out.println("8. View Results");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();
                    students.add(new Student(sid, sname));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Teacher ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Teacher Name: ");
                    String tname = sc.nextLine();
                    teachers.add(new Teacher(tid, tname));
                    System.out.println("Teacher added successfully!");
                    break;

                case 3:
                    if (teachers.isEmpty()) {
                        System.out.println("Please add a teacher first!");
                        break;
                    }
                    System.out.print("Enter Course Code: ");
                    int ccode = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course Title: ");
                    String ctitle = sc.nextLine();

                    System.out.println("Available Teachers:");
                    for (int i = 0; i < teachers.size(); i++) {
                        System.out.println((i + 1) + ". " + teachers.get(i).name);
                    }
                    System.out.print("Choose Teacher Index: ");
                    int tidx = sc.nextInt();
                    Teacher tch = teachers.get(tidx - 1);

                    courses.add(new Course(ccode, ctitle, tch));
                    System.out.println("Course added successfully!");
                    break;

                case 4:
                    if (students.isEmpty() || courses.isEmpty()) {
                        System.out.println("Please add student and course first!");
                        break;
                    }
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).name);
                    }
                    System.out.print("Choose Student Index: ");
                    int sidx = sc.nextInt();
                    Student stu = students.get(sidx - 1);

                    System.out.println("Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).title);
                    }
                    System.out.print("Choose Course Index: ");
                    int cidx = sc.nextInt();
                    Course crs = courses.get(cidx - 1);

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    results.add(new Result(stu, crs, marks));
                    System.out.println("Result added successfully!");
                    break;

                case 5:
                    System.out.println("Student List ");
                    for (Student st : students) {
                    	st.display();
                    }
                    break;

                case 6:
                    System.out.println(" Teacher List ");
                    for (Teacher t : teachers) {
                    	t.display();
                    }
                    break;

                case 7:
                    System.out.println(" Course List ");
                    for (Course c : courses) {
                    	c.display();
                    }
                    break;

                case 8:
                    System.out.println(" Result List ");
                    
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).name);
                    }
                    System.out.print("Choose Student Index: ");
                    int sidx1 = sc.nextInt();
                    Student stu1 = students.get(sidx1 - 1);
                    System.out.println("Result of " + stu1.name + ":");

                    boolean found = false;
                    for (Result r : results) {
                        if (r.student == stu1) {
                            r.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No result found for this student.");
                    }
                    break;
                    
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

