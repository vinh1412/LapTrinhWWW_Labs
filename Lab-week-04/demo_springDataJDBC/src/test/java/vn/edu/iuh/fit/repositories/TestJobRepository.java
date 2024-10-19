/*
 * @ {#} TestJobRepositories.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Job;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@SpringBootTest
public class TestJobRepository {
    private JobRepository jobRepository;

    @Autowired
    public TestJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Test
    void testInsert() {
        Job job = new Job();
        job.setDescription("Java Developer2");

        boolean result = jobRepository.insert(job);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testUpdate() {
        Job job = new Job();
        job.setId(1);
        job.setDescription("Java Developer1");

        boolean result = jobRepository.update(job);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testDelete() {
        Job job = new Job();
        job.setId(1);

        boolean result = jobRepository.delete(job);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testFindAll() {
        Assertions.assertEquals(2, jobRepository.findAll().size());
    }
    @Test
    void testFindById() {
        Job job = jobRepository.findById(1);
        Assertions.assertEquals(1, job.getId());
    }
}
