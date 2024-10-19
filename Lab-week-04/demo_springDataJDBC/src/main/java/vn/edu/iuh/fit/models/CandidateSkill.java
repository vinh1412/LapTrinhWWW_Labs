/*
 * @ {#} CandidateSkill.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.models;

import lombok.*;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
public class CandidateSkill {
    private Candidate candidate;
    private Skill skill;
    private Integer level;

    public CandidateSkill() {
    }

    public CandidateSkill(Candidate candidate, Skill skill, Integer level) {
        this.candidate = candidate;
        this.skill = skill;
        this.level = level;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + candidate +
                ", skill=" + skill +
                ", level=" + level +
                '}';
    }
}
