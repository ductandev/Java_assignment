/* *******************************
 * Author: Đức Tấn Dev
 * Date: 24/06/2024
 * Assigment: Đề 3: Quản lý khoá học
 * Description: Viết chương trình quản lý khóa học theo các mô tả và yêu cầu ở đề 3.
 * *******************************/
import Course.Course;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int userInputInt(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("Lỗi: Người dùng nhập số không hợp lệ.");
        }
        return choice;
    }

    public static String userInputString(){
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextLine();
        } catch (InputMismatchException exception){
            System.out.println("Lỗi: Người dùng nhập số không hợp lệ.");
        }
        return choice;
    }

    public static void showCourses(ArrayList<Course> courses){
        int stt = 1;
        System.out.println("=============================================");
        System.out.println("         DANH SÁCH KHÓA HỌC             ");
        System.out.println("Stt - ID Khóa học - Tên khóa học - Số lượng học viên - Trạng thái");
        for (Course course : courses){
            System.out.println(stt + " - " + course.getCourseId() + " - " + course.getCourseName() + " - " + course.getQuantityStudent() + " - " + course.getStatus());
            stt++;
        }
        System.out.println("=============================================");
    }

    public static void showCoursesDetail(ArrayList<Course> courses, String id ){
        for (Course item : courses){
             if (item.getCourseId().equals(id)){
                    System.out.println(item.getCourseName() + " - " + item.getQuantityStudent());
                return;
            }
        }
        System.out.println("Không tìm thấy khóa học mà bạn đang tìm kiếm !!!");
    }

    public  static void addCourse(ArrayList<Course> courses, int index, String courseId , String courseName, int quantityStudent, int choice2){
        if(courses.toArray().length >= 5){
            System.out.println("Chỉ được tổ chức tối đa 5 khoá học !!!");
        } else if (quantityStudent > 3) {
            System.out.println("Khoá học chỉ được tối đa 3 học viên !!!");
        } else {
            switch (choice2){
                case 2:
                    courses.add(new Course(courseId, courseName , quantityStudent,  quantityStudent == 3 ?  true : false ));
                    System.out.println("Thêm khóa học thành công !!!");
                    break;
                case 3:
                    index--;
                    courses.set( index ,new Course(courseId, courseName , quantityStudent, quantityStudent == 3 ?  true : false ));
                    System.out.println("Cập nhật khóa học thành công !!!");
                    break;
                default:
                    System.out.println("Vui lòng chỉ truyền case 2 hoặc 3");
                    break;
            }
            showCourses(courses);
        }
    }

    public static void deleteCourse(ArrayList<Course> courses, String courseId){
        for (Course item : courses){
            if (item.getCourseId().equals(courseId)){
                courses.remove(item);
                showCourses(courses);
                System.out.println("Đã xoá khóa học: " + item.getCourseName() + " - " + item.getQuantityStudent());
                return;
            }
        }
        System.out.println("Không tìm thấy khóa học với ID: " + courseId);
    }


    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("C01", "Khóa học Java 01" , 3, true ));
        courses.add(new Course("C02", "Khóa học Java 02" , 3, true ));
        courses.add(new Course("C03", "Khóa học Java 03" , 1, false ));
        courses.add(new Course("C04", "Khóa học Java 04" , 2, false ));

        System.out.println("============================================");
        System.out.println("+          ĐỀ 3: QUẢN LÝ KHÓA HỌC          +");
        System.out.println("============================================");
        System.out.println("1. Xem danh sách khóa học");
        System.out.println("2. Xem danh sách học viên");
        System.out.println("3. Exit");
        System.out.print("Chọn mục tương ứng: ");

        int choice1 = userInputInt();
        switch (choice1) {
            case 1:
                showCourses(courses);
                System.out.println("1. Xem chi tiết khoá học ");
                System.out.println("2. Thêm khoá học ");
                System.out.println("3. Sửa khoá học ");
                System.out.println("4. Xoá khoá học ");
                System.out.println("5. Exit ");
                System.out.print("Chọn mục tương ứng: ");

                int choice2 = userInputInt();
                switch (choice2){
                    case 1:
                        System.out.print("Khóa học ID: ");
                        String choice3 = userInputString();
                        showCoursesDetail(courses, choice3);
                        System.out.println("=============================================");
                        break;
                    case 2:
                        System.out.print("Khóa học ID: ");
                        String courseId = userInputString();
                        System.out.print("Tên khóa học: ");
                        String courseName = userInputString();
                        System.out.print("Số lượng học viên: ");
                        int quantityStudent = userInputInt();
                      //index = 0 (Truyền vào hàm nhưng không sử dụng, mục đích để hộp hàm add/edit để viết gọn code)
                        addCourse(courses, 0, courseId, courseName, quantityStudent, choice2);
                        break;
                    case 3:
                        System.out.print("Nhập vào index khóa học muốn sửa: ");
                        int indexCourse = userInputInt();
                        System.out.print("Khóa học ID: ");
                        String courseIdEdit = userInputString();
                        System.out.print("Tên khóa học: ");
                        String courseNameEdit = userInputString();
                        System.out.print("Số lượng học viên: ");
                        int quantityStudentEdit = userInputInt();
//                       editCourse(courses, courseIdEdit, courseNameEdit, quantityStudentEdit);
                        addCourse(courses, indexCourse, courseIdEdit, courseNameEdit, quantityStudentEdit, choice2);
                        break;
                    case 4:
                        System.out.print("Khóa học ID: ");
                        String courseID = userInputString();
                        deleteCourse(courses, courseID);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng chỉ nhập số nguyên dương 1, 2, 3, 4, 5 !!!");
                        break;
                }
                break;


            case 2:
                System.out.println("1. Thêm/sửa thông tin học viên");
                System.out.println("2. Xoá học viên ");
                System.out.println("3. Exit ");
                System.out.print("Chọn mục tương ứng: ");

                int choice3 = userInputInt();
                switch (choice3){
                    case 1:
                        System.out.println("Chọn 1");
                        break;
                    case 2:
                        System.out.println("Chọn 2");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng chỉ nhập số nguyên dương 1, 2, 3 !!!");
                        break;
                }
                break;


            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng chỉ nhập số nguyên dương 1, 2, 3 !!!");
                break;
        }

    }
}