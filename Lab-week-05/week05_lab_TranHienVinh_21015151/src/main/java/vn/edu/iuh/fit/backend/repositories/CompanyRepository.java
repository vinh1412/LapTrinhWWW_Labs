/*
 * @ {#} CompanyRepository.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.Company;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/11/2024
 * @version:    1.0
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByCompNameOrEmail(String compName, String email);
}
