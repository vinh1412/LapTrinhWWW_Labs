/*
 * @ {#} LogRepository.java   1.0     09/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Log;

import java.time.Instant;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   09/09/2024
 * @version:    1.0
 */
public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em= Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }
    public List<Log> findAll() {
        List<Log> logs = em.createNamedQuery("Log.findAll", Log.class).getResultList();
        return logs;
    }

    public Log findById(String id) {
        Log log = em.createNamedQuery("Log.findById", Log.class).setParameter("id", id).getSingleResult();
        return log;
    }

    public boolean exists(String id) {
        return em.createNamedQuery("Log.existsById", Boolean.class).setParameter("id", id).getSingleResult();
    }
    //Ghi log mỗi lần account đăng nhập
    public Log logLogin(String accountId){
        try {
            Log log = new Log(accountId, Instant.now().atZone(java.time.ZoneId.of("Asia/Ho_Chi_Minh")).toInstant(), "login");
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return log;
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }
    }
    //Ghi log mỗi lần account đăng xuất
    public Log logLogout(String accountId){
        try {
            Log log = new Log(accountId, Instant.now().atZone(java.time.ZoneId.of("Asia/Ho_Chi_Minh")).toInstant(), "logout");
            log.setAccountId(accountId);
            log.setLogoutTime(java.time.Instant.now());
            log.setNotes("User logout");
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return log;
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }
    }

    public boolean addLog(Log log){
        try {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            em.getTransaction().rollback();
            return false;
        }
    }
}
