package tests.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity<Long>  {

    private String text;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id = " + id +
                ", text='" + text + '\'' +
                '}';
    }
}
