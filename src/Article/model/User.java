package Article.model;

public class User {
    private String ID;
    private String password;
    private String nickname;
    public User(String id, String pw, String nm) {
        this.ID = id;
        this.password = pw;
        this.nickname = nm;
    }
    public String getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }

}
