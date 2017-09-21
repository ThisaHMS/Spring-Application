package com.hsenid.mobile.spring.controller;

import com.hsenid.mobile.spring.Application;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by hsenid on 9/21/17.
 */

public class DbController {

    JdbcTemplate template = Application.template();

    public void insertData(Object... obj){

        if(obj.length == 2) {
            String query = "insert into testdb.author (id, name) values (?, ?)";
            template.update(query, obj);
        }else if(obj.length == 3){
            String query = "insert into testdb.book (id , name, author_id) values(? , ? , ?)";
            template.update(query, obj);
        }
    }

    public void selectData(boolean id) {

        List<?> list = null;

        if(id == true){
            String query = "select * from testdb.book";
            list = template.queryForList(query);
        }else if (id == false){
            String query = "select * from testdb.author";
            list = template.queryForList(query);
        }


        for (Object object : list) {
            System.out.println("Book" + object);
        }
    }

    public void updateData(Integer id, String value){

        String query = "update testdb.book set availability = ? where id = ?";
        template.update(query, new Object[]{value , id});
    }

    public void deleteData(){

    }

    public boolean checkAvailability(int bookId) {

        String query = "select availability from testdb.book where id = + "+ bookId;
        String avail = template.queryForObject(query , String.class);

        if (avail.equals("true")) {
            return true;
        }else {
            return false;
        }
    }
}
