package Article.model;

public class Like {
    private User user;
    private Article article;
    private String date;

    public Like(User likeuser,Article likearticle, String likedate){
        this.user = likeuser;
        this.article = likearticle;
        this.date = likedate;

    }

    public String getUsernickname(){

        return user.getNickname();
    }
    public Article getArticle() {

        return article;
    }



    public String getDate() {

        return date;
    }


}
