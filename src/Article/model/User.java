package Article.model;

public class User {
    private String ID;
    private String password;
    private String nickname;
//    User(){}
    User(){}
    public User(String id, String pw, String nm) {
        this.ID = id;
        this.password = pw;
        this.nickname = nm;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }






}
