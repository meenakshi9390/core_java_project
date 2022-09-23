package com.training;

import java.time.LocalDate;
import java.util.Scanner;

import com.training.entity.PersonalDetails;
import com.training.exceptions.ElementNotFoundException;
import com.training.services.ManagementService;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ManagementService service = new ManagementService();
		String firstName;
		String lastName;
		String address;
		String email;
		long phoneNumber;
		String dob;
		String wedDate;
		System.out.println("1:ADD Employee details");
		System.out.println("2:Employees with FirstName");
		System.out.println("3: Employees with FirstName and PhoneNumber");
		System.out.println("4:Update Employee details of PhoneNumber and Email ");
		System.out.println("5:Delete Details of Employee in the company");
		System.out.println("6: Employees by FirstName and Email with common Date of Birth" );
		System.out.println("7:Employees by FirstName and PhoneNumber with common  Wedding Date");
		while(true) {
		System.out.println("Enter Query Number:");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			System.out.println("First Name:");
			firstName = scanner.next();
			System.out.println("Last Name:");
			lastName = scanner.next();
			System.out.println("Address:");
			address = scanner.next();
			System.out.println("Email:");
			email = scanner.next();
			System.out.println("Phone Number:");
			phoneNumber = scanner.nextLong();
			System.out.println("Date of Birth(YYYY-MM-DD):");
			dob = scanner.next();
			System.out.println("Wedding Date:");
			wedDate = scanner.next();
			PersonalDetails obj = new PersonalDetails(firstName, lastName, address, email, phoneNumber,
					LocalDate.parse(dob), LocalDate.parse(wedDate));
			System.out.println(service.add(obj));

			break;
		case 2:
			System.out.println("First Name:");
			firstName = scanner.next();
			try {
				service.findByFirstName(firstName);
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				service.findByFnamePhone();
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("First Name:");
			firstName = scanner.next();
			System.out.println("Email:");
			email = scanner.next();
			System.out.println("Phone Number:");
			phoneNumber = scanner.nextLong();
			try {
				service.update(firstName, email, phoneNumber);
			} catch (ElementNotFoundException e1) {
				e1.printStackTrace();
			}
			break;
		case 5:
			System.out.println("First Name:");
			firstName = scanner.next();
			try {
				service.delete(firstName);
			} catch (ElementNotFoundException e1) {
				e1.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Date of Birth(YYYY-MM-DD):");
			dob = scanner.next();
			try {
				service.findByDob(LocalDate.parse(dob));
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("Wedding Date(YYYY-MM-DD):");
			wedDate = scanner.next();
			try {
			 service.findByWed(LocalDate.parse(wedDate));
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
}