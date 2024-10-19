/*
 * @ {#} AppUtil.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.utils;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
public class AppUtil {
    public static String[] splitFullName(String fullName) {
        // Tách lastName, firstName, middleName từ fullName
        String[] nameParts = fullName.trim().split("\\s+");

        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameParts.length ==1) {
            firstName = nameParts[0];
        }
        else if (nameParts.length == 2) {
            lastName = nameParts[0];
            firstName = nameParts[1];
        } else if (nameParts.length > 2) {
            lastName = nameParts[0];
            firstName = nameParts[nameParts.length - 1];
            for (int i = 1; i < nameParts.length - 1; i++) {
                middleName += nameParts[i] + " ";
            }
        }

        return new String[]{firstName, middleName, lastName};
    }
}
