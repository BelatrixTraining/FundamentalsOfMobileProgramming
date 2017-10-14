package com.belatrix.fundamentals.storage.request.entity;

import com.belatrix.fundamentals.model.entity.UserEntity;

/**
 * Created by em on 8/06/16.
 {
     "msg": "success",
     "status": 200,
     "data": {
     "_id": "59e0540d429d3f501d6493de",
     "id": "59e0540d429d3f501d6493de",
     "username": "admin@admin.com",
     "password": "123456",
     "firstname": "Admin",
     "lastname": "Admin",
     "__v": 0
     }
 }

 */
public class LogInResponse {

    private String msg;

    private int status;

    private UserEntity data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserEntity getData() {
        return data;
    }

    public void setData(UserEntity data) {
        this.data = data;
    }
}
