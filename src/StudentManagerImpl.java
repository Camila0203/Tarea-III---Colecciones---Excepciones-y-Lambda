import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentManagerImpl implements StudentManager {
    private GenericList<Student> students;

    public StudentManagerImpl() {
        this.students = new GenericList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(int id) {
        Student student = (Student) students.find(id);
        if (student != null) {
            students.remove(student);
        }
    }

    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        Student student = (Student) students.find(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return students.getList();
    }

    public List<Student> filterStudentsByAge(int age) {
        return students.getList().stream()
                .filter(student -> student.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<Student> sortStudentsByName() {
        return students.getList().stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());
    }
}
