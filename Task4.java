import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Task4 {

    public static void main(String[] args) {
        int press = 0;

        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> students = new ArrayList<Student>();

        courses.add(new Course("AA101", "Arabic", "Language", "8.00 am- 12.00 pm",30));
        courses.add(new Course("BC103", "Computer Application", "Common", "12.00 pm - 5.00 pm", 30));
        courses.add(new Course("BB102", "Engineering Science", "Common", "9.30 am- 11.00 pm", 30));
        courses.add(new Course("PB1105", "Entrepreneurship", "Common", "3.00 pm- 5.00 pm", 30));
        courses.add(new Course("As1104", "Soft Skills", "Compulsory", "8.00 am- 1.00 pm", 30));

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Welcome to Course Registration!...");
            System.out.println("Press 1 for Course registration:");
            System.out.println("Press 2 for registered course");
            System.out.println("Press 3 for To drop a course");
            System.out.println("Press  4 for Exit");
            press = scan.nextInt();

            switch (press) {
                case 1:
                    for (Course c : courses) {
                        c.displayCourseInfo();
                    }

                    System.out.println("Enter name of Student: ");
                    String studentName = scan.next();
                    System.out.println("Enter ID of Student: ");
                    String studentId = scan.next();
                    System.out.println("Enter Course code: ");
                    String courseCode = scan.next();

                    Student student = new Student(studentName, studentId, courseCode);
                    if (student.isAvailable(students, courses)) {
                        students.add(student);
                        System.out.println("Course successfully enrolled");
                    } else {
                        System.out.println("Not available for now");
                    }
                    break;
                    case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students registered yet.");
                    } else {
                        for (Student s : students) {
                            s.displayStudentInfo(courses);
                        }
                    }
                    break;
                    case 3:
                    System.out.println("Enter the ID of the Student to remove the course from: ");
                    String removeStudentId = scan.next();
                    System.out.println("Enter the Course code to remove: ");
                    String removeCourseCode = scan.next();

                    boolean removed = removeRegisteredCourse(students, removeStudentId, removeCourseCode);
                    if (removed) {
                        System.out.println("Course successfully removed");
                    } else {
                        System.out.println("Student not found or not enrolled in the course");
                    }
                    break; 
                    
                    default: 
                    System.out.println("Booking cancelled...");
                                    break;
            }
        } while (press != 4);

        scan.close();
     
    }
    public static boolean removeRegisteredCourse(ArrayList<Student> students, String studentId, String courseCode) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.studentId.equals(studentId) && s.courseCode.equals(courseCode)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

    



class Course {
    private String courseCode;
    private String courseTitle;
    private String description;
    private String schedule;
    private int capacity;

    Course(String code, String title, String desc, String sched, int cap) {
        this.courseCode = code;
        this.courseTitle = title;
        this.capacity = cap;
        this.schedule = sched;
        this.description = desc;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String code) {
        this.courseCode = code;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) {
        this.capacity = cap;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String sched) {
        this.schedule = sched;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void displayCourseInfo() {
        System.out.println("Course code: " + courseCode + " Course title: " + courseTitle + " Description: " + description + " Schedule: " + schedule + " Course Slots: " + capacity);
    }
}

class Student {
    String studentId;
    String studentName;
    String courseCode;

    Student(String studentName, String studentId, String courseCode) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public boolean isAvailable(ArrayList<Student> students, ArrayList<Course> courses) {
        int capacity = 0;
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                capacity = c.getCapacity();
            
            }
        }
        int booked = 0;
        for (Student s : students) {
            if (s.courseCode.equals(courseCode)) {
                booked++;
                
            }
        }
        return booked < capacity;
    }
    public void displayStudentInfo(ArrayList<Course> courses) {
        String courseTitle = "";
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                courseTitle = c.getCourseTitle();
                break;
            }
        }
        System.out.println("Student Name='" + studentName + "', id='" + studentId + "', courseCode='" + courseCode + "', courseTitle='" + courseTitle + "'");
    }
 
   
    }