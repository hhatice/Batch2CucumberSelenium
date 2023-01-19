package com.krafttech.utilities;


import java.sql.*;
import java.util.*;

public class JDBC_Utilities {

    static String url = "jdbc:sqlserver://94.73.150.3:1433;" +
            "DatabaseName=u0583688_vlk;" +
            "encrypt=true;" +
            "trustServerCertificate=true;";
    static String userName = "u0583688_vlk";
    static String password ="VolkanAntalya159*";
    static String query = "SELECT  * from u0583688_vlk.dbo.regions";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;

    public static void main(String[] args) throws SQLException {

        connectJdbc();
        runQuery();
//        getRowCount();
        getResultSetMetada();
//        getColumnCount();
//        getAllColumnNameAsList();

        System.out.println("getColumnDataAslist() = " + getColumnDataAslist(2));
        //System.out.println("getRowToMap(1).toString() = " + getRowToMap(1));

//        for (String str: getRowDataAsList(1)){
//            System.out.print(str+"\t");
//        }



        //closeJDBC();
    }

    public static void connectJdbc() {
        try {
            connection = DriverManager.getConnection(url, userName,password);
            System.out.println("Connection OK");
        }
        catch (SQLException e) {
            System.out.println("Connection failed");
            e.getMessage();
        }
    }

    public static ResultSet runQuery(){
        try {
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet= statement.executeQuery(query);
            System.out.println("resultSet get result from DB");
        }
        catch (SQLException e) {
            System.out.println("resultSet FAILED");
            e.getMessage();
        }
        return resultSet;
    }

    public static void closeJDBC(){
        try {
            if (resultSet!=null){
                resultSet.close();
                System.out.println("resultSet closed");
            }
            if (statement!=null){
                statement.close();
                System.out.println("statement closed");
            }
            if (connection!=null){
                connection.close();
                System.out.println("connection closed");
            }

        } catch (SQLException e) {
            System.out.println("closeJDBC FAILED");
            e.getMessage();
        }
    }

    /**
     * tablonun row sayısını elde etme */
    public static int getRowCount(){
        int row=0;

        try {
            resultSet.last();
            row= resultSet.getRow();
            System.out.println("Satır sayısı :"+row);
            resultSet.beforeFirst();
        }
        catch (SQLException e) {
            System.out.println("row count can not get");
            e.getMessage();
        }
        return row;
    }

    /**
     * kolon sayısının elde edilmesi*/

    public static int getColumnCount(){
        int columnCount=0;
        try {
            columnCount=resultSetMetaData.getColumnCount();
            //System.out.println("ColumnCount = " + columnCount);
        }
        catch (SQLException e) {
            System.out.println("metadata can not get");
            e.getMessage();
        }
        return columnCount;
    }

    public static ResultSetMetaData getResultSetMetada(){
        try {
            resultSetMetaData = resultSet.getMetaData();
            System.out.println("metadata is got");
        }
        catch (SQLException e) {
            System.out.println("Metadata cannot get");
        }
        return resultSetMetaData;
    }
    /***
     * tüm kolon isimlerini tek bir liste haline getirme
     */

    public static List<String> getAllColumnNameAsList()  {
        List<String> columnNameList = new ArrayList<>();

        try {
            for (int i = 1; i <= getColumnCount(); i++) {
                //System.out.println("kolon "+i+ "= " + resultSetMetaData.getColumnName(i));
                columnNameList.add(resultSetMetaData.getColumnName(i));
            }
        }
        catch (SQLException e) {
            System.out.println("allColumnNames can not add to list");
        }

        return columnNameList;
    }

    /**
     * parametre olarak  row numarası alan,
     * rowun tüm değerlerini listeye alan bir method
     * */

    public static List<String> getRowDataAsList(int rowNumber){
        List<String> rowDataList = new ArrayList<>();

        try {
            resultSet.absolute(rowNumber);
            for (int i = 1; i <= getColumnCount(); i++) {
                String cell = resultSet.getString(i);
                rowDataList.add(cell);
            }
            resultSet.beforeFirst();
        }
        catch (SQLException e) {
            System.out.println("getRowDataAsList unsuccessful");
        }

        return rowDataList;
    }

    /**
     * parametre olarak  row numarası ve kolon numarası alan,
     * o hücrenin değerini alan bir method
     * */

    public static String getCellData(int rowNumber, int columnIndex){

        String cellData="";

        try {
            resultSet.absolute(rowNumber);
            cellData=resultSet.getString(columnIndex);
            resultSet.beforeFirst();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cellData;
    }

    /**
     * parametre olarak  row numarası alan, kolon numarası
     * o hücrenin değerini alan bir method
     * */

    public static String getCellData(int rowNumber, String columnLabel){

        String cellData="";

        try {
            resultSet.absolute(rowNumber);
            cellData=resultSet.getString(columnLabel);
            resultSet.beforeFirst();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cellData;
    }

    /**
     * belirli bir row değerlerini "kolon numarası:değer" key:value şeklinde map e almak
     * */

    public static Map<String ,String> getRowToMap(int rowNumber) {
        Map<String,String> rowMap= new LinkedHashMap<>();
        for (int i = 1; i <= getColumnCount(); i++) {
            for (int j = 0; j < i; j++) {
                rowMap.put(getAllColumnNameAsList().get(j),getRowDataAsList(rowNumber).get(j) );
            }

        }
        return rowMap;
    }

    /**
     * Kolon Numarası ile o kolondaki tüm değerleri liste yapma
     * param : kolon numarası
     * */

    public static List<String> getColumnDataAslist (int columnNumber){
        List<String> columnData = new ArrayList<>();

        try {
            resultSet.beforeFirst();
            while (resultSet.next()){
                String data = resultSet.getString(columnNumber);
                columnData.add(data);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return columnData;
    }

}