package org.jsp.springempapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.springempapp.EmployeeConfig;
import org.jsp.springempapp.dao.EmployeeDao;
import org.jsp.springempapp.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Verify Employee by Phone and password");
		System.out.println("5.Verify Employee by email and password");
		System.out.println("6.Verify Employee by Id and password");
		System.out.println("7.Find Employees by salary");
		System.out.println("8.Find Employees by Designation");
		System.out.println("9.Find Employees by name");
		System.out.println("10.Find Employees between a salary range");
		switch (sc.nextInt()) {
		case 1: {
			Employee employee = new Employee();
			System.out.println("Enter employee name: ");
			employee.setName(sc.next());
			System.out.println("Enter employee phone no.:");
			employee.setPhone(sc.nextLong());
			System.out.println("Enter employee email: ");
			employee.setEmail(sc.next());
			System.out.println("Enter employee designation:");
			employee.setDesg(sc.next());
			System.out.println("Enter employee salary:");
			employee.setSalary(sc.nextDouble());
			System.out.println("Enter employee password:");
			employee.setPassword(sc.next());
			employee = employeeDao.saveEmployee(employee);
			System.out.println("Employee saved with Id:" + employee.getId());
			break;
		}
		case 2: {
			Employee employee = new Employee();
			System.out.println("Enter employee id:");
			employee.setId(sc.nextInt());
			System.out.println("Enter employee name: ");
			employee.setName(sc.next());
			System.out.println("Enter employee phone no.:");
			employee.setPhone(sc.nextLong());
			System.out.println("Enter employee email: ");
			employee.setEmail(sc.next());
			System.out.println("Enter employee designation:");
			employee.setDesg(sc.next());
			System.out.println("Enter employee salary:");
			employee.setSalary(sc.nextDouble());
			System.out.println("Enter employee password:");
			employee.setPassword(sc.next());
			employee = employeeDao.updateEmployee(employee);
			if (employee != null)
				System.out.println("Employee with Id:" + employee.getId() + " updated");
			else
				System.err.println("Cannot Update Employee as Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the Employee Id to find Employee");
			int eid = sc.nextInt();
			Employee employee = employeeDao.findEmployeeById(eid);
			if (employee != null) {
				System.out.println("Employee found");
				System.out.println(employee);
			} else {
				System.err.println("Cannot find Employee as Invalid Employee Id");
			}
			break;
		}
		case 4: {
			System.out.println("Enter the Employee Phone and password to verify");
			long phone = sc.nextLong();
			String password = sc.next();
			Employee employee = employeeDao.verifyEmployee(phone, password);
			if (employee != null) {
				System.out.println("Employee verification sucessfull");
				System.out.println(employee);
			} else {
				System.err.println("Invalid Phone Number or Password");
			}
			break;
		}
		case 5: {
			System.out.println("Enter the Employee Email id and password to verify");
			String email = sc.next();
			String password = sc.next();
			Employee employee = employeeDao.verifyEmployee(email, password);
			if (employee != null) {
				System.out.println("Employee verification sucessfull");
				System.out.println(employee);
			} else {
				System.err.println("Invalid email Id or Password");
			}
			break;
		}
		case 6: {
			System.out.println("Enter the Employee Id and password to verify");
			int id = sc.nextInt();
			String password = sc.next();
			Employee employee = employeeDao.verifyEmployee(id, password);
			if (employee != null) {
				System.out.println("Employee verification sucessfull");
				System.out.println(employee);
			} else {
				System.err.println("Invalid Employee Id or Password");
			}
			break;
		}
		case 7: {
			System.out.println("Enter the salary to find Employees");
			double salary = sc.nextDouble();
			List<Employee> employees = employeeDao.findBySalary(salary);
			if (employees.isEmpty()) {
				System.err.println("No Employee found with entered salary");
			} else {
				System.out.println("List of Employees with entered salary");
				for (Employee employee : employees)
					System.out.println(employee);
			}
			break;
		}
		case 8: {
			System.out.println("Enter the Designation to find Employees");
			String desg = sc.next();
			List<Employee> employees = employeeDao.findByDesg(desg);
			if (employees.isEmpty()) {
				System.err.println("No Employee found with entered designation");
			} else {
				System.out.println("List of Employees with entered designation");
				for (Employee employee : employees)
					System.out.println(employee);
			}
			break;
		}
		case 9: {
			System.out.println("Enter the name to find Employees");
			String name = sc.next();
			List<Employee> employees = employeeDao.findByName(name);
			if (employees.isEmpty()) {
				System.err.println("No Employee found with entered name");
			} else {
				System.out.println("List of Employees with entered name");
				for (Employee employee : employees)
					System.out.println(employee);
			}
			break;
		}
		case 10: {
			System.out.println("Enter the minimum and maximum salary to find Employees");
			double min_salary = sc.nextDouble();
			double max_salary = sc.nextDouble();
			List<Employee> employees = employeeDao.findBySalary(min_salary, max_salary);
			if (employees.isEmpty()) {
				System.err.println("No Employee found in entered salary range");
			} else {
				System.out.println("List of Employees in entered salary range");
				for (Employee employee : employees)
					System.out.println(employee);
			}
			break;
		}
		default: {
			System.err.println("Invalid Choice");
			sc.close();
			((AnnotationConfigApplicationContext) context).close();
		}
		}

	}
}
