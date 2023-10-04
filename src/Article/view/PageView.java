package Article.view;

import Article.model.Article;

import java.util.ArrayList;

public class PageView {

    ArticleView articleView = new ArticleView();//함수실행하는객체,.,
    // int i = 0;
    public int printPage(int pagenum, ArrayList<Article> list) {
        Article article;

        int itemCountPerPage = 3;

        int j = itemCountPerPage * (pagenum - 1);

        if (j + 2 > (list.size() - 1)) {
            for (int i = j; i < list.size(); i++) {
                article = list.get(i);
                articleView.printArticlePage(article);

            }
        } else {
            for (int i = j; i <= j + 2; i++) {
                article = list.get(i);
                articleView.printArticlePage(article);
            }
        }
        return j;
    }

}


