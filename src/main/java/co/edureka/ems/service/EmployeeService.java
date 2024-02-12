package co.edureka.ems.service;

import co.edureka.ems.dto.Employee;

public interface EmployeeService {
    void saveEmployee(Employee employee) throws Exception;
    void updateEmployee(int empno, Employee employee) throws Exception;
    void deleteEmployee(int empno) throws Exception;
    Employee searchEmployee(int eno) throws Exception;

    void getAllEmployee() throws Exception;
}
