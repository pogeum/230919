package Article.view;
import Article.model.Comment;
import Article.model.CommentRepository;

import java.util.ArrayList;

public class CommentView {

    ArrayList<Comment> aaa = new ArrayList<>();

    public void printComments(CommentRepository cr) {//어레이리스트로받기?포인터로받기?
        //해당 아티클객체에 연결된 포인터 받고, 거기꺼 댓글 출력되게,.,되나?

        aaa = cr.getarr();
        for (int i = 0; i < aaa.size(); i++) {
            Comment comment = aaa.get(i);
            System.out.printf("%s\n",comment.getSentence());
        }
        System.out.println("------------------------------");
    }
}
