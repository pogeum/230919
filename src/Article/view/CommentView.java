package Article.view;
import Article.model.Comment;
import Article.model.CommentRepository;

import java.util.ArrayList;

public class CommentView {

    ArrayList<Comment> aaa = new ArrayList<>();

    public void printComments(CommentRepository cr) {
        aaa = cr.getarr();
        for (int i = 0; i < aaa.size(); i++) {
            Comment comment = aaa.get(i);
            System.out.printf("%s\n",comment.getSentence());
        }
        System.out.println("------------------------------");
    }
}
