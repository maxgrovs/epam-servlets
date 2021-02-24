package servlet.dao;

import servlet.entity.Film;
import servlet.entity.User;
import servlet.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private UserDao() {
    }

    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public static final String FIND_FILMS = "SELECT * FROM film_storage.user WHERE id = ?";
    public static final String FIND_ALL_FILMS = "SELECT * FROM film_storage.user";
    public static final String SAVE = "INSERT INTO film_storage.user (name, password) VALUES (?, ?)";

    public User save(User user){

        try (Connection connection = ConnectionManager.get()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()){
                user.setId(generatedKeys.getLong(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public Optional<Film> findOne(Long id){

        Optional<Film> film = null;

        try (Connection connection = ConnectionManager.get()) {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILMS);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                 film = Optional.ofNullable(Film.builder()

                         .id(resultSet.getLong("id"))
                         .name(resultSet.getString("name"))
                         .year(resultSet.getInt("year"))
                         .build());


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return film;

    }


    public List<Film> findAll() {

        Optional<Film> film = null;
        List<Film> films = new ArrayList<>();

        try (Connection connection = ConnectionManager.get()) {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(FIND_ALL_FILMS);

            while (resultSet.next()) {

                film = Optional.ofNullable(Film.builder()

                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .year(resultSet.getInt("year"))
                        .build());

                films.add(film.get());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return films;

    }


}
