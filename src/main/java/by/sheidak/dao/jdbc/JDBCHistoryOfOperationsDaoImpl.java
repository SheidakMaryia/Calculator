package by.sheidak.dao.jdbc;

import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.utils.MySQLConnections;
import by.sheidak.entity.Operation;
import by.sheidak.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCHistoryOfOperationsDaoImpl implements HistoryOfOperationsDao {
    @Override
    public void saveOperations(Operation operation) {
        try(Connection connection = MySQLConnections.getConnection()) {
            String sql = "INSERT INTO operation (num1, num2, typeOfOperation, result, user_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setString(3,operation.getTypeOfOperation());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.setInt(5, operation.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Operation> showHistory() {
        return null;
    }

    @Override
    public List<Operation> showHistoryByLogin(User user) {
        List<Operation> history = new ArrayList<>();

        try(Connection connection = MySQLConnections.getConnection()) {
            String sql = "SELECT * FROM operation LEFT JOIN users ON operation.user_id = users.id WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                history.add(new Operation(
                        resultSet.getInt("id"),
                        resultSet.getDouble("num1"),
                        resultSet.getDouble("num2"),
                        resultSet.getString("typeOfOperation"),
                        resultSet.getDouble("result"),
                        new User(
                                //resultSet.getInt("id"),
                                resultSet.getString("name")
                                //resultSet.getString("login"),
                                //resultSet.getString("password")
                        )
                        ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return history;
    }
}
