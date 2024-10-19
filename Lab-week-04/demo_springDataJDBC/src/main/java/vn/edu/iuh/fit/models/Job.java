/*
 * @ {#} Job.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.models;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
public class Job {
    private Integer id;
    private String description;

    public Job() {
    }

    public Job(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
