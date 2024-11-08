/*
 * @ {#} AddressRepository.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Address;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   06/11/2024
 * @version:    1.0
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
