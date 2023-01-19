package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Day2 {
    public static void main(String[] args) {
        String url="jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;trustServerCertificate=true;";
        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP (10) * from u0583688_Kraft2.product.brand";

        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Connection occured");
            resultSet.getString("brand_name");

            resultSet.close();
            statement.close();
            connection.close();

//            resultSet.next();
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
//            resultSet.next();
//            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
//            resultSet.previous();
/*            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.last();
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.absolute(5);
            System.out.println("absolute(5) = " + resultSet.getString(2));
            resultSet.beforeFirst();
            resultSet.afterLast();*/

            resultSet.beforeFirst();

            //Örnek: Tüm rowların ilk iki kolonunu bir döngüyle alt alta yazdıralım.
//            while (resultSet.next()){
//                System.out.print(resultSet.getString(1)+" | "+resultSet.getString(2));
//            }
//            System.out.println("while loop bitti");

            resultSet.next();
            System.out.println("row sıra numarası : " + resultSet.getRow());

            //resultset li iki kod kullanarak toplam row sayısını konsola yazdıralım
            resultSet.last();
            System.out.println("row sıra numarası : " + resultSet.getRow());

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
