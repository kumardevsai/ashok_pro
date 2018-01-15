package com.cts.emp;

import com.cts.emp.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeList {

    public  static Map<Integer, List<Employee>> getEmployeesList() throws IOException, URISyntaxException {

        Map<Integer, List<Employee>> employeesMap =  new FileUtil().getEmployeeList();

//        for (Map.Entry<Integer, List<Employee>> m : employeesMap.entrySet()) {
//            List<Employee> values = m.getValue();
//            for(Employee emp : values){
//                String empData = "[" + emp.getEmployeeId() +  "," + emp.getEmail() + "," + emp.getDateOfJoin() + "," + emp.getEmployeeName() + "," + emp.getMobileNo() + "]";
//                System.out.println(m.getKey()+ " --> " + empData);
//            }
//        }
         return employeesMap;
    }
}
