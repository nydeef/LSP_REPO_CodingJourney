package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollProcessor {

    public BigDecimal calculateGrossPay(Employee employee) {

        BigDecimal hours = employee.getHoursWorked();
        BigDecimal hourlyRate = employee.getHourlyRate();

        BigDecimal normalHours =
                hours.min(new BigDecimal("40"));

        BigDecimal overtimeHours =
                hours.subtract(normalHours);

        BigDecimal normalPay =
                normalHours.multiply(hourlyRate);

        BigDecimal overtimePay =
                overtimeHours
                        .multiply(hourlyRate)
                        .multiply(new BigDecimal("1.5"));

        BigDecimal grossPay =
                normalPay.add(overtimePay);

        // IT bonus
        if (employee.getDepartment().equals("IT")) {
            grossPay = grossPay.multiply(new BigDecimal("1.05"));
        }

        return grossPay.setScale(2, RoundingMode.HALF_UP);
    }

    public String determinePayLevel(BigDecimal grossPay) {

        if (grossPay.compareTo(new BigDecimal("500")) < 0) {
            return "Low";
        } else if (grossPay.compareTo(new BigDecimal("1000")) < 0) {
            return "Standard";
        } else if (grossPay.compareTo(new BigDecimal("2000")) < 0) {
            return "High";
        } else {
            return "Executive";
        }
    }

    public String determineEmploymentStatus(Employee employee) {

        if (employee.getHoursWorked().compareTo(new BigDecimal("30")) < 0) {
            return "Part-Time";
        } else {
            return "Full-Time";
        }
    }
}