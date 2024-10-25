/*
 * @ {#} QuanLyThuocResource.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.api;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.services.QuanLyThuocService;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@Path("/quanlythuoc")
public class QuanLyThuocResource {
    @EJB
    private QuanLyThuocService quanLyThuocService;

    @GET
    @Produces("application/json")
    public Response getDsThuoc() {
        return Response.ok(quanLyThuocService.getDsThuoc()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response add(Thuoc thuoc) {
        return Response.ok(quanLyThuocService.add(thuoc)).build();
    }
}
