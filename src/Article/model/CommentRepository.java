package Article.model;

import java.util.ArrayList;

public class CommentRepository {
    ArrayList<Comment> comments = new ArrayList<>();

    public void insert(Comment c){
        comments.add(c);

    }

    public ArrayList<Comment> getarr(){
        return comments;

    }


}
