package co.edureka.ems.dto;

public class Employee {
    private Integer empNo;
    private String empName;
    private Float empSal;

    public Employee(){
        super();
    }
    public Employee(Integer empNo, String empName, Float empSal) {
        super();
        this.empNo = empNo;
        this.empName = empName;
        this.empSal = empSal;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Float getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Float empSal) {
        this.empSal = empSal;
    }

    @Override
    public String toString() {
        return String.format("Employee [%-3d | %-15s | %.2f]",empNo,empName,empSal);
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "empNo=" + empNo +
//                ", empName='" + empName + '\'' +
//                ", empSal=" + empSal +
//                '}';
//    }
}
