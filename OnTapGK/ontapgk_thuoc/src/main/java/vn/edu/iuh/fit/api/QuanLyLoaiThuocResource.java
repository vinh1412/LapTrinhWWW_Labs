/*
 * @ {#} QuanLyLoaiThuoc.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.api;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.services.QuanLyLoaiThuocService;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@Path("/quanlyloaithuoc")
public class QuanLyLoaiThuocResource {
    @EJB
    private QuanLyLoaiThuocService quanLyLoaiThuocService;

    @GET
    @Produces("application/json")
    public Response getDsLoaiThuoc() {
        return Response.ok(quanLyLoaiThuocService.getDsLoaiThuoc()).build();
    }

    @GET
    @Path("/{idLoaiThuoc}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response getDsThuocByLoaiThuoc(@PathParam("idLoaiThuoc") int idLoaiThuoc) {
        return Response.ok(quanLyLoaiThuocService.getDsThuocByLoaiThuoc(idLoaiThuoc)).build();
    }
}
