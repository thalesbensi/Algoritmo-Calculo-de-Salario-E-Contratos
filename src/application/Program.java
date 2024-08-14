package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Worker worker;

        System.out.print("Enter departament's workerName:  ");
        String departamentName = scan.nextLine();
        System.out.println("Enter worker data:  ");
        System.out.print("Name:  ");
        String workerName = scan.nextLine();
        System.out.print("Level:  ");
        String workerLevel = scan.nextLine();
        System.out.print("Base Salary:  ");
        Double baseSalary = scan.nextDouble();
        worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary , new Departament(departamentName));
        System.out.print("How many contracts this worker have?  ");
        int n = scan.nextInt();

        for (int i = 1; i < n; i++ ){
            System.out.println("Enter contract #" + i + "data: ");
            System.out.print("Date (DD/MM/YY):  ");
            Date contractDate = sdf.parse(scan.next());
            System.out.print("Value Por hour:  ");
            double valuePerHour = scan.nextDouble();
            System.out.print("Duration:  ");
            int duration = scan.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY:  ");
        String monthAndYear = scan.next();
        int month =Integer.parseInt(monthAndYear.substring(0, 2)) ;
        int year =Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament" + worker.getDepartament().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        scan.close();
    }
}
