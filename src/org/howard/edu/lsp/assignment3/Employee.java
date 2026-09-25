package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private BigDecimal hoursWorked;
    private BigDecimal hourlyRate;

    public Employee(int employeeId, String name, String department,
                    BigDecimal hoursWorked, BigDecimal hourlyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }
}