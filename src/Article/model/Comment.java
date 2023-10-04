package Article.model;

public class Comment {
    private String sentence;

    public Comment(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {

        return sentence;
    }

    public String toString() {
        return "댓글 : " + this.sentence ;
    }

}
