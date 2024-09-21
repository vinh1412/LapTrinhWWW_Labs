/*
 * @ {#} Account.java   1.0     27/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.session01.ex01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   27/08/2024
 * @version:    1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "username", columnDefinition = "varchar(255)")
    private String userName;
    @Column(name = "password", columnDefinition = "varchar(20)")
    private String passWord;

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
