package Article.model;
//데이터를 저장해놓는 패키지 따로 만듦. mvc의 m

import Article.model.Article;

import util.Util;
import java.util.ArrayList;
import Article.model.User;
import Article.model.UserRepository;

public class ArticleRepository {
    ArrayList<Article> articles = new ArrayList<>();
//    ArticleRepository articleRepository = new ArticleRepository();
    UserRepository userRepository = new UserRepository();
    //User user = new User();


    public ArticleRepository() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", Util.getCurrentDate());
        Article a2 = new Article(2, "자바 질문좀 할게요~.", "냉무", Util.getCurrentDate());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", Util.getCurrentDate());
        Article a4 = new Article(4, "4번 게시물", "내용 4", Util.getCurrentDate());
        Article a5 = new Article(5, "5번 게시물", "내용 5", Util.getCurrentDate());
        Article a6 = new Article(6, "6번 게시물", "내용 6", Util.getCurrentDate());
        Article a7 = new Article(7, "7번 게시물", "내용 7", Util.getCurrentDate());
        Article a8 = new Article(8, "8번 게시물", "내용 8", Util.getCurrentDate());
        Article a9 = new Article(9, "9번 게시물", "내용 9", Util.getCurrentDate());
        Article a10 = new Article(10, "10번 게시물", "내용 10", Util.getCurrentDate());
        Article a11 = new Article(11, "11번 게시물", "내용 11", Util.getCurrentDate());
        Article a12 = new Article(12, "12번 게시물", "내용 12", Util.getCurrentDate());
        Article a13 = new Article(13, "13번 게시물", "내용 13", Util.getCurrentDate());
        Article a14 = new Article(14, "14번 게시물", "내용 14", Util.getCurrentDate());
        Article a15 = new Article(15, "15번 게시물", "내용 15", Util.getCurrentDate());
        Article a16 = new Article(16, "16번 게시물", "내용 16", Util.getCurrentDate());

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        articles.add(a5);
        articles.add(a6);
        articles.add(a7);
        articles.add(a8);
        articles.add(a9);
        articles.add(a10);
        articles.add(a11);
        articles.add(a12);
        articles.add(a13);
        articles.add(a14);
        articles.add(a15);
        articles.add(a16);


    }

    public void insert(Article a) {
        //Article article = new Article(lastArticleId, title, content, Util.getCurrentDate());
        articles.add(a);
       // System.out.print(a.getWriter());
    }

    public void delete(Article article) {
        articles.remove(article);//값기반 삭제
        //articles.remove(i) 위치기반 삭제
    }

    public ArrayList<Article> findAllArticles() {
        return articles;
    }

    public Article findById(int id) {
        Article target = null;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

    public ArrayList<Article> findByTitle(String keyword) {
        ArrayList<Article> searchedArticles = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String title = article.getTitle();

            if (title.contains(keyword)) {
                searchedArticles.add(article);
            }
        }
        return searchedArticles;
    }
}




