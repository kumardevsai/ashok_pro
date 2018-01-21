package com.cts.emp;

import com.cts.emp.util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
       new EmployeeImp().getEmployeeSalaryDetails();
       new EmployeeImp().getEmployeeGratuityDetails();
       new EmployeeImp().getCountOfEmployees();
       new EmployeeImp().getEmployeesWithSameJoiningDate();
       new EmployeeImp().getResignedEmployeeNames();
       //new EmployeeImp().getEmployeeAsPerSeniorty();

    }
}
