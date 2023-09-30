package Article.controller;

import Article.model.*;
import Article.model.Like;
import Article.view.CommentView;
import Article.view.ArticleView;
import util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleView articleView = new ArticleView();
    CommentView commentView = new CommentView();
    ArticleRepository articleRepository = new ArticleRepository();
    CommentRepository commentRepository = new CommentRepository();


    public ArticleRepository getArticleRepository() {

        return this.articleRepository;

    }


    private User loginUser;
    private LikeRepository likeRepository;

    public void setLoginUser(User a) {
        this.loginUser = a;
    }

    public void setLikeRepository(LikeRepository a) {
        this.likeRepository = a;
    }

    //위에중요!

    //User linuser = new User();
    // LoginUser loginUser = new LoginUser();//로그인유저에 전달메서드 잇어야되나?


    Scanner scan = new Scanner(System.in);
    int lastArticleId = 17;

    public void add() {

        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();
        Util util = new Util();
        Article article = new Article(lastArticleId, title, content, util.getCurrentDate());

        if (loginUser != null) {
            article.setWriter(loginUser.getNickname());

        } else {
            article.setWriter("익명");
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
        scan.nextLine();
        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("존재하지 않는 게시물입니다.");
        } else {
            article.setHit();
            articleView.printArticleDetail(article);
            commentView.printComments(article.getCommentRepository());
            System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록  2.좋아요  3.수정  4.삭제  5.목록으로) : ");
            String num = scan.nextLine();

            if (num.equals("1")) { //댓글등록
                System.out.print("댓글 달기 : ");
                String words = scan.nextLine();
                Comment comment = new Comment(words);
                article.addComment(comment);
                System.out.println("댓글이 등록되었습니다.\n");

            } else if (num.equals("2")) { //좋아요
                if (loginUser != null) {
                    String findnick;
                    findnick = loginUser.getNickname();
                    Like finduser = article.getLikeRepository().findbyNick(findnick);
                    Util util = new Util();

                    if (finduser == null) { //현재 아티클의 좋아요 목록에 로그인유저가 없음.
                        Like likeuser = new Like(loginUser, article, util.getCurrentDate());
                        article.addlikeuser(likeuser);//이거를아티클에서하면안된댓는대 아닌가 호출만한건가/?
                        article.incrementLike();
                        articleView.printArticleDetail(article);
                    } else { // 잇음 로그인유저가
                        article.decrementLike();
                        System.out.print("좋아요 취소.\n");
                        articleView.printArticleDetail(article);
                    } //토글기능
                } else {
                    System.out.print("로그인 후 이용하세요.\n");
                }


            } else if (num.equals("3")) { //수정

                if (loginUser.getNickname().equals(article.getWriter())) {
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


            } else if (num.equals("4")) { //삭제

                if (loginUser.getNickname().equals(article.getWriter())) {
                    System.out.print("정말 게시물을 삭제하시겠습니까? (y/n)");
                    String yn = scan.nextLine();
                    if (yn.equals("y")) {
                        articleRepository.delete(article);
                        System.out.printf("%s 님의 %d번 게시물을 삭제했습니다.\n", article.getWriter(), article.getId());
                    }
                } else {
                    System.out.print("자신의 게시물만 수정/삭제 할수 있습니다.\n");
                }

            } else if (num.equals("5")) { //목록으로

            }

        }
    }

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
        articleView.printArticles(searchedArticles);
    }

}



