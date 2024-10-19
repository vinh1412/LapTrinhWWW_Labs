/*
 * @ {#} CandidateMapper.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.models.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
public class CandidateMapper implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(rs.getInt("id"));
        candidate.setFullName(rs.getString("last_name") + " "+rs.getString("middle_name")+" " + rs.getString("first_name"));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setPhone(rs.getString("phone"));
        candidate.setAddress(rs.getString("address"));
        return candidate;
    }
}
