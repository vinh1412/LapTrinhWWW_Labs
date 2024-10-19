/*
 * @ {#} JobRepository.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Job;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
public interface JobRepository {
   boolean insert(Job job);
    boolean update(Job job);
    boolean delete(Job job);
    Job findById(int id);
    List<Job> findAll();
}
