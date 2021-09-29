package by.sheidak.dao.jdbc;

import by.sheidak.dao.UserDao;
import by.sheidak.utils.MySQLConnections;
import by.sheidak.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUUsersDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        try(Connection connection = MySQLConnections.getConnection()){
            String sql = "INSERT INTO users (name, login, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = MySQLConnections.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                users.add(new User(
                       resultSet.getString("name"),
                       resultSet.getString("login"),
                       resultSet.getString("password")
                ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserByLogin(User user) {
        User userByLogin = new User();
        try(Connection connection = MySQLConnections.getConnection()) {
            String sql = "SELECT id, name, login, password FROM users WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                userByLogin = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userByLogin;
    }
}
