package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Metadata {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://94.73.150.3:1433;" +
                "DatabaseName=u0583688_vlk;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        String userName = "u0583688_vlk";
        String password ="VolkanAntalya159*";
        String query = "select TOP(10) * from u0583688_vlk.dbo.otomobil_fiyatlari of2";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("kolon sayısı : " + metaData.getColumnCount());
            System.out.println("kolon isimleri : "+metaData.getColumnName(1) + " | "+ metaData.getColumnName(2));

            int kolonSayisi = metaData.getColumnCount();
            for (int i = 1; i <= kolonSayisi ; i++) {
                System.out.println("Kolon : "+i+" => "  + metaData.getColumnName(i));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
