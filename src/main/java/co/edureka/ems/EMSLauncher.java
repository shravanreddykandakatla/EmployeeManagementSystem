package co.edureka.ems;

import co.edureka.ems.dto.Employee;
import co.edureka.ems.service.EmployeeService;
import configs.ServiceFactory;

import java.util.Scanner;

public class EMSLauncher {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Employee employee;
        int empno;
        EmployeeService service= ServiceFactory.getEmployeeService();
        while(true){
            System.out.println("1. New Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. All Employees");
            System.out.println("6. Exit");

            System.out.print("\nEnter an option: ");
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    employee= getEmployee();
                    service.saveEmployee(employee);
                    break;
                case 2:
                    System.out.println("Enter the Employee ID: ");
                    int eno=scanner.nextInt();
                    employee=service.searchEmployee(eno);
                    if(employee!=null) {
                        System.out.println(employee.toString());
                    }else{
                        System.out.println("------No matching employee record found!!!------");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Employee ID you want to update: ");
                    int empNo=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the Name: ");
                    String name=scanner.nextLine();
                    System.out.print("Enter the Salary: ");
                    float sal=scanner.nextFloat();
                    employee=new Employee(empNo,name,sal);
                    service.updateEmployee(empNo,employee);
                    break;
                case 4:
                    System.out.println("Enter the Employee ID you want to Delete: ");
                    int empId=scanner.nextInt();
                    employee=service.searchEmployee(empId);
                    if(employee!=null) {
                        System.out.println(employee.toString());
                        System.out.print("Do you want to delete this Employee[Y/N]: ");
                        String question=scanner.next();
                        if(question.equalsIgnoreCase("Y")) {
                            service.deleteEmployee(empId);
                        }
                    }else{
                        System.out.println("-----Employee don't exist!!!-----");
                    }
                    break;
                case 5:
                    service.getAllEmployee();
                    break;
                case 6:
                    System.out.println("^^^^----APPLICATION CLOSED----^^^^");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("#####---INVALID OPTION---####");


            }
            System.out.println();
        }

    }

    private static Employee getEmployee() {
        System.out.print("Enter the Employee ID: ");
        int empNo=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Employee Name: ");
        String empName=scanner.nextLine();
        System.out.print("Enter the Employee Salary: ");
        float sal=scanner.nextFloat();
        Employee employee= new Employee(empNo,empName,sal);
        return employee;

    }
}
