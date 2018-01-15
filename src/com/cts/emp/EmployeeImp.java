package com.cts.emp;

import com.cts.emp.deo.EmployeeDeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeImp implements EmployeeDeo {

    public void getEmployeeSalaryDetails(){
        try {
            Map<Integer, ArrayList<Object>> salaryDetails = EmployeeMap.getEmployeeMap();
            System.out.println("===========Get Salary Details===========");
            for (Map.Entry<Integer, ArrayList<Object>> s : salaryDetails.entrySet()) {
                int basicSalary = Integer.valueOf(s.getValue().get(8).toString());
                int hra = 0;
                if (basicSalary < 20000) {
                    hra = Integer.valueOf((basicSalary * 75 / 100));
                } else {
                    hra = Integer.valueOf((basicSalary * 50 / 100));
                }
                int totalSal = basicSalary + hra - (basicSalary / 30) * Integer.parseInt(s.getValue().get(9).toString());
                String sal = "EmployeeId:" + " " + s.getValue().get(0) + ", " + " Salary: " + " " + totalSal;
                System.out.println(sal);
            }
        }catch (Exception e ){e.printStackTrace();}
        System.out.println("===========End Salary Details===========");
    }

    public void getEmployeeGratuityDetails() {
        try {
            Map<Integer, ArrayList<Object>> gratuityDetails = EmployeeMap.getEmployeeMap();
            System.out.println("===========Get Gratuity Details===========");
            for (Map.Entry<Integer, ArrayList<Object>> g : gratuityDetails.entrySet()) {
                if (g.getValue().get(3).equals("F")) {
                    HashMap<String, HashMap<Integer, Object>> f = new HashMap<>();
                    HashMap<String, HashMap<Integer, Object>> fmap = new HashMap<String, HashMap<Integer, Object>>();
                    HashMap<Integer, Object> rmap = new HashMap<Integer, Object>();
                    f.put("F", fmap.put("R1", (HashMap<Integer, Object>) rmap.put(g.getKey(), g.getValue())));
                    System.out.println("F" + "" + "[" + "R1" + "]");
                }
                if (g.getValue().get(3).equals("S")) {
                    HashMap<String, HashMap<Integer, Object>> s = new HashMap<>();
                    HashMap<String, HashMap<Integer, Object>> smap = new HashMap<String, HashMap<Integer, Object>>();
                    HashMap<Integer, Object> rmap = new HashMap<Integer, Object>();
                    s.put("S", smap.put("R1", (HashMap<Integer, Object>) rmap.put(g.getKey(), g.getValue())));
                    System.out.println(s);
                }
                if (g.getValue().get(3).equals("M")) {
                    HashMap<String, HashMap<Integer, Object>> m = new HashMap<>();
                    HashMap<String, HashMap<Integer, Object>> mmap = new HashMap<String, HashMap<Integer, Object>>();
                    HashMap<Integer, Object> rmap = new HashMap<Integer, Object>();
                    m.put("M", mmap.put("R1", (HashMap<Integer, Object>) rmap.put(g.getKey(), g.getValue())));
                    System.out.println(m);
                }
            }
        }catch (Exception e) {e.printStackTrace();}
        System.out.println("===========End Gratuity Details===========");
    }

     public void getTopPaidEmployeeByDepartment() {
       try{

       }catch (Exception e) {e.printStackTrace();}
     }

    public void getCountOfEmployees() {
        try{
            Map<Integer, ArrayList<Object>> gratuityDetails = EmployeeMap.getEmployeeMap();
            System.out.println("=========== getCountOfEmployees ===========");
              int fcount = 0;
              for (Map.Entry<Integer, ArrayList<Object>> g : gratuityDetails.entrySet()) {
                  if (g.getValue().get(3).equals("F")) {
                      fcount = fcount + 1;
                  }
               }
               System.out.println("Department F:" + " " + fcount);

            int scount = 0;
            for (Map.Entry<Integer, ArrayList<Object>> g : gratuityDetails.entrySet()) {
                if (g.getValue().get(3).equals("S")) {
                    scount = scount + 1;
                }
            }
            System.out.println("Department S:" + " " + scount);

            int mcount = 0;
            for (Map.Entry<Integer, ArrayList<Object>> g : gratuityDetails.entrySet()) {
                if (g.getValue().get(3).equals("M")) {
                    mcount = mcount + 1;
                }
            }
            System.out.println("Department M:" + " " + mcount);

        }catch (Exception e) {e.printStackTrace();}
    }

     public void getEmployeesWithSameJoiningDate(){

     }
}
