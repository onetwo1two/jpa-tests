package tests.jpa.dao;


import tests.jpa.entities.Post;

public interface PostDao extends AbstractDao<Post, Long> {

    Post testEntityGraph(Long id);

}
