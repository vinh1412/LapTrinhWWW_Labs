/*
 * @ {#} LoginBean.java   1.0     27/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.session01.ex01.beans;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   27/08/2024
 * @version:    1.0
 */
public class LoginBean {
    public boolean checkLogin(String username, String password){
        if (username.equals("ty") && password.equals("123")){
            return true;
        }
        return false;
    }
}
