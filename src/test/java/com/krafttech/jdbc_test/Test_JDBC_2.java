package com.krafttech.jdbc_test;

import java.sql.*;
import java.util.List;

public class Test_JDBC_2 {
    public static void main(String[] args) {
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
            resultSet.next();
//            System.out.println("resultSet.absolute(5) = " + resultSet.absolute(3));

            System.out.print(resultSet.getRow()+" | "+ resultSet.getString(2));
            System.out.println(" | " + resultSet.getString("marka"));
            resultSet.next();
            System.out.print(resultSet.getRow()+" | "+ resultSet.getString(2));
            System.out.println(" | " + resultSet.getString("model"));
            resultSet.next();
            String model = resultSet.getString("model");
            System.out.println("model = " + model);
            String donanim = resultSet.getString("donanım");
            System.out.println("donanım = " + donanim);

            //Array modelList = resultSet.getArray(2);

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
