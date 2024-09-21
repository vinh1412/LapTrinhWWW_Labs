/*
 * @ {#} LogService.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.reponsitories.LogRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/09/2024
 * @version:    1.0
 */
public class LogService {
    private LogRepository logRepository;

    public LogService() {
        this.logRepository = new LogRepository();
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Log findById(String id) {
        return logRepository.findById(id);
    }

    public boolean exists(String id) {
        return logRepository.exists(id);
    }

    public Log logLogin(String accountId) {
        return logRepository.logLogin(accountId);
    }

    public Log logLogout(String accountId) {
        return logRepository.logLogout(accountId);
    }

    public boolean addLog(Log log) {
        return logRepository.addLog(log);
    }
}
