package Article.model;

import Article.model.Comment;
import Article.model.CommentRepository;
import Article.view.CommentView;

public class Article {
    CommentRepository commentRepository = new CommentRepository();
    CommentView cmtv = new CommentView();
    private int id; //게시물 번호
    private String title; // 제목
    private String content; //내용
    private Comment comment;

    private int hit;// 조회수
    private String regDate;

    public Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.comment = null; //초기에는댓글이없..음..
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void addComment(String str) {
        Comment comment = new Comment();
        comment.setSentence(str);
        commentRepository.insert(comment);
        this.comment = comment;


        //Comment comment(c) = new Comment(str);//커맨트객체생성해서 받음. 생성자와동시에 객체생성?
        //어레이리스트에 에드.
        // cmtptr.setSentence();//bb
    }

    public void viewComment(){
        System.out.printf("<댓글목록>\n");
        cmtv.printComments(commentRepository);
    }









}


//    public void setComment(String aaa){
//
//        cp.setSentence(aaa);
//    }
//
//
//
//
//
//
//    public void viewComment() {
//        for (int i = 0; i < comments.size(); i++) {
//
//            System.out.printf("%s\n",comments.get(i).getSentence());
//        }
//    }
//
//    public void addcomment(String rrr) {
//        Comment abc = new Comment();
//        abc.setSentence(rrr);
//        comments.add(abc);
//    }
//
//
//}
//조회수 : 게시물 기능의 일부 -> 비즈니스 로직, 서비스 로직 ->  데이터랑 분리해놔야 좋대. 아티클 클래스에 함수정의하면 X.
//데이터를 처리하는 행위를 여기서 하면 안좋대.

/*class Comment extends Article.model.Article{

}
class Comment extends Article.model.Article {



    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}*/

