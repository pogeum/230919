package Article.controller;

import Article.model.Article;
import Article.model.LikeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    // mvc로 뷰 나눈거 호출
//    ArrayList<Comment> comments = new ArrayList<>();

    ArticleController articleController = new ArticleController();
    UserController userController = new UserController();
    PageController pageController = new PageController();

    LikeRepository likeRepository = new LikeRepository();

    Scanner scan = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                articleController.setLoginUser(userController.getLoginUser());
                articleController.add();

            } else if (command.equals("list")) {
                articleController.list();

            } else if (command.equals("update")) {
                articleController.update();

            } else if (command.equals("delete")) {
                articleController.delete();
//                    articles.remove(article); // r괄호속 article참조변수가 가리키는 값 삭제함.
            } else if (command.equals("detail")) {
                articleController.setLoginUser(userController.getLoginUser());
                articleController.setLikeRepository(likeRepository.getLikerepository());
                articleController.detail();

            } else if (command.equals("search")) {
                articleController.search();
            } else if (command.equals("signup")) {
                userController.signup();
            } else if (command.equals("login")) {
                userController.login();
            } else if (command.equals("page")) {
                pageController.setArticleRepository(articleController.getArticleRepository());
                pageController.paging();
            }


        }
    }

}

