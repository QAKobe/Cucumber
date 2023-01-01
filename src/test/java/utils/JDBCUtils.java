package utils;

import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

   private static Statement statement;
   private static Connection connection;
   private static ResultSet resultSet;
   private static ResultSetMetaData resultSetMetaData;

    public static void establishConnection(){


        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@codefish.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "techtorial",
                    "techtorialb13"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
         statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Map<String, Object>> executeQuery(String query){
            List<Map<String, Object>> dataResult = new ArrayList<>();

        try {
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();
            resultSet.beforeFirst();

            while (resultSet.next()) {
                Map<String, Object> record = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    record.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }
                dataResult.add(record);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return dataResult;
    }

    public static void closeConnection() {
        try{
            if (resultSet != null) {
            resultSet.close();
        }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Error occurred when connection is closing");
            e.printStackTrace();
        }
    }


}
