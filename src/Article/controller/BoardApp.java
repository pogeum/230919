package Article.controller;
import java.util.Scanner;

public class BoardApp {


    ArticleController articleController = new ArticleController();
    UserController userController = new UserController();
    PageController pageController = new PageController();

    Scanner scan = new Scanner(System.in);

    public void start() {



        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
               // articleController.setLoginUser(userController.getLoginUser()); /////////////////// -> 코드중복. 밖에다 빼놓기.
                articleController.add();

            } else if (command.equals("list")) {
                articleController.list();

            } else if (command.equals("update")) {
                articleController.update();

            } else if (command.equals("delete")) {
                articleController.delete();
            } else if (command.equals("detail")) {
               // articleController.setLoginUser(userController.getLoginUser());
               // articleController.setLikeRepository(likeRepository.getLikerepository());/////////////// 빼야되는데 ㅜㅜㅡㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ
                articleController.detail();

            } else if (command.equals("search")) {
                articleController.search();
            } else if (command.equals("signup")) {
                userController.signup();
            } else if (command.equals("login")) {
                userController.login();
                articleController.setLoginUser(userController.getLoginUser());//이거 왜 밖에다 빼놓으면 실행안되는지?
            } else if (command.equals("page")) {
                pageController.setArticleRepository(articleController.getArticleRepository());
                pageController.paging();
            }


        }
    }

}

