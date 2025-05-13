package firstExercise.courseManagement;

import java.util.ArrayList;

import java.util.ArrayList;

public class Instructor {
    private String id;
    private String name;

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public String getId() { return id; }
    public String getName() { return name; }

    public Instructor(String id, String name) {
        this.id = id;
        this.name = name;
    }

//    public ArrayList<Student> Students() {
//        return Manager.InstructorStudents(id);
//    }
//
//    public ArrayList<Course> Courses() {
//        return Manager.InstructorCourses(id);
//    }
}

