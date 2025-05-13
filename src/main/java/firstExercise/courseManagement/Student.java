package firstExercise.courseManagement;

import java.util.ArrayList;

public class Student extends Person {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public String getId() { return id; }

    public String getName() { return name; }

    public ArrayList<Course> Courses() {
        return Manager.StudentCourses(id);
    }

    public ArrayList<Instructor> Instructors() {
        return Manager.StudentInstructors(id);
    }

    public Student EnrollCourse(Course course) {
        if (course == null) return this;

        // Check if the student is already enrolled
        ArrayList<Course> enrolledCourses = Manager.StudentCourses(this.id);
        boolean isEnrolled = false;
        for (Course c : enrolledCourses) {
            if (c != null && c.getId().equals(course.getId())) {
                isEnrolled = true;
                break;
            }
        }

        // If not enrolled, enroll the student
        if (!isEnrolled) {
            Manager.EnrollStudentCourse(this.id, course.getId());
        }

        return this;
    }
}
