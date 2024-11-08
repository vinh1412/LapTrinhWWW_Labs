/*
 * @ {#} JobService.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.JobRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }
}
