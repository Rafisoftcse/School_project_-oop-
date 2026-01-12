package school;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Student ID: " + id +"\n Name: " + name);
    }
}

class Teacher {
    int id;
    String name;

    Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Teacher ID: " + id + "\n Name: " + name);
    }
}

class Course {
    int code;
    String title;
    Teacher teacher;

    Course(int code, String title, Teacher teacher) {
        this.code = code;
        this.title = title;
        this.teacher = teacher;
    }

    void display() {
        System.out.println("Course Code: " + code + "\n Title: " + title +
                "\n Teacher: " + teacher.name);
    }
}

class Result {
    Student student;
    Course course;
    double marks;

    Result(Student student, Course course, double marks) {
        this.student = student;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println("Result -> Student: " + student.name +
                "\n Course: " + course.title +
                "\n Marks: " + marks);
    }
}

