package com.example.student_management_system;

import java.sql.*;

public class StudentDAO implements StudentDaoInterface {
    Connection conn;

    public StudentDAO() {
        conn = DatabaseConnection.createConnection();
    }

    @Override
    public boolean insertStudent(Student student) {
        String query = "INSERT INTO student_details (name, collagename, city, percentage) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getCollageName());
            ps.setString(3, student.getCity());
            ps.setDouble(4, student.getPercentage());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void showAllStudents() {
        String query = "SELECT * FROM student_details";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("rollnum") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("collagename") + " | " +
                                rs.getString("city") + " | " +
                                rs.getDouble("percentage")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean showStudentById(int roll) {
        String query = "SELECT * FROM student_details WHERE rollnum = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roll);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Student Found: " +
                        rs.getInt("rollnum") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("collagename") + " | " +
                        rs.getString("city") + " | " +
                        rs.getDouble("percentage"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int roll, String value, int fieldOption, Student s) {
        String column;
        switch (fieldOption) {
            case 1 -> column = "name";
            case 2 -> column = "collagename";
            case 3 -> column = "city";
            case 4 -> column = "percentage";
            default -> { return false; }
        }

        String query = "UPDATE student_details SET " + column + " = ? WHERE rollnum = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            if (fieldOption == 4) {
                ps.setDouble(1, Double.parseDouble(value));
            } else {
                ps.setString(1, value);
            }
            ps.setInt(2, roll);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int roll) {
        String query = "DELETE FROM student_details WHERE rollnum = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roll);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
