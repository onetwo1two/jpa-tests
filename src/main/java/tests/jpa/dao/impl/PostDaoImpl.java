package tests.jpa.dao.impl;


import org.springframework.stereotype.Repository;
import tests.jpa.dao.PostDao;
import tests.jpa.entities.Post;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PostDaoImpl extends AbstractDaoImpl<Post, Long> implements PostDao {

    @Override
    public Post testEntityGraph(Long id) {
        EntityGraph eg = entityManager.getEntityGraph("graph.Post.comments");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", eg);
        Post post = entityManager.find(Post.class, id, hints);
        return post;
    }
}
