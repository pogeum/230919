package Article.view;

import Article.model.Article;
import Article.model.ArticleRepository;

import java.util.ArrayList;

public class ArticleView {

    public void printArticleDetail(Article article) { // 함수임 상세보기 조회수랑 다나오는거

        System.out.println("=============================");
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());
        System.out.printf("조회수 : %d\n", article.getHit());
        System.out.printf("등록일 : %s\n", article.getRegDate());
        System.out.printf("작성자 : %s\n", article.getWriter());
        if(article.getLike() == 0){
            System.out.printf("좋아요 : ♡ 0\n");
        } else {
            System.out.printf("좋아요 : ♥ %d\n",article.getLike());
        }

    }

    public void printArticles(ArticleRepository articleRepository){

        articleRepository.printArticlelist();

    }

    public void printArticlePage (Article article) { // 함수임 상세보기 조회수랑 다나오는거
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("조회수 : %d\n", article.getHit());
        if(article.getLike() == 0){
            System.out.printf("좋아요 : ♡ 0\n");
        } else {
            System.out.printf("좋아요 : ♥ %d\n",article.getLike());
        }
        System.out.println("===================");
    }

}
