package com.cts.emp;

import com.cts.emp.util.FileUtil;

import java.util.*;

public class EmployeeMap {

    static private Map<Integer, ArrayList<Object>> newMap = new LinkedHashMap<Integer, ArrayList<Object>>();

    public static Map<Integer, ArrayList<Object>> getEmployeeMap() throws Exception{

        Map<Integer, List<Employee>> employeesMap =  EmployeeList.getEmployeesList();
        Map<Integer, List<EmployeePayRoll>> employeePayRollMap =  new FileUtil().getEmployeePayRoll();

        for (Map.Entry<Integer, List<Employee>> m : employeesMap.entrySet()) {
            List<Employee> values = m.getValue();
            List<Object> l = new ArrayList<Object>();
           for(Employee emp : values){
                l.add(emp.getEmployeeId());
                l.add(emp.getEmail());
                l.add(emp.getDateOfJoin());
                l.add(emp.getDepartmentCode());
                l.add(emp.getEmployeeName());
                l.add(emp.getMobileNo());
             }

               List<EmployeePayRoll> m1 = employeePayRollMap.get(m.getKey());
              if(!m1.isEmpty()) {
                  for (EmployeePayRoll emp : m1) {
                      l.add(emp.getEmployeeId());
                      l.add(emp.getPaySlipNo());
                      l.add(emp.getBasicPay());
                      l.add(emp.getNumberOfDayOfLeave());
                      l.add(emp.getResignationDate());
                  }
              }
              newMap.put(m.getKey(), (ArrayList<Object>) l);
         }
         return newMap;
    }


}
