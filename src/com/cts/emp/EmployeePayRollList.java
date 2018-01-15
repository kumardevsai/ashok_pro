package com.cts.emp;

import com.cts.emp.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EmployeePayRollList {

    public  static Map<Integer, List<EmployeePayRoll>> getEmployeesPayRollList() throws IOException, URISyntaxException {

        Map<Integer, List<EmployeePayRoll>> employeesMap =  new FileUtil().getEmployeePayRoll();

        for (Map.Entry<Integer, List<EmployeePayRoll>> m : employeesMap.entrySet()) {
            List<EmployeePayRoll> values = m.getValue();
            for(EmployeePayRoll emp : values){
                String empData = "[" + emp.getEmployeeId() +  "," + emp.getPaySlipNo() + "," + emp.getBasicPay() + "," + emp.getNumberOfDayOfLeave() + "," + emp.getResignationDate()+ "]";
                System.out.println(m.getKey()+ " --> " + empData);
            }
        }
        return employeesMap;
    }
}
