package Course;

public class Course {
    private String courseId;
    private String courseName;
    private int quantityStudent;
    private boolean status;

    public Course () {}

    public Course(String courseId, String courseName, int quantityStudent, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.quantityStudent = quantityStudent;
        this.status = status;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getQuantityStudent() {
        return quantityStudent;
    }
    public void setQuantityStudent(int quantityStudent) {
        this.quantityStudent = quantityStudent;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
