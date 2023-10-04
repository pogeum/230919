package Article.view;
import Article.model.Comment;
import Article.model.CommentRepository;

import java.util.ArrayList;

public class CommentView {

    ArrayList<Comment> aaa = new ArrayList<>();

    public void printComments(CommentRepository commentRepository){
        commentRepository.printComments();
    }

}
