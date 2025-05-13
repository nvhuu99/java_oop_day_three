package firstExercise.courseManagement;

public class Main {
    public static void main(String[] args) {
        // Initialize the Application
        // Add Courses
        Course javaCourse = Manager.AddCourse("java", "Java Programming");
        Course phpCourse = Manager.AddCourse("php", "PHP Programming");
        Course mysqlCourse = Manager.AddCourse("mysql", "MySQL Database");

        // Add Students and Enroll them
        Student s1 = Manager.AddStudent("S1", "Alice")
                .EnrollCourse(javaCourse)
                .EnrollCourse(phpCourse)
                .EnrollCourse(mysqlCourse);

        Manager.AddStudent("S2", "Bob")
                .EnrollCourse(javaCourse)
                .EnrollCourse(phpCourse);

        Manager.AddStudent("S3", "Charlie")
                .EnrollCourse(javaCourse);

        // Set course names (simulating that the names were set during creation, or changed later)
        javaCourse.setName("Advanced Java Programming");
        phpCourse.setName("PHP for Web Development");

        // Remove a student from a course
        javaCourse.RemoveStudentIfExist(s1);

        // Display students enrolled in each course
        System.out.println("Students enrolled in Java course:");
        for (Student student : javaCourse.Students()) {
            System.out.println(student.getName());
        }

        // Display instructors for a student
        System.out.println("Instructors for Alice:");
        for (Instructor instructor : s1.Instructors()) {
            System.out.println(instructor.getName());
        }
    }
}
