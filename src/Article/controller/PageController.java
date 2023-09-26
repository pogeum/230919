package Article.controller;

import Article.model.Article;
import Article.model.ArticleRepository;
import Article.view.ArticleView;
import Article.view.PageView;

import java.util.ArrayList;
import java.util.Scanner;

public class PageController {
    Scanner scan = new Scanner(System.in);
    PageView pageView = new PageView();//함수실행객체
    //ArticleView articleView = new ArticleView(); //함수실행하는객체 아마이건 pageview에서 쓰일거같음
    private ArticleRepository articleRepository;
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    private int pageNow = 1;
    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    ArrayList<Article> articles = articleRepository.findAllArticles();


    public void paging(){
        pageView.printPage(pageNow,articles);

        while(true){
            System.out.print("페이징 명령어를 입력해주세요 (1.이전 2.다음 3.선택 4.뒤로가기) : ");
            int select = scan.nextInt();

            if(select==1){
                if(pageNow==1){
                    System.out.print("첫 번째 페이지 입니다.\n");
                } else {
                    int num = pageNow-1;
                    setPageNow(num);
                    pageView.printPage(pageNow,articles);
                }
            }
            if (select==2) {
                int num = pageNow+1;
                setPageNow(num);
                pageView.printPage(pageNow,articles);
            }
            if (select==3) {
                System.out.print("이동하실 페이지 번호를 입력하세요 : ");
                int num = scan.nextInt();
                setPageNow(num);
                pageView.printPage(pageNow,articles);
            }
            if (select==4) {
                break;
            }
        }
    }
}
