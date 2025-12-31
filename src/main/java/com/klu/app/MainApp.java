package com.klu.app;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.klu.model.Deptatment;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;

public class MainApp {

	static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== EMPLOYEE MENU =====");
			System.out.println("1. Insert Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee Salary");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Enter Choice: ");

			choice = sc.nextInt();
			sc.nextLine(); // clear buffer

			switch (choice) {
			case 1:
				insertEmployee(sc);
				break;
			case 2:
				viewEmployee(sc);
				break;
			case 3:
				updateEmployee(sc);
				break;
			case 4:
				deleteEmployee(sc);
				break;
			case 5:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 5);

		factory.close();
		sc.close();
	}

	// INSERT
	private static void insertEmployee(Scanner sc) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			System.out.print("Enter Dept Name: ");
			String deptName = sc.nextLine();

			Deptatment dept = session.createQuery("from Deptatment where deptName=:d", Deptatment.class)
					.setParameter("d", deptName).uniqueResult();

			if (dept == null) {
				dept = new Deptatment();
				dept.setDeptName(deptName);
				session.persist(dept);
			}

			System.out.print("Enter Emp Name: ");
			String empName = sc.nextLine();

			System.out.print("Enter Salary: ");
			double salary = sc.nextDouble();
			sc.nextLine();

			Employee emp = new Employee();
			emp.setEmpName(empName);
			emp.setSalary(salary);
			emp.setDepatment(dept);

			session.persist(emp);
			tx.commit();

			System.out.println("Employee inserted successfully");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		session.close();
	}

	// READ
	private static void viewEmployee(Scanner sc) {

		Session session = factory.openSession();

		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {
			System.out.println("Name   : " + emp.getEmpName());
			System.out.println("Salary : " + emp.getSalary());
			System.out.println("Dept   : " + emp.getDepatment().getDeptName());
		} else {
			System.out.println("Employee not found");
		}

		session.close();
	}

	// UPDATE
	private static void updateEmployee(Scanner sc) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {
			System.out.print("Enter New Salary: ");
			emp.setSalary(sc.nextDouble());
			tx.commit();
			System.out.println("Salary updated successfully");
		} else {
			System.out.println("Employee not found");
			tx.rollback();
		}

		session.close();
	}

	// DELETE
	private static void deleteEmployee(Scanner sc) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {
			session.remove(emp);
			tx.commit();
			System.out.println("Employee deleted successfully");
		} else {
			System.out.println("Employee not found");
			tx.rollback();
		}

		session.close();
	}
}
