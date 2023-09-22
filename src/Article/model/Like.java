package Article.model;
import util.Util;
public class Like {
    private User user;
    private Article article;
    private Util date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Util getDate() {
        return date;
    }

    public void setDate(Util date) {
        this.date = date;
    }
}
