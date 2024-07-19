package com.example.dao;

import com.example.model.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {
    private static final String URL = "jdbc:mysql://localhost:3306/StudyMaterialsDB";
    private static final String USER = "root";
    private static final String PASSWORD = "JaY@0710";

    // Establishing the connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Retrieve all materials from the database
    public List<Material> getAllMaterials() {
        List<Material> materials = new ArrayList<>();
        String query = "SELECT * FROM materials";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Material material = new Material();
                material.setId(resultSet.getInt("id"));
                material.setTitle(resultSet.getString("title"));
                material.setDescription(resultSet.getString("description"));
                material.setFilename(resultSet.getString("filename"));
                material.setUploadDate(resultSet.getTimestamp("upload_date"));
                material.setUserId(resultSet.getInt("user_id"));
                materials.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materials;
    }

    // Save a material to the database
    public boolean saveMaterial(Material material) {
        String query = "INSERT INTO materials (title, description, filename, user_id) VALUES (?, ?, ?, ?)";
        boolean isSuccess = false;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, material.getTitle());
            preparedStatement.setString(2, material.getDescription());
            preparedStatement.setString(3, material.getFilename());
            preparedStatement.setInt(4, material.getUserId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
