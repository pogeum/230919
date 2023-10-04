package Article.model;

import java.util.ArrayList;

public class CommentRepository {
    ArrayList<Comment> comments = new ArrayList<>();

    public void insert(Comment c){
        comments.add(c);

    }

    public ArrayList<Comment> getComments(){
        return comments;

    }
    public void printComments() {
        System.out.println("---------------------");
        for (Comment comment : comments) {
            System.out.println(comment);
            System.out.println("---------------------");
        }
    }

}
