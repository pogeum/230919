package Article.controller;

import java.util.Scanner;
import Article.model.User;
import Article.model.UserRepository;

public class UserController {
    Scanner scan = new Scanner(System.in);
    UserRepository userRepository = new UserRepository();

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
        //회원고유번호 발급해서 그걸로 구분하기. 아닌가..

       // userRepository.out();

    }
    public void login() {

        System.out.print("아이디 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호 : ");
        String pw = scan.nextLine();
        userRepository.finduserbyId(id,pw);
//        System.out.print("여기실행됏나\n");




    }
}
