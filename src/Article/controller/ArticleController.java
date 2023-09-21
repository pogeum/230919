package Article.controller;

import Article.model.Article;
import Article.model.ArticleRepository;
import Article.model.User;
import Article.model.UserRepository;

import Article.model.Comment; //어차피아티클가서하는거라 직접적인 커맨트클래스는 필요없다. 안쓰임.
import Article.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();
    UserRepository userRepository = new UserRepository();
    LoginUser loginUser ;
    Scanner scan = new Scanner(System.in);

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();
        Article article = new Article();
        articleRepository.insert(article);
        if(loginUser != null){
            //위에아티클에  writer넣어야되늰데
        }

        System.out.println("게시물이 등록되었습니다.");
       // ArrayList<User> user = new ArrayList<>();
       // user = userRepository.getUsers();
     /*   ArrayList<User> user = new ArrayList<>();
        user = userRepository.getUsers();
        if(user != null){
            article.setWriter(user.get(0).getNickname());//계속 같은객체로 실행되는건지 질문.
        }*/


    }

    public void list() {
        ArrayList<Article> articles = articleRepository.findAllArticles();
        articleView.printArticles(articles);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int targetId = scan.nextInt();
        scan.nextLine();
        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
        } else {
            System.out.print("제목 : ");
            String newTitle = scan.nextLine();
            System.out.print("내용 : ");
            String newContent = scan.nextLine();

            article.setTitle(newTitle);
            article.setContent(newContent);


            //이거왜 새로운객체에 넣엇다가 재 대입 안하고 이렇게 하는지?? 단계하나줄인거임?


            System.out.println("수정이 완료되었습니다.");
        }
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = scan.nextInt();

        scan.nextLine();

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
        } else {
            articleRepository.delete(article);
        }
    }

    public void detail() {
        //중복 -> 함수
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int targetId = scan.nextInt();

        Article article = articleRepository.findById(targetId);

        scan.nextLine();

        if(article == null){
            System.out.println("존재하지 않는 게시물입니다.");
        } else {
            article.setHit(article.getHit()+1); //왜굳이 여기서 하냐
            articleView.printArticleDetail(article);
            System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록  2.추천  3.수정  4.삭제  5.목록으로) : ");
            int num = scan.nextInt();
            scan.nextLine();

            if(num==1){
                System.out.print("댓글 달기 : ");
                String words = scan.nextLine();
                //Comment comment = new Comment(words); //커맨트 객체 생성해서 바로 받음.
                article.addComment(words); // 바로코멘트클래스 안하고 아티클로 접근하는이유 : 해당 아티클 객체에 연결된 커멘트 객체배열 접근하려고.
                System.out.println("댓글이 등록되었습니다.\n");
                // c++ c번째댓글,.,.,추가.,.,
            }
            if(num==2){

            }
            if(num==3){
                UserRepository userRepository1 = new UserRepository();
                ArrayList<User> users = new ArrayList<>();
                users = userRepository1.getUsers();
                if(users.get(0).getNickname().equals(article.getWriter())){
                    Article update = null;
                    System.out.print("수정할 제목 : ");
                    String newtitle = scan.nextLine();
                    System.out.print("수정할 내용 : ");
                    String newcontent = scan.nextLine();
                    article.setTitle(newtitle);
                    article.setContent(newcontent);
                    System.out.print("수정완료!\n===================\n");
                    articleView.printArticleDetail(article);
                } else {
                    System.out.print("자신의 게시물만 수정/삭제 할수 있습니다.\n");
                }


            }
            if(num==4){
                UserRepository userRepository1 = new UserRepository();
                ArrayList<User> users = new ArrayList<>();
                users = userRepository1.getUsers();
                if(users.get(0).getNickname().equals(article.getWriter())){
                    System.out.print("정말 게시물을 삭제하시겠습니까? (y/n)");
                    String yn = scan.nextLine();
                    if(yn.equals("y")){
                        articleRepository.delete(article);
                        System.out.printf("%s 님의 %d번 게시물을 삭제했습니다.\n",article.getWriter(),article.getId());
                    }
                } else {
                    System.out.print("자신의 게시물만 수정/삭제 할수 있습니다.\n");
                }


            }
            if(num==5){

            }

        }
    }

    public void search(){
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
        articleView.printArticles(searchedArticles);
    }

    public void signup(){
        System.out.print("==== 회원 가입을 진행합니다 ====\n");
    }

}



