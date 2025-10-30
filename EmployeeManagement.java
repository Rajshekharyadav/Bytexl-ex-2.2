import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int empId;
    String name;
    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    public String toString() {
        return "Employee{id=" + empId + ", name='" + name + "'}";
    }
}

public class EmployeeManagement {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "employees.dat";
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Delete Employee\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    employeeList.add(new Employee(id, name));
                    saveEmployees(filename);
                    break;
                case 2:
                    loadEmployees(filename);
                    employeeList.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    loadEmployees(filename);
                    employeeList.removeIf(e -> e.empId == delId);
                    saveEmployees(filename);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    static void saveEmployees(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadEmployees(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employeeList = (List<Employee>) ois.readObject();
        } catch (Exception e) {
            employeeList = new ArrayList<>();
        }
    }
}
