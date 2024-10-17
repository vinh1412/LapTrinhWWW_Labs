package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CandidateRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public CandidateRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertCandidate() throws SQLException {
        String sql = "INSERT INTO candidate (first_name, middle_name, last_name, email, phone, dob) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Doe");
        preparedStatement.setString(3, "Smith");
        preparedStatement.setString(4, "Vinh@gamil.com");
        preparedStatement.setString(5, "0123456789");
        preparedStatement.setString(6, "1990-01-01");
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println("A new candidate was inserted successfully!");
        }else {
            System.out.println("A new candidate was not inserted!");
        }

    }
}
