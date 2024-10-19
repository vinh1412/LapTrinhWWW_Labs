/*
 * @ {#} JobMapper.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.models.Job;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
public class JobMapper implements RowMapper<Job> {
    @Override
    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
        Job job = new Job();
        job.setId(rs.getInt("id"));
        job.setDescription(rs.getString("description"));
        return job;
    }
}
