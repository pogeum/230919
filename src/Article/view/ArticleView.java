package Article.view;

import Article.model.Article;
import Article.model.CommentRepository;
import Article.view.CommentView;

import java.util.ArrayList;

public class ArticleView {

    CommentView cmtv = new CommentView();
    public void printArticleDetail(Article article) { // 함수임 상세보기 조회수랑 다나오는거
        System.out.println("=============================");
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());
        System.out.printf("조회수 : %d\n", article.getHit());
        System.out.printf("등록일 : %s\n", article.getRegDate());
        System.out.printf("작성자 : %d\n", article.getWriter());

        article.viewComment();
        //cmtv.printComments();


        System.out.println("===================");
    }

    public void printArticles(ArrayList<Article> list) { //함수임 목록보기
        System.out.println("==================");
        for (int i = 0; i < list.size(); i++) {

            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.printf("등록날짜 : %s\n", article.getRegDate());

            System.out.println("==================");
        }
    }

}
