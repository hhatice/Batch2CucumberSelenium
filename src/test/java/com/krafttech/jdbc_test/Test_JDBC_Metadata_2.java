package com.krafttech.jdbc_test;

import java.sql.*;

public class Test_JDBC_Metadata_2 {
    public static void main(String[] args) {

        String url="jdbc:sqlserver://94.73.170.25:1433;DatabaseName=u0583688_Kraft2;" +
                "encrypt=true;trustServerCertificate=true;";
        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP (10) * from u0583688_Kraft2.product.brand";

        try (
                Connection connection= DriverManager.getConnection(url,userName,password);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet  resultSet = statement.executeQuery(query);
        )
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());

            //cloumnCountu kullanarak ilk satırın değerlerini ekrana yazdıralım
//           int kolonSayisi = metaData.getColumnCount();
//           resultSet.next();
//            for (int i = 1; i <= kolonSayisi ; i++) {
//                System.out.print( resultSet.getString(i) +"\t");
//            }

            //columnCountları kullanarak bütün rowları alt alta yazdıralım
//            int kolonSayısı = metaData.getColumnCount();
//            while (resultSet.next()){
//
//                for (int i = 1; i <= kolonSayısı ; i++) {
//                    System.out.print(resultSet.getString(i) + "\t");
//                }
//                System.out.println("");
//
//            }

            //Tablomuzun kolon isimleriyle beraber yazdıralım
            int kolonSayısı = metaData.getColumnCount();

            for (int i = 1; i <= kolonSayısı ; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println("");
            while (resultSet.next()){

                for (int i = 1; i <= kolonSayısı ; i++) {
                    System.out.print(resultSet.getString(i) + "\t"+ "\t"+ "\t");
                }
                System.out.println("");

            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
