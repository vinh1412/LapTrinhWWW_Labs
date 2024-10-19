/*
 * @ {#} SikkRepositoryImpl.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.SkillRepository;
import vn.edu.iuh.fit.repositories.mapper.SkillMapper;

import javax.sql.DataSource;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@Repository
public class SkillRepositoryImpl implements SkillRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public SkillRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insert(Skill skill) {
        String sql = "INSERT INTO skill (skill_name, description, field) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, skill.getSkillName(), skill.getDescription(), skill.getField()) > 0;
    }

    @Override
    public boolean update(Skill skill) {
        String sql = "UPDATE skill SET skill_name = ?, description = ?, field = ? WHERE id = ?";
        return jdbcTemplate.update(sql, skill.getSkillName(), skill.getDescription(), skill.getField(), skill.getId()) > 0;
    }

    @Override
    public boolean delete(Skill skill) {
        String sql = "DELETE FROM skill WHERE id = ?";
        return jdbcTemplate.update(sql, skill.getId()) > 0;
    }

    @Override
    public Skill findById(Integer id) {
        String sql = "SELECT * FROM skill WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new SkillMapper(), id);
    }

    @Override
    public List<Skill> findAll() {
        String sql = "SELECT * FROM skill";
        return jdbcTemplate.query(sql, new SkillMapper());
    }

    @Override
    public List<Skill> findByCandidateId(int id) {
        String sql = "SELECT s.* FROM skill s JOIN candidate_skill cs ON s.id = cs.skill_id WHERE cs.candidate_id = ?";
        return jdbcTemplate.query(sql, new SkillMapper(), id);
    }
}
