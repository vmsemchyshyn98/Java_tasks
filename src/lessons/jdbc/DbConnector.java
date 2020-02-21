package lessons.jdbc;

import java.sql.*;
import java.util.Objects;


public class DbConnector {

    private static Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/learn_sql?user=root&password=123456&serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        if (Objects.isNull(connection)) {
            try {
                connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void simpleQuery() throws SQLException {
        String query = "SELECT * FROM Man";

        Statement statement = getConnection().createStatement();

        try (statement) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.println(firstName + "\t" + lastName);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        simpleQuery();

    }
}
