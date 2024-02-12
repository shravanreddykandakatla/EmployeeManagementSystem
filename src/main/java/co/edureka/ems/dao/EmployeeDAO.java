package co.edureka.ems.dao;

import co.edureka.ems.dto.Employee;

import java.util.List;

public interface EmployeeDAO {
    Integer saveEmployee(Employee emp) throws Exception;
    Integer updateEmployee(int eno,Employee emp) throws Exception;
    Integer deleteEmployee(int eno) throws Exception;
    Employee findEmployee(int eno) throws Exception;
    List<Employee> findAll() throws Exception;
}
