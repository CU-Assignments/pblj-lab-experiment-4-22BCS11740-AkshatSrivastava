import java.util.*; 
class Employee { 
    int id; 
    String name; 
    double salary; 
    public Employee(int id, String name, double salary) { 
        this.id = id; 
        this.name = name; 
        this.salary = salary; 
    } 
    public String toString() { 
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary; 
    } 
} 
class EmployeeManagementSystem { 
    List<Employee> employees = new ArrayList<>(); 
 
    public void addEmployee(int id, String name, double salary) { 
        for (Employee emp : employees) { 
            if (emp.id == id) { 
                System.out.println("Error: Employee with ID " + id + " already exists."); 
                return; 
            } 
        } 
        employees.add(new Employee(id, name, salary)); 
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary); 
    } 
    public void updateEmployee(int id, double newSalary) { 
        for (Employee emp : employees) { 
            if (emp.id == id) { 
                emp.salary = newSalary; 
                System.out.println("Employee ID " + id + " updated successfully."); 
                return; 
            } 
        } 
        System.out.println("Error: Employee ID " + id + " not found."); 
    } 
    public void removeEmployee(int id) { 
        Iterator<Employee> iterator = employees.iterator(); 
        while (iterator.hasNext()) { 
            Employee emp = iterator.next(); 
            if (emp.id == id) { 
                iterator.remove(); 
                System.out.println("Employee ID " + id + " removed successfully."); 
                return; 
            } 
        } 
        System.out.println("Error: Employee ID " + id + " not found."); 
    } 
    public void searchEmployeeById(int id) { 
        for (Employee emp : employees) { 
            if (emp.id == id) { 
                System.out.println("Employee Found: " + emp); 
                return; 
            } 
        } 
        System.out.println("Error: Employee ID " + id + " not found."); 
    } 
    public void displayEmployees() { 
        if (employees.isEmpty()) { 
            System.out.println("No employees found."); 
        } else { 
            for (Employee emp : employees) { 
                System.out.println(emp); 
            }}}} 
public class Main { 
    public static void main(String[] args) { 
        EmployeeManagementSystem ems = new EmployeeManagementSystem(); 
        ems.displayEmployees(); 
        ems.addEmployee(101, "Anish", 50000); 
        ems.addEmployee(102, "Bobby", 60000); 
        ems.updateEmployee(101, 55000); 
        ems.searchEmployeeById(102); 
        ems.removeEmployee(101); 
        ems.displayEmployees(); 
        ems.addEmployee(101, "Charlie", 70000); 
    }} 
 
