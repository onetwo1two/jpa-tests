package tests.jpa.tests;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tests.jpa.config.AppConfig;
import tests.jpa.dao.PostDao;
import tests.jpa.entities.Post;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.scan("tests.jpa.dao");

        PostDao postDao = ctx.getBean(PostDao.class);


        Post post1 = postDao.getById(1L);
        System.out.println(post1);

        Post post = postDao.testEntityGraph(1L);
        System.out.println(post);
    }
}
