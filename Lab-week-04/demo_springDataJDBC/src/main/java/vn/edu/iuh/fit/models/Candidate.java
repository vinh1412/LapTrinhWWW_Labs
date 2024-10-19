/*
 * @ {#} Candidate.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
      
package vn.edu.iuh.fit.models;

import lombok.*;
import vn.edu.iuh.fit.utils.AppUtil;

import java.time.LocalDate;

/*
 * @description: 
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Candidate {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private LocalDate dob;

    public String getFirstName() {
        return AppUtil.splitFullName(fullName)[0];
    }

    public String getMiddleName() {
        return AppUtil.splitFullName(fullName)[1];
    }

    public String getLastName() {
        return AppUtil.splitFullName(fullName)[2];
    }
}
