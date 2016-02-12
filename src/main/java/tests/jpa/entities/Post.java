package tests.jpa.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@NamedEntityGraph(name = "graph.Post.comments",
        attributeNodes = @NamedAttributeNode("comments"))
public class Post extends BaseEntity<Long> {

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", referencedColumnName="id")
    private List<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id = " + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
