package Student;

import java.util.Date;

public class Student {
    private  String studentId;
    private String name;
    private int age;
    private Date dayStart;
    private String courseName;

    public Student() {}

    public Student(String studentId, String name, int age, Date dayStart, String courseName) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.dayStart = dayStart;
        this.courseName = courseName;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getDayStart() {
        return dayStart;
    }
    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
