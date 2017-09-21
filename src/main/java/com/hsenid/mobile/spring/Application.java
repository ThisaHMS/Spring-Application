package com.hsenid.mobile.spring;

import java.util.List;

import com.hsenid.mobile.spring.view.UiFactory;
import com.hsenid.mobile.spring.view.UserInterface;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Application {

    static JdbcTemplate template;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
        template = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        UserInterface userInterface = UiFactory.create();
        userInterface.loadUi();

        //insert(template);
        //select(template);
        //update(template);
        //delete(template);
    }

    public static JdbcTemplate template(){
        return template;
    }

    /*private static void insert(JdbcTemplate template) {
        String query = "insert into testdb.author (id, name) values (?, ?)";
        String query2 = "insert into testdb.book (id , name, author_id) values(? , ? , ?)";
        template.update(query, new Object[]{5, "Test Author4"});
        template.update(query2, new Object[]{2 , "Test2", 2});
    }

    private static void select(JdbcTemplate template) {
        String query = "select * from testdb.author";

        List<?> list = template.queryForList(query);
        for (Object object : list) {
            System.out.println("Author is " + object);
        }
    }

    private static void update(JdbcTemplate template) {
        String query = "update testdb.author set name = ? where id = ?";
        template.update(query, new Object[]{"Test Author 2", 1});
    }

    private static void delete(JdbcTemplate template) {
        String query = "delete from testdb.author where id = ?";
        template.update(query, new Object[]{1});
    }*/
}