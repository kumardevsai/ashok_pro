package com.cts.emp;

import java.util.Date;

public class EmployeePayRoll {

    private  Integer employeeId;
    private String paySlipNo;
    private Integer basicPay;
    private Integer numberOfDayOfLeave;
    private Date resignationDate;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPaySlipNo() {
        return paySlipNo;
    }

    public void setPaySlipNo(String paySlipNo) {
        this.paySlipNo = paySlipNo;
    }

    public Integer getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(Integer basicPay) {
        this.basicPay = basicPay;
    }

    public Integer getNumberOfDayOfLeave() {
        return numberOfDayOfLeave;
    }

    public void setNumberOfDayOfLeave(Integer numberOfDayOfLeave) {
        this.numberOfDayOfLeave = numberOfDayOfLeave;
    }

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }
}
