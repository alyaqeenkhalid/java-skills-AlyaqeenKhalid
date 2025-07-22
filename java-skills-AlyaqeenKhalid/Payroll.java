public class PayrollCalculator {

    // Calculate weekly pay based on employee type and hours worked
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double pay = 0;

        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid hours or rate.");
            return 0;
        }

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    pay = hoursWorked * hourlyRate;
                } else {
                    double overtimeHours = hoursWorked - 40;
                    pay = (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
                }
                break;

            case "PART_TIME":
                // Max 25 hours, no overtime pay
                double validHours = Math.min(hoursWorked, 25);
                pay = validHours * hourlyRate;
                break;

            case "CONTRACTOR":
                // Flat rate pay: hoursWorked * hourlyRate (no overtime rules)
                pay = hoursWorked * hourlyRate;
                break;

            case "INTERN":
                // Max 20 hours, 20% discount on hourly rate
                double internHours = Math.min(hoursWorked, 20);
                pay = internHours * hourlyRate * 0.8;  // 20% less
                break;

            default:
                System.out.println("Invalid employee type.");
                pay = 0;
        }
        return pay;
    }

    // Calculate tax deduction based on gross pay and health insurance status
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxRate;

        if (grossPay <= 500) {
            taxRate = 0.10;
        } else if (grossPay <= 1000) {
            taxRate = 0.15;
        } else if (grossPay <= 2000) {
            taxRate = 0.20;
        } else {
            taxRate = 0.25;
        }

        double tax = grossPay * taxRate;

        if (hasHealthInsurance) {
            tax -= 50;  // Reduce tax by $50
            if (tax < 0) {
                tax = 0;  // Tax cannot be negative
            }
        }

        return tax;
    }

    // Process multiple employees and print payroll summary
    public static void processPayroll(String[] employeeTypes, double[] hoursWorked, double[] hourlyRates, String[] employeeNames) {
        int count = Math.min(Math.min(employeeTypes.length, hoursWorked.length), Math.min(hourlyRates.length, employeeNames.length));

        if (count == 0) {
            System.out.println("No employee data to process.");
            return;
        }

        double totalPay = 0;
        double highestPay = Double.MIN_VALUE;
        String highestPaidEmployee = "";
        double lowestPay = Double.MAX_VALUE;
        String lowestPaidEmployee = "";
        int overtimeCount = 0;

        System.out.println("Payroll Summary:");
        System.out.printf("%-10s %-12s %-10s %-10s %-10s%n", "Name", "Type", "Hours", "Pay", "Overtime");

        for (int i = 0; i < count; i++) {
            double pay = calculateWeeklyPay(employeeTypes[i], hoursWorked[i], hourlyRates[i]);
            totalPay += pay;

            if (pay > highestPay) {
                highestPay = pay;
                highestPaidEmployee = employeeNames[i];
            }

            if (pay < lowestPay) {
                lowestPay = pay;
                lowestPaidEmployee = employeeNames[i];
            }

            boolean hasOvertime = employeeTypes[i].equalsIgnoreCase("FULL_TIME") && hoursWorked[i] > 40;
            if (hasOvertime) {
                overtimeCount++;
            }

            System.out.printf("%-10s %-12s %-10.2f $%-9.2f %-10s%n", employeeNames[i], employeeTypes[i], hoursWorked[i], pay, (hasOvertime ? "Yes" : "No"));
        }

        double averagePay = totalPay / count;

        System.out.println("\nStatistics:");
        System.out.println("Highest Paid Employee: " + highestPaidEmployee + " ($" + highestPay + ")");
        System.out.println("Lowest Paid Employee: " + lowestPaidEmployee + " ($" + lowestPay + ")");
        System.out.println("Average Pay: $" + String.format("%.2f", averagePay));
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Test individual pay calculations
        for (int i = 0; i < types.length; i++) {
            double pay = calculateWeeklyPay(types[i], hours[i], rates[i]);
            System.out.println(names[i] + "'s weekly pay: $" + String.format("%.2f", pay));
        }

        System.out.println();

        // Process entire payroll
        processPayroll(types, hours, rates, names);
    }
}
