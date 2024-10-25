/*
 * @ {#} XeServiceImpl.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeDAO;
import vn.edu.iuh.fit.repositories.impl.XeDAOImpl;
import vn.edu.iuh.fit.services.XeService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   25/10/2024
 * @version:    1.0
 */
public class XeServiceImpl implements XeService {
    private XeDAO xeDAO;

    public XeServiceImpl() {
        this.xeDAO=new XeDAOImpl();
    }

    @Override
    public List<Xe> getDsXe() {
        return xeDAO.getDsXe();
    }

    @Override
    public Xe findById(int idXe) {
        return xeDAO.findById(idXe);
    }

    @Override
    public Xe findByName(String tenxe) {
        return xeDAO.findByName(tenxe);
    }

    @Override
    public Xe addXe(Xe xe) {
        return xeDAO.addXe(xe);
    }

    @Override
    public Xe editXe(Xe xe) {
        return xeDAO.editXe(xe);
    }

    @Override
    public Xe deleteXe(Xe xe) {
        return xeDAO.deleteXe(xe);
    }
}
