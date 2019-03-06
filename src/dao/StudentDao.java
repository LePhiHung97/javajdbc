package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import util.JDBCConnection;

public class StudentDao {
	public static void addDao(Student student) {
		Connection conn;
		try {
			conn = JDBCConnection.getConnection();
			String sql = "INSERT INTO Student (hoten, namsinh, lop, diem) VALUES (?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, student.getHoten());
			statement.setInt(2, student.getNamsinh());
			statement.setString(3, student.getLop());
			statement.setDouble(4, student.getDiem());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Them thanh Scong !");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Student> getListStudentDao() {
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		try {
			conn = JDBCConnection.getConnection();
			if (conn != null) {
				String sql = "select * from student";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Student student = new Student();
					student.setMasv(rs.getByte(1));
					student.setHoten(rs.getString(2));
					student.setNamsinh(rs.getInt(3));
					student.setLop(rs.getString(4));
					student.setDiem(rs.getDouble(5));

					list.add(student);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public static Student findStudent(int masv) {
		Connection conn = null;
		Student student = null;
		try {
			conn = JDBCConnection.getConnection();
			if (conn != null) {
				String sql = "select * from student where masv = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, masv);
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					student = new Student();
					student.setMasv(rs.getByte(1));
					student.setHoten(rs.getString(2));
					student.setNamsinh(rs.getInt(3));
					student.setLop(rs.getString(4));
					student.setDiem(rs.getDouble(5));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public static void deleteStudent(Student student) {
		Connection conn = null;
		try {
			conn = JDBCConnection.getConnection();
			String sql = "DELETE FROM Student WHERE masv = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, student.getMasv());

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0)
				System.out.println("Xoa thanh cong !");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateStudent(Student student) {
		Connection conn = null;
		try {
			conn = JDBCConnection.getConnection();
			String sql = "UPDATE Student SET hoten=?, namsinh=?, lop=? ,diem = ? WHERE masv=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, student.getHoten());
			statement.setInt(2, student.getNamsinh());
			statement.setString(3, student.getLop());
			statement.setDouble(4, student.getDiem());
			statement.setInt(5, student.getMasv());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Cap nhat thanh cong !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
