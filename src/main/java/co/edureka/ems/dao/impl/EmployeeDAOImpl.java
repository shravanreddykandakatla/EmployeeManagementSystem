package co.edureka.ems.dao.impl;

import co.edureka.ems.dto.Employee;
import co.edureka.ems.dao.EmployeeDAO;
import configs.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Statement st=null;
    public EmployeeDAOImpl() throws Exception{
        Connection con= ConnectionFactory.getDBConnection();
        st= con.createStatement();
    }
    @Override
    public Integer saveEmployee(Employee emp) throws Exception {
        String sql="insert into emp values("+emp.getEmpNo()+",'"+emp.getEmpName()+"',"+emp.getEmpSal()+")";
        int n=st.executeUpdate(sql);
        return n;
    }

    @Override
    public Integer updateEmployee(int eno, Employee emp) throws Exception {
        String sql="update emp set ename='"+emp.getEmpName()+"',sal="+emp.getEmpSal()+ " where empno="+emp.getEmpNo();
        int n=st.executeUpdate(sql);
        return n;
    }

    @Override
    public Integer deleteEmployee(int eno) throws Exception {
        String sql="delete from emp where empno="+eno;
        int n=st.executeUpdate(sql);
        return n;
    }

    @Override
    public Employee findEmployee(int eno) throws Exception {
        String sql="select ename,sal from emp where empno="+eno ;
        ResultSet rs=st.executeQuery(sql);
        Employee emp=null;
        if (rs.next()){

            String empName=rs.getString(1);
            float sal= rs.getFloat(2);
            emp=new Employee(eno,empName,sal);
        }
        return emp;
    }

    @Override
    public List<Employee> findAll() throws Exception {
        List<Employee> employees= new ArrayList<Employee>();
        String sql="select * from emp";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            int empNo=rs.getInt(1);
            String empName=rs.getString(2);
            float sal= rs.getFloat(3);
            Employee employee=new Employee(empNo,empName,sal);
            employees.add(employee);
        }
        return employees;
    }
}
