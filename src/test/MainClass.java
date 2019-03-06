package test;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Student;
import service.StudentService;
import util.ScreenUtil;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * Connection conn = JDBCConnection.getConnection(); if(conn != null)
		 * System.out.println("connected");
		 */

		int num = 0;
		do {
			Scanner input = new Scanner(System.in);
			ScreenUtil.printMenu();
			num = input.nextInt();

			switch (num) {
			case 1: {
				StudentService.addStudent();
				break;
			}
			case 2: {
				StudentService.editStudent();
				break;
			}
			case 3: {
				StudentService.deleteStudent();
				break;
			}
			case 4: {
				StudentService.findStudent();
				break;

			}
			case 5: {
				StudentService.getListStudent();
				break;
			}

			case 6: {
				StudentService.sortStudent();
				break;
			}
			case 7:
				System.exit(0);
				break;
			}

		} while (num != 7);
	}
}
