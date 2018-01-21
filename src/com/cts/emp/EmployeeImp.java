package com.cts.emp;

import com.cts.emp.deo.EmployeeDeo;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;

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
            HashMap<String, Object> f = new EmployeDep().getDepartment("F");
            System.out.println(f);
            HashMap<String, Object> s = new EmployeDep().getDepartment("S");
            System.out.println(s);
            HashMap<String, Object> m = new EmployeDep().getDepartment("M");
            System.out.println(m);
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
         try {
             Map<Integer, ArrayList<Object>> employeeJoinSameDate = EmployeeMap.getEmployeeMap();
             DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
             ArrayList<String> empJoinDate = null;
             for(ArrayList<Object> employeeJoinSameDateList : employeeJoinSameDate.values()){
                  empJoinDate = new ArrayList<String>();
                 String dateStr1 = employeeJoinSameDateList.get(2).toString();
                 Date date1 = (Date) formatter.parse(dateStr1);
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(date1);
                 String formatedDate1 = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
                for(ArrayList<Object> empJoinSameDate : employeeJoinSameDate.values()) {
                     String dateStr2 = empJoinSameDate.get(2).toString();
                     Date date2 = (Date) formatter.parse(dateStr2);
                     cal.setTime(date2);
                     String formatedDate2 = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
                     if(formatedDate1.equals(formatedDate2)){
                         empJoinDate.add(employeeJoinSameDateList.get(0).toString());
                         empJoinDate.add(employeeJoinSameDateList.get(1).toString());
                         empJoinDate.add(formatedDate1);

                     }

                 }
                 System.out.println("Emloyees Same Join Date : " + empJoinDate);
              }

         }catch (Exception e){e.printStackTrace();}
     }

     public void getEmployeeAsPerSeniorty(){

     }

     public void getEmployeeSecretCode(){

     }

     public void getResignedEmployeeNames(){
        try {
            Map<Integer, ArrayList<Object>> employees = EmployeeMap.getEmployeeMap();
            System.out.println("*********** Resigned Employee Names:");
            for(ArrayList<Object> employee : employees.values()){
                if(employee.get(10) != null){
                   System.out.println(employee.get(4));
                }
            }
        }catch(Exception e){e.printStackTrace();}
     }
}
