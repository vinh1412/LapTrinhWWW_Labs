/*
 * @ {#} QuanLyLoaiThuocModel.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entities.LoaiThuoc;
import vn.edu.iuh.fit.entities.Thuoc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
public class QuanLyLoaiThuocModel {
    private final String URL="http://localhost:8080/ontapgk_thuoc-1.0-SNAPSHOT/api/quanlyloaithuoc";
    public List<LoaiThuoc> getDsLoaiThuoc() {
        List<LoaiThuoc> loaiThuocList = new ArrayList<>();
        try(Client client= ClientBuilder.newClient()){
            WebTarget target=client.target(URL);
            Response response=target.request().accept("application/json").get();
            if(response.getStatus()==Response.Status.OK.getStatusCode()){
                String data=response.readEntity(String.class);
                Gson gson=new Gson();
                Type listType=new TypeToken<List<LoaiThuoc>>(){}.getType();
                loaiThuocList= gson.fromJson(data,listType);
            }else{
                System.out.println("Failed to get data");
            }
            response.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return loaiThuocList;
    }
    public List<Thuoc> getDsThuocByLoaiThuoc(int idLoaiThuoc) {
        List<Thuoc> thuocList = new ArrayList<>();
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL+"/"+idLoaiThuoc).path(String.valueOf(idLoaiThuoc));
            Response response = target.request().accept("application/json").get();
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String data = response.readEntity(String.class);
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Thuoc>>() {
                }.getType();
                thuocList = gson.fromJson(data, listType);
            } else {
                System.out.println("Failed to get data");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thuocList;
    }
}
