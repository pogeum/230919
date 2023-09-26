package Article.view;

import Article.model.Article;

import java.util.ArrayList;

public class PageView {

    ArticleView articleView = new ArticleView();//함수실행하는객체,.,
    // int i = 0;


    public void printPage(int pagenum,ArrayList<Article> list){
       // this.pageNow = num;//num은시작 인덱스값. 페이지수랑 조정 해야댐.
        Article article;

        for(int i= 3 * (pagenum-1); i <= i+2 ; i++){ //이게..repository index번호로 돼야하는데
            article = list.get(i);
            articleView.printArticlePage(article);


        }
    }

}
