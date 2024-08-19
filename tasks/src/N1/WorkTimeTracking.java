package N1;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkTimeTracking {
	private String customerName;
	private String projectName;
	private double workHours;

	private ArrayList<WorkTimeTracking> workTimeList = new ArrayList<>();

	public ArrayList<WorkTimeTracking> getWorkTimeList() {
		return workTimeList;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WorkTimeTracking tracking = new WorkTimeTracking("", "", 0);

		while (true) {
			System.out.println("1. Add work time");
			System.out.println("2. Display all work times");
			System.out.println("3. Display work time for a customer");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			if (choice == 1) {
				System.out.print("Customer name: ");
				String customer = scanner.next();
				System.out.print("Project name: ");
				String project = scanner.next();
				System.out.print("Work hours: ");
				double hours = scanner.nextDouble();
				tracking.addWorkTime(customer, project, hours);
			} else if (choice == 2) {
				tracking.logWorkTime();
			} else if (choice == 3) {
				System.out.print("Customer name: ");
				String customer = scanner.next();
				tracking.displayWorkTimeForCustomer(customer);
			} else if (choice == 4) {
				System.out.println("Program terminated.");
				break;
			} else {
				System.out.println("Invalid selection, please try again.");
			}
		}
		scanner.close();
	}

	WorkTimeTracking(String customer, String project, double hours) {
		this.customerName = customer;
		this.projectName = project;
		this.workHours = hours;
	}

	void addWorkTime(String customer, String project, double hours) {
		WorkTimeTracking newWorkTime = new WorkTimeTracking(customer, project, hours);
		workTimeList.add(newWorkTime);
		System.out.println("Work time added.");
	}

	void logWorkTime() {
		for (WorkTimeTracking time : workTimeList) {
			System.out.println("Customer: " + time.customerName + ", Project: " + time.projectName + ", Hours: " + time.workHours);
		}
	}

	void displayWorkTimeForCustomer(String customer) {
		double totalHours = 0;
		for (WorkTimeTracking time : workTimeList) {
			if (time.customerName.equals(customer)) {
				totalHours += time.workHours;
			}
		}
		System.out.println("Total hours for " + customer + ": " + totalHours);
	}
}
