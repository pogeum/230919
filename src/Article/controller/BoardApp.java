package Article.controller;

import Article.model.Article;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    // mvc로 뷰 나눈거 호출
//    ArrayList<Comment> comments = new ArrayList<>();

    ArticleController articleController = new ArticleController();
    UserController userController = new UserController();
    //LoginUser loginUser = new LoginUser();
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
                articleController.detail();

            } else if (command.equals("search")) {
                articleController.search();
            } else if (command.equals("signup")) {
                userController.signup();
            } else if (command.equals("login")) {
                userController.login();
            }


        }
    }

}

//    public void viewComment(Article.model.Article a) {
//        for (int i = 0; i < comments.size(); i++) {
//            a.getCp(); //-> 코멘트객체반환
//
//            System.out.printf("%s\n",a.getCp());
//        }
//    }
//
//    public void addcomment(Article.model.Article article, String rrr) {
//        article.setComment(rrr);
//        comments.add(article.getCp());
//    }

/*
    public static void viewComment(Article.model.Article a){

        Comment comments = new Comment();
        System.out.print("=================================\n");
        System.out.print("<댓글>\n");
        System.out.printf("댓글 내용 : %s", a.);


    }
    public void postComment(String sentence){
        //이함수가 호출되면 댓글겍체포인터 같이 생성되도록,.,어케함r근데 해당게시물객체랑 연결해야되는데
        Comment comments = new Comment();
        comments.setSentence(sentence);
    }
*/
