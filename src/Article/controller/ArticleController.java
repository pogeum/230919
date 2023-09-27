package Article.controller;

import Article.model.*;
import util.Util;


import Article.view.ArticleView;
import Article.model.Like;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleView articleView = new ArticleView(); //이게이미composition인가?

    ArticleRepository articleRepository = new ArticleRepository();


    public ArticleRepository getArticleRepository() {

        return this.articleRepository;

    }



    private LoginUser loginUser;
    private LikeRepository likeRepository;

    public void setLoginUser(LoginUser a){
        this.loginUser = a;
    }

    public void setLikeRepository(LikeRepository a){this.likeRepository=a;}

    //위에중요!

    //User linuser = new User();
   // LoginUser loginUser = new LoginUser();//로그인유저에 전달메서드 잇어야되나?


    Scanner scan = new Scanner(System.in);
    int lastArticleId = 17;
    public void add() {

        Util util = new Util();
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();
        Article article = new Article(lastArticleId,title,content,util.getCurrentDate());

        //articleRepository.insert(article);
        if(loginUser != null){
            article.setWriter(loginUser.getLoginuser().getNickname());
            System.out.print("회원작성자 ㅇㅇ\n");

        }else {
            article.setWriter("익명");
            System.out.print("익명작성자 ㅇㅇ\n");
        }
        articleRepository.insert(article);


        lastArticleId++;

        System.out.println("게시물이 등록되었습니다.");


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
            System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록  2.좋아요  3.수정  4.삭제  5.목록으로) : ");
            int num = scan.nextInt();
            scan.nextLine();

            if(num==1){
                System.out.print("댓글 달기 : ");
                String words = scan.nextLine();

                article.addComment(words);
                System.out.println("댓글이 등록되었습니다.\n");

            }
            if(num==2){
                if(loginUser != null){
                    String compare;
                    compare = loginUser.getLoginuser().getNickname();
                    LikeRepository lry = likeRepository.getLikerepository();
                    Like likeuser = lry.findbyNick(compare);
                    if(likeuser==null){//해당 게시물에 좋아요리스트 하나도 없거나, 리스트 있는데 닉넴 일치일경우


                        Util util = new Util();//if문안에 다시 넣어서, 값이잇으면 equals실행시켜야하는
                        Like like2 = new Like(loginUser.getLoginuser(),article,util.getCurrentDate());
                        article.setLike();//조아요수 늘리기
                        article.addlike(like2);
                        lry.insert(like2);
                        articleView.printArticleDetail(article);
                    } else {
                        if(likeuser.getUsernickname().equals(compare)) {
                            System.out.print("이미 좋아요를 누르셨습니다.\n");
                        }
                        else{
                            Util util = new Util();
                            Like like2 = new Like(loginUser.getLoginuser(),article,util.getCurrentDate());
                            article.setLike();
                            article.addlike(like2);
                            articleView.printArticleDetail(article);
                        }
                    }


                } else { //로그인해도 왜 이것만출려;ㄱ;;;;;;;;;;객체또 새로 생성햇나보네;
                    System.out.print("로그인 후 이용하세요.\n");
                }


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
                //users = userRepository1.getUsers();



                if(loginUser.getLoginuser().getNickname().equals(article.getWriter())){
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



