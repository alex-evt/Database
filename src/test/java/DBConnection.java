import java.sql.*;

public class DBConnection {

    private Connection connect = null;
    private Statement statement = null;

    public void connect() {
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/aqa17?"
                            + "user=root&password=pas2wordx&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public ResultSet executeQuery(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            return statement
                    .executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int executeInsert(String query) {
        try {
            return statement
                    .executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int executeDelete(String tableName, String condition) {
        try {
            return statement
                    .executeUpdate(String.format("DELETE FROM %s WHERE %s",tableName, condition));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void writeResultSetForCities(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
        }
    }
    public static void writeResultSetForStudents(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String cityId = resultSet.getString("cityId");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("CityID: " + cityId);
        }
    }

    public static void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            try {
                String id = resultSet.getString("id");
                System.out.println("ID: " + id);
            } catch (Exception notFound1) {
                notFound1.fillInStackTrace();
            }
            try {
                String name = resultSet.getString("name");
                System.out.println("NAME: " + name);
            } catch (Exception notFound2) {
                System.out.println(notFound2.getMessage());
            }
            try {
                String cityId = resultSet.getString("cityId");
                System.out.println("CityID: " + cityId);
            } catch (Exception notFound3) {
                System.out.println(notFound3.getMessage());
            }
        }
    }

    public static void writeResultInt(int result) throws SQLException{
        System.out.println("You have made changes to the database. Rows affected: " + result);
    }

    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }

}


