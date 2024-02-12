package configs;

import co.edureka.ems.service.EmployeeService;
import co.edureka.ems.service.impl.EmployeeServiceImpl;

public class ServiceFactory {
    private static EmployeeService service;

    public static EmployeeService getEmployeeService() throws Exception {
        if(service==null){
            service=new EmployeeServiceImpl();
        }
        return service;

    }
}
