package sopt.org.SecondSeminar.domain.post;

import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private int like;

    public Post(String writer, String title, String content, int like) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.like = like;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public  String toString() {
        return  "id: " + this.id + "\n" +
                "writer: " + this.writer + "\n" +
                "title: " + this.title + "\n" +
                "content: " + this.content + "\n" +
                "like: " + this.like;
    }

}
