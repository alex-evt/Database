import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {

    private DBConnection dbConnection = new DBConnection();


    @Test
    public void selectFromCitiesTest() {
        dbConnection.connect();
        try {
            ResultSet resultSet = dbConnection.selectFrom("cities");
            DBConnection.writeResultSetForCities(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void selectFromStudentsTest() {
        dbConnection.connect();
        try {
            ResultSet resultSet = dbConnection.selectFrom("students");
            DBConnection.writeResultSetForStudents(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void resultsTest() {
        dbConnection.connect();
        try {
            ResultSet resultSet = dbConnection.selectFrom("cities");
            DBConnection.writeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void updateTest() {
        dbConnection.connect();
        String query = "UPDATE students SET name = 'Masha' WHERE id = '3'";
        try {
            int result = dbConnection.executeUpdate(query);
            DBConnection.writeResultInt(result);
//            ResultSet resultSet = dbConnection.selectFrom("students");
//            DBConnection.writeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void insertTest() {
        dbConnection.connect();
        String query = "INSERT INTO students (name, cityId) VALUES ('Jake',2)";
        try {
            int result = dbConnection.executeInsert(query);
            DBConnection.writeResultInt(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void deleteTest() {
        dbConnection.connect();
        String tableName = "students";
        String condition = "id=7";
        try {
            int result = dbConnection.executeDelete(tableName, condition);
            DBConnection.writeResultInt(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }
}
