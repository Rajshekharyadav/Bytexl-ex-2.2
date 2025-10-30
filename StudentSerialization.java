import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice");

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("Student serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student deserialized = (Student) ois.readObject();
            System.out.println("Deserialized: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
