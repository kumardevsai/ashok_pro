package com.cts.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeDep {


    static HashMap<String, Object> depCode = new  HashMap<String, Object>();

    public static HashMap<String, Object> getDepartment(String code) throws Exception{
        Map<Integer, ArrayList<Object>> gratuityDetails = EmployeeMap.getEmployeeMap();
        HashMap<String, HashMap> rangMap = new HashMap<String, HashMap>();
        HashMap<Integer, Object> r1 = new HashMap<Integer, Object>();
        HashMap<Integer, Object> r2 = new HashMap<Integer, Object>();
        HashMap<Integer, Object> r3 = new HashMap<Integer, Object>();
        for (Map.Entry<Integer, ArrayList<Object>> g : gratuityDetails.entrySet()) {
           if (g.getValue().get(3).equals(code)) {
                int basicSalary = Integer.valueOf(g.getValue().get(8).toString());
                int hra = 0;
                if (basicSalary < 20000) {
                    hra = Integer.valueOf((basicSalary * 75 / 100));
                } else {
                    hra = Integer.valueOf((basicSalary * 50 / 100));
                }
                int totalSal = basicSalary + hra - (basicSalary / 30) * Integer.parseInt(g.getValue().get(9).toString());
                int perAnum = totalSal * 12;
                String range = "R3";
                if(50000 <= perAnum){
                   range = "R1";
                   r1.put(g.getKey(), g.getValue());
                 }else if(100000 <= perAnum){
                    range = "R2";
                    r2.put(g.getKey(), g.getValue());
                }else{
                    range = "R3";
                    r3.put(g.getKey(), g.getValue());
                }
             }
        }
        rangMap.put("R1", r1);
        rangMap.put("R2", r2);
        rangMap.put("R3", r3);
        depCode.put(code, rangMap);
        return depCode;
    }
}
