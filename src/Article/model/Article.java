import java.time.LocalDateTime;
import java.util.ArrayList;

public class Article
{
    private int id; //게시물 번호
    ArrayList<Comment> comments = new ArrayList<>();
    //ㄴ얘가 잇어서 포인터따로필요없음 .? ->왜그런지생가해보기
    private int view = 0; //조회수.int는 따로 대입안해놔도 0으로 자동 세팅 됨.
    //Comment aComment; //댓글객체들 포인터...
    private Comment cp;

    public Comment getCp() {
        return cp;
    }

    public void setCp(Comment cp) {
        this.cp = cp;
    }
//    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    //내용
    private String content;
    private LocalDateTime currentTime;
   // publice void S
    public Object getCurrentTime() {
    //String Object = currentTime;

        return currentTime;
    }
    //getRegDate??

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    // 작성자
    //작성일
    //        조회수
      //              ...
    public Article(String title, String content, int num){
        this.id = num;
        this.title = title;
        this.content = content;
        this.currentTime = LocalDateTime.now();
        this.cp = new Comment();
    }
    //alt+ insert -> 게터세터 자동세팅해줌
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

    public void setView(int a){
        this.view =a;
    }
    public int getView(){ return view; }

    public void setComment(String aaa){

        cp.setSentence(aaa);
    }






    public void viewComment() {
        for (int i = 0; i < comments.size(); i++) {

            System.out.printf("%s\n",comments.get(i).getSentence());
        }
    }

    public void addcomment(String rrr) {
        Comment abc = new Comment();
        abc.setSentence(rrr);
        comments.add(abc);
    }


}
//조회수 : 게시물 기능의 일부 -> 비즈니스 로직, 서비스 로직 ->  데이터랑 분리해놔야 좋대. 아티클 클래스에 함수정의하면 X.
//데이터를 처리하는 행위를 여기서 하면 안좋대.

/*class Comment extends Article{

}
class Comment extends Article {



    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}*/

