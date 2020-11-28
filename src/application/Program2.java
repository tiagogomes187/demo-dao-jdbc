package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department newDepartment = new Department(1, null);
		// **********************************************************\\

		System.out.println("\n=== TEST 1: department insert =====");
		newDepartment = new Department(null, "Microservices");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());

		System.out.println("=== TEST 2: department findById =====");
		newDepartment = departmentDao.findById(6);
		System.out.println(newDepartment);

		System.out.println("\n=== TEST 3: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: department update =====");
		newDepartment = departmentDao.findById(1);
		newDepartment.setName("Developers");
		departmentDao.update(newDepartment);
		System.out.println("Upadate completed");

		System.out.println("\n=== TEST 5: department delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();

	}

}
