package assignment;

import java.sql.*;
import java.util.ArrayList;

public class StaffDAO {

    public void addStaff(Staff staff) {
        String sql = "INSERT INTO staff(id, name, experience, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, staff.id);
            ps.setString(2, staff.name);
            ps.setInt(3, staff.experience);
            ps.setString(4, staff.getRole());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getAllStaff() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("role"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void deleteStaff(int id) {
        String sql = "DELETE FROM staff WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateExperience(int id, int newExperience) {
        String sql = "UPDATE staff SET experience = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newExperience);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Experience updated successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchByName(String name) {
        String sql = "SELECT * FROM staff WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("role")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
