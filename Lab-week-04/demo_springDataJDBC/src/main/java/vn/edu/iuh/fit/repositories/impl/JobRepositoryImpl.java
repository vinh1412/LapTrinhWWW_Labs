/*
 * @ {#} JobRepositoryImpl.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.JobRepository;
import vn.edu.iuh.fit.repositories.mapper.JobMapper;

import javax.sql.DataSource;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@Repository
public class JobRepositoryImpl implements JobRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JobRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insert(Job job) {
        String sql = "INSERT INTO job (description) VALUES (?)";
        return jdbcTemplate.update(sql, job.getDescription()) > 0;
    }

    @Override
    public boolean update(Job job) {
        String sql = "UPDATE job SET description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, job.getDescription(), job.getId()) > 0;
    }

    @Override
    public boolean delete(Job job) {
        String sql = "DELETE FROM job WHERE id = ?";
        return jdbcTemplate.update(sql, job.getId()) > 0;
    }

    @Override
    public Job findById(int id) {
        String sql = "SELECT * FROM job WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new JobMapper(), id);
    }

    @Override
    public List<Job> findAll() {
        String sql = "SELECT * FROM job";
        return jdbcTemplate.query(sql, new JobMapper());
    }
}
