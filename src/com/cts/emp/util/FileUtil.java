package com.cts.emp.util;

import com.cts.emp.Employee;
import com.cts.emp.EmployeePayRoll;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUtil {

    private Map<Integer, List<Employee>> employeeMap = null;
    private List<Employee> employeeList = null;
    private Map<Integer, List<EmployeePayRoll>> employeePayRollMap = null;
    private List<EmployeePayRoll> employeePayRollList = null;

    public  Map<Integer, List<Employee>> getEmployeeList() throws IOException, URISyntaxException {
        URL path = ClassLoader.getSystemResource("EmployeeMaster.txt");
        if(path==null) {
            throw new FileNotFoundException();
        }
        File f = new File(path.toURI());

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = null;
        ArrayList<Employee> list = null;
        employeeMap = new HashMap<Integer, List<Employee>>();
        while((line = reader.readLine()) != null) {
            employeeList = new ArrayList<Employee>();
            Employee emp = new Employee();
            emp.setEmployeeId(Integer.parseInt(line.split(",")[0]));
            emp.setEmployeeName(line.split(",")[1]);
            emp.setDepartmentCode(line.split(",")[2]);
            try {
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(line.split(",")[3]);
                emp.setDateOfJoin(date);
            }catch(ParseException e){
                e.printStackTrace();
            }
            emp.setMobileNo(line.split(",")[4]);
            emp.setEmail(line.split(",")[5]);
            employeeList.add(emp);
            employeeMap.put(emp.getEmployeeId(), employeeList);
         }
       // Always close files.
        reader.close();
       return employeeMap;
      }


    public  Map<Integer, List<EmployeePayRoll>> getEmployeePayRoll() throws IOException, URISyntaxException {
        URL path = ClassLoader.getSystemResource("EmployeePayRoll.txt");
        if(path==null) {
            throw new FileNotFoundException();
        }
        File f = new File(path.toURI());

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = null;
        ArrayList<EmployeePayRoll> list = null;
        employeePayRollMap = new HashMap<Integer, List<EmployeePayRoll>>();
        while((line = reader.readLine()) != null) {
            employeePayRollList = new ArrayList<EmployeePayRoll>();
            EmployeePayRoll emp = new EmployeePayRoll();
            String paySlip = line.split(",")[0].toString();
            Integer employeeId = Integer.parseInt(paySlip.split("/")[0]);
            emp.setEmployeeId(employeeId);
            emp.setPaySlipNo(paySlip);
            emp.setBasicPay(Integer.parseInt(line.split(",")[1]));
            emp.setNumberOfDayOfLeave(Integer.parseInt(line.split(",")[2]));
           try {
               int resignationDateLen = line.split(",").length;
               if(resignationDateLen > 3){
                   Date date = new SimpleDateFormat("dd-MM-yyyy").parse(line.split(",")[3]);
                   emp.setResignationDate(date);
                 }
            }catch(ParseException e){
                e.printStackTrace();
            }catch (ArrayIndexOutOfBoundsException e){
               e.printStackTrace();
           }

            employeePayRollList.add(emp);
            employeePayRollMap.put(emp.getEmployeeId(), employeePayRollList);
        }
       // Always close files.
        reader.close();
        return employeePayRollMap;
    }

}
