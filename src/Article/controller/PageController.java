package Article.controller;

import Article.model.Article;
import Article.model.ArticleRepository;
import Article.view.PageUnder;
import Article.view.PageView;

import java.util.ArrayList;
import java.util.Scanner;

public class PageController {
    Scanner scan = new Scanner(System.in);
    PageView pageView = new PageView();//메서드 실행 위한 객체?포인터?참조변수? 정의.

    private ArrayList<Article> articles = new ArrayList<>();
    //private ArticleRepository articleRepository;
    public void setArticleRepository(ArticleRepository articleRepository) {
        //this.articleRepository = articleRepository;
        this.articles = articleRepository.findAllArticles();
        //여기서 사이즈 3배수로 세팅?노노.
    }

   // ArrayList<Article> articles = articleRepository.findAllArticles(); //여기서 articleRepository가 null이라는데
    /*public PageController(){
        articles = articleRepository.findAllArticles();
    }*/
    private int pageNow = 1;
    private int last;
   /* public int getPageNow() {
        return pageNow;

    }*/

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }




    public void paging(){
        pageView.printPage(pageNow,articles);
        PageUnder pageUnder = new PageUnder(3,pageNow);

        while(true){
            System.out.print("페이징 명령어를 입력해주세요 (1.이전 2.다음 3.선택 4.뒤로가기) : ");
            int select = scan.nextInt();

            if(select==1){
                if(pageNow==1){
                    System.out.print("첫 번째 페이지 입니다.\n");
                } else {
                    int num = pageNow-1;
                    setPageNow(num);
                    this.last = pageView.printPage(pageNow,articles);
                    PageUnder pageUnder1 = new PageUnder(last,pageNow);
                }
            }
            if (select==2) {
                int compare = articles.size();

                if(this.last == compare-1){
                    System.out.print("마지막 페이지 입니다.\n");
                }else {
                    int num = pageNow+1;
                    setPageNow(num);
                    this.last = pageView.printPage(pageNow,articles);
                    PageUnder pageUnder2 = new PageUnder(last,pageNow);
                }

            }
            if (select==3) {
                System.out.print("이동하실 페이지 번호를 입력하세요 : ");
                int num = scan.nextInt();
                setPageNow(num);
                this.last = pageView.printPage(pageNow,articles);
                PageUnder pageUnder3 = new PageUnder(last,pageNow);
            }
            if (select==4) {
                break;
            }
        }
    }
}
