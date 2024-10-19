/*
 * @ {#} SkillMapper.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.models.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
public class SkillMapper implements RowMapper<Skill> {
    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill skill = new Skill();
        skill.setId(rs.getInt("id"));
        skill.setSkillName(rs.getString("skill_name"));
        skill.setDescription(rs.getString("description"));
        skill.setField(rs.getString("field"));
        return skill;
    }
}
