package co.edureka.ems.service.impl;

import co.edureka.ems.dao.EmployeeDAO;
import co.edureka.ems.dao.impl.EmployeeDAOImpl;
import co.edureka.ems.dto.Employee;
import co.edureka.ems.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO dao;

    public EmployeeServiceImpl()throws Exception{
        dao=new EmployeeDAOImpl();

    }
    @Override
    public void saveEmployee(Employee employee) throws Exception {
        try{
            int n=dao.saveEmployee(employee);
            if(n>0) {
                System.out.println("Employee Saved!!!");
            }
        }catch(Exception ex){
                System.out.println(ex.toString());
            }

    }



    @Override
    public void updateEmployee(int empno, Employee employee) throws Exception {
        try{
        int n= dao.updateEmployee(empno,employee);
            if(n>0) {
                System.out.println("Employee Updated!!!");
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    @Override
    public void deleteEmployee(int empno) throws Exception {
        try{
            int n= dao.deleteEmployee(empno);
            if(n>0) {
                System.out.println("Employee Deleted!!!");
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    @Override
    public Employee searchEmployee(int eno) throws Exception {
        return dao.findEmployee(eno);
    }

    @Override
    public void getAllEmployee() throws Exception {
        List<Employee> employees=dao.findAll();
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}
