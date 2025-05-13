package firstExercise.courseManagement;

import java.util.ArrayList;

public class Course {
    private String id;

    private String name;

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArrayList<Student> Students() {
        return Manager.CourseStudents(id);
    }

    public Instructor Instructor() {
        return Manager.CourseInstructor(id);
    }

    // Removes student from the course if they exist
    public Course RemoveStudentIfExist(Student student) {
        if (student == null) return this;
        // Check if the student is already enrolled in this course
        ArrayList<Student> enrolledStudents = Manager.CourseStudents(this.id);
        boolean studentFound = false;
        for (Student s : enrolledStudents) {
            if (s != null && s.getId().equals(student.getId())) {
                studentFound = true;
                break;
            }
        }
        // If student is found, remove them
        if (studentFound) {
            Manager.RemoveStudentCourse(student.getId(), this.id);
        }

        return this;
    }

    // Changes the instructor for this course
    public Course ChangeInstructor(Instructor instructor) {
        if (instructor == null) return this;
        Manager.ChangeInstructor(this.id, instructor.getId());
        return this;
    }

    public String getId() { return id; }

    public String getName() { return name; }
}
