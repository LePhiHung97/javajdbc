package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class StudentService {

	static Scanner input = new Scanner(System.in);

	public static void addStudent() {
		Student student = new Student();
		inputInformation(student);
		StudentDao.addDao(student);
	}

	public static void inputInformation(Student student) {
		input.nextLine();
		System.out.println("Nhap vao hoten : ");
		student.setHoten(input.nextLine());

		System.out.println("Nhap vao nam sinh : ");
		student.setNamsinh(input.nextInt());

		input.nextLine();
		System.out.println("Nhap vao lop : ");
		student.setLop(input.nextLine());

		System.out.println("Nhap vao diem : ");
		student.setDiem(input.nextDouble());

	}

	public static void editStudent() {
		System.out.println("Nhap vao ma sinh vien : ");
		int masv = input.nextInt();
		Student student = StudentDao.findStudent(masv);
		if (student == null)
			System.out.println("Khong tim thay sinh vien !");
		else {
			inputInformation(student);
			StudentDao.updateStudent(student);
		}
	}

	public static void deleteStudent() {
		System.out.println("Nhap vao ma sinh vien : ");
		int masv = input.nextInt();
		Student student = StudentDao.findStudent(masv);
		if (student == null)
			System.out.println("Khong tim thay sinh vien !");
		else
			StudentDao.deleteStudent(student);
	}

	public static void findStudent() {
		System.out.println("Nhap vao ma sinh vien :");
		int masv = input.nextInt();
		Student student = StudentDao.findStudent(masv);
		if (student == null)
			System.out.println("Khong tim thay sinh vien");
		else
			System.out.println(student);
	}

	public static void getListStudent() {
		List<Student> listStudent = StudentDao.getListStudentDao();
		if (listStudent == null)
			System.out.println("Khong co sinh vien nao trong danh sach !");
		else
			for (Student student : listStudent)
				System.out.println(student);
	}

	public static void sortStudent() {
		List<Student> listStudent = StudentDao.getListStudentDao();
		if (listStudent != null)
			Collections.sort(listStudent, new Comparator<Student>() {

				@Override
				public int compare(Student s1, Student s2) {
					if (s1.getDiem() == s2.getDiem())
						return 0;
					else if (s1.getDiem() < s2.getDiem())
						return 1;
					else
						return -1;
				}
			});

		for (Student student : listStudent)
			System.out.println(student);

	}
}
