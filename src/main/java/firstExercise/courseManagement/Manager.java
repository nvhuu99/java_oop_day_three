package firstExercise.courseManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    // List to store all students, courses, and instructors
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Instructor> instructors = new ArrayList<>();

    // A HashMap to track which students are enrolled in which courses
    private static HashMap<String, ArrayList<Course>> studentEnrollment = new HashMap<>();

    // A HashMap to track which course is taught by which instructor
    private static HashMap<String, Instructor> courseInstructor = new HashMap<>();

    // Get the list of courses a student is enrolled in
    public static ArrayList<Course> StudentCourses(String studentId) {
        return studentEnrollment.getOrDefault(studentId, new ArrayList<>());
    }

    // Get the list of instructors for a student
    public static ArrayList<Instructor> StudentInstructors(String studentId) {
        ArrayList<Instructor> studentInstructors = new ArrayList<>();
        ArrayList<Course> studentCourses = StudentCourses(studentId);

        // Loop through courses to get the instructors
        for (Course course : studentCourses) {
            Instructor instructor = courseInstructor.get(course.getId());
            if (instructor != null) {
                studentInstructors.add(instructor);
            }
        }
        return studentInstructors;
    }

    // Get the list of students in a course
    public static ArrayList<Student> CourseStudents(String courseId) {
        ArrayList<Student> courseStudents = new ArrayList<>();
        for (String studentId : studentEnrollment.keySet()) {
            ArrayList<Course> enrolledCourses = studentEnrollment.get(studentId);
            for (Course course : enrolledCourses) {
                if (course.getId().equals(courseId)) {
                    courseStudents.add(findStudentById(studentId));
                    break;
                }
            }
        }
        return courseStudents;
    }

    // Get the instructor for a course
    public static Instructor CourseInstructor(String courseId) {
        return courseInstructor.get(courseId);
    }

    // Add a course
    public static Course AddCourse(String id, String name) {
        Course course = new Course(id, name);
        courses.add(course);
        return course;
    }

    // Add a student
    public static Student AddStudent(String id, String name) {
        Student student = new Student(id, name);
        students.add(student);
        studentEnrollment.put(id, new ArrayList<>());  // Initialize empty course list for student
        return student;
    }

    // Add an instructor
    public static Instructor AddInstructor(String id, String name) {
        Instructor instructor = new Instructor(id, name);
        instructors.add(instructor);
        return instructor;
    }

    // Enroll a student in a course
    protected static void EnrollStudentCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            ArrayList<Course> enrolledCourses = studentEnrollment.get(studentId);
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
            }
        }
    }

    // Remove a student from a course
    protected static void RemoveStudentCourse(String studentId, String courseId) {
        ArrayList<Course> enrolledCourses = studentEnrollment.get(studentId);
        if (enrolledCourses != null) {
            enrolledCourses.removeIf(course -> course.getId().equals(courseId));
        }
    }

    // Change the instructor for a course
    protected static void ChangeInstructor(String courseId, String instructorId) {
        Course course = findCourseById(courseId);
        Instructor instructor = findInstructorById(instructorId);

        if (course != null && instructor != null) {
            courseInstructor.put(courseId, instructor);
        }
    }

    // Helper methods to find entities by ID
    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private static Instructor findInstructorById(String instructorId) {
        for (Instructor instructor : instructors) {
            if (instructor.getId().equals(instructorId)) {
                return instructor;
            }
        }
        return null;
    }
}
