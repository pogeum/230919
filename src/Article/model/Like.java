package Article.model;

public class Like {
    private User user;
    private Article article;
    private String date;

    public Like(User u,Article a, String d){
        this.user = u;
        this.article = a;
        this.date = d;

    }

    public String getUsernickname(){

        return user.getNickname();
    }

    public User getUser() {

        return user;
    }


    public Article getArticle() {

        return article;
    }



    public String getDate() {

        return date;
    }


}
