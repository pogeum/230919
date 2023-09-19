package Article.model;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommentRepository {
    //여기다가 코멘트객체의 배열 선언할수있다.
    ArrayList<Comment> comments = new ArrayList<>();

    public void insert(Comment c){
        comments.add(c);

    }

    public ArrayList<Comment> getarr(){
        return comments;

    }


}
