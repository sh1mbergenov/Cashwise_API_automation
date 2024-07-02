import org.testng.annotations.Test;
import utilities.DBUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class PrintSQLResults {
    @Test
    public void printResults() throws SQLException {
        Connection connection = DBUtilities.getDBConnection();
        String sqlQuery = "select distinct id,price,title from products where price between 2000 and 5000";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String[] array = resultSet.getString("title").split(" ");
            if(array.length == 3){
                System.out.println(resultSet.getString("id") +" \t " + resultSet.getString("price")
                        + " \t " + resultSet.getString("title"));
            }

        }
    }
    @Test
    public void printResultsFromCategories() throws SQLException {
        Connection connection = DBUtilities.getDBConnection();
        String sqlQuery = "select distinct title,id,description,cast(created as Date) from categories\n" +
                " where title is not null and description is not null\n" +
                "order by title;";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String[] array = resultSet.getString("title").split(" ");
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("QA Engineer")) {
                    System.out.println(resultSet.getString("id") + array[i].toUpperCase() + "\t"
                            + "\t" + resultSet.getString("description") + "\t" + resultSet.getString("created"));
                } else {
                    System.out.println(resultSet.getString("id") + array[i].toLowerCase() + "\t"
                            + "\t" + resultSet.getString("description") + "\t" + resultSet.getString("created"));
                }
            }
        }
    }
        @Test
        public void printTitlesFromCategories() throws SQLException {
            Connection connection = DBUtilities.getDBConnection();
            String sqlQuery = "select title from categories where title is not null";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String[] title1 = resultSet.getString("title").split(" ");
                String[] title2 = resultSet.getString("title").split(" ");
                for (int i = 0; i < title1.length; i++) {
                    for (int j = i+1; j < title2.length ; j++) {
                        if(!title1[i].equals(title2[i])){
                            System.out.println(resultSet.getString("title"));
                        }
                    }
                }
            }
    }
}
