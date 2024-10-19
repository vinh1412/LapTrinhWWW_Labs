/*
 * @ {#} CandidateRepository.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.mapper.CandidateMapper;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import javax.sql.DataSource;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
@Repository
public class CandidateRepositoryImpl implements CandidateRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insert(Candidate candidate) {
        String sql = "INSERT INTO candidate (first_name, middle_name, last_name, dob, email, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getEmail(), candidate.getPhone(), candidate.getAddress()) > 0;
    }

    @Override
    public boolean update(Candidate candidate) {
        String sql = "UPDATE candidate SET first_name = ?, middle_name = ?, last_name = ?, dob = ?, email = ?, phone = ? , address = ? WHERE id = ?";
        return jdbcTemplate.update(sql, candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getEmail(), candidate.getPhone(), candidate.getAddress(), candidate.getId()) > 0;
    }

    @Override
    public boolean delete(Candidate candidate) {
        String sql = "DELETE FROM candidate WHERE id = ?";
        return jdbcTemplate.update(sql, candidate.getId()) > 0;
    }

    @Override
    public Candidate findById(int id) {
        String sql = "SELECT * FROM candidate WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CandidateMapper(), id);
    }

    @Override
    public List<Candidate> findAll() {
        String sql = "SELECT * FROM candidate";
        return jdbcTemplate.query(sql, new CandidateMapper());
    }

    @Override
    public List<Candidate> findBySkillId(int id) {
        String sql = "SELECT c.* FROM candidate c JOIN candidate_skill cs ON c.id = cs.candidate_id WHERE cs.skill_id = ?";
        return jdbcTemplate.query(sql, new CandidateMapper(), id);
    }
}
