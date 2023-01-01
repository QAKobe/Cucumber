package utils;

import io.cucumber.java.it.Ma;
import oracle.jdbc.OracleConnectionWrapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCPractice {

    /*
    Connection -> it helps us to provide DB credentials and connect to DB
    Statement -> we define our conditions/query to get the result from the DB
    ResultSet -> we store data from/response from the DB to the resultSet object in Java
     */
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@codefish.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                "techtorial",
                "techtorialb13"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.next(); // it will go the next row. If there is next row it will return true and go to the next row
        //if there is no next row, it will return false.
        System.out.println(resultSet.getString("first_name"));
        //System.out.println(resultSet);
        resultSet.next();
        System.out.println(resultSet.getString("email"));

        resultSet.first();

        System.out.println(resultSet.getString("last_name"));

        resultSet.beforeFirst();

//        System.out.println(resultSet.getString(2));

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, Object>> employees = new ArrayList<>();
        resultSet.beforeFirst();
        while (resultSet.next()){

            Map<String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i < resultSetMetaData.getColumnCount() ; i++) {
                employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            employees.add(employee);
        }

        System.out.println(employees.size());
        System.out.println(employees.get(2).get("EMAIL"));







    }
}
