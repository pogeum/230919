package Article.controller;
import Article.model.UserRepository;
import Article.model.User;
public class LoginUser {

    private User loginuser;

    LoginUser(){}

    public LoginUser(User a){
        this.loginuser = a;
    }
    public User getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(User loginuser) {
        this.loginuser = loginuser;
    }


}
