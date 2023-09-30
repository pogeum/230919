package Article.model;

public class Article {
    private CommentRepository commentRepository = new CommentRepository();

    public LikeRepository getLikeRepository() {

        return likeRepository;
    }

    LikeRepository likeRepository = new LikeRepository();


    public void addlikeuser(Like a) {

        likeRepository.insert(a);
    }
    private int id; //게시물 번호
    private String title; // 제목
    private String content; //내용
    private String writer;//작성자
    private int like;//좋아요수
    private String regDate;//작성일
    private int hit;// 조회수

    public String getWriter() {

        return this.writer;
    }

    public void setWriter(String writer) {

        this.writer = writer;
    }


    public int getLike() {

        return like;
    }

    public void incrementLike() {
        this.like ++;
    }
    public void decrementLike() {
        this.like --;
    }


    public Article() {
    }

    public Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
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

    public void setHit() {

        this.hit ++;
    }

    public void addComment(Comment comment) {

        commentRepository.insert(comment);
    }
    public CommentRepository getCommentRepository() {

        return this.commentRepository;
    }
}
