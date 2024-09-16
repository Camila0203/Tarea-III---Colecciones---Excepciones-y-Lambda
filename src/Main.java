import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagerImpl manager = new StudentManagerImpl();

        // Agregar estudiantes
        manager.addStudent(new Student(1, "Alice", 22));
        manager.addStudent(new Student(2, "Bob", 19));
        manager.addStudent(new Student(3, "Charlie", 23));

        // Mostrar todos los estudiantes
        System.out.println("All students:");
        manager.getAllStudents().forEach(System.out::println);

        // Filtrar estudiantes mayores de 21 años
        System.out.println("\nStudents older than 21:");
        manager.filterStudentsByAge(21).forEach(System.out::println);

        // Ordenar estudiantes por nombre
        System.out.println("\nStudents sorted by name:");
        manager.sortStudentsByName().forEach(System.out::println);

        // Buscar estudiante por ID
        try {
            System.out.println("\nFinding student with ID 2:");
            Student student = manager.findStudent(2);
            System.out.println(student);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Eliminar estudiante por ID
        manager.removeStudent(2);
        System.out.println("\nStudents after removing ID 2:");
        manager.getAllStudents().forEach(System.out::println);
    }
}
    }