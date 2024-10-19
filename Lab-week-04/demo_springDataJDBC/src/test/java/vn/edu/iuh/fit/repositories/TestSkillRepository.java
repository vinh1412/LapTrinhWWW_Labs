/*
 * @ {#} TestSkillRepository.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Skill;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@SpringBootTest
public class TestSkillRepository {
    private SkillRepository skillRepository;

    @Autowired
    public TestSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Test
    void insert() {
        Skill skill = new Skill();
        skill.setSkillName("Python");
        skill.setDescription("Python Developer");
        skill.setField("IT");

        boolean result = skillRepository.insert(skill);
        Assertions.assertEquals(true, result);
    }

    @Test
    void update() {
        Skill skill = new Skill();
        skill.setId(2);
        skill.setSkillName("PHP");
        skill.setDescription("PHP Developer");
        skill.setField("IT");

        boolean result = skillRepository.update(skill);
        Assertions.assertEquals(true, result);
    }

    @Test
    void delete() {
        Skill skill = new Skill();
        skill.setId(1);

        boolean result = skillRepository.delete(skill);
        Assertions.assertEquals(true, result);
    }

    @Test
    void findById() {
        Skill skill = skillRepository.findById(1);
        Assertions.assertEquals("Java2", skill.getSkillName());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(2, skillRepository.findAll().size());
    }
    @Test
    void findByCandidateId() {
        Assertions.assertEquals(3, skillRepository.findByCandidateId(3).size());
    }
}
