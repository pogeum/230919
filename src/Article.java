import java.time.LocalDateTime;

public class Article
{
    private int id; //게시물 번호

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
}

