package Article.controller;

import java.util.Scanner;

import Article.model.User;
import Article.model.UserRepository;

public class UserController {
    Scanner scan = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();

    private User loginUser;

    public User getLoginUser() {
        return loginUser;
    }

    public void signup(){

        System.out.print("==== 회원가입을 진행합니다 ====\n");
        System.out.print("아이디 설정 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호 설정 : ");
        String pw = scan.nextLine();
        System.out.print("닉네임 설정 : ");
        String nm = scan.nextLine();
        User user = new User(id,pw,nm);
        userRepository.insertuser(user);
        System.out.print("==== 회원가입이 완료되었습니다 ====\n");


    }
    public void login() {

        System.out.print("아이디 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호 : ");
        String pw = scan.nextLine();
        this.loginUser = userRepository.finduserbyId(id,pw);

    }
}
