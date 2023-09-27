package Article.view;

public class PageUnder {

    public PageUnder(int last, int pgnow) { //last가 현재페이지 articlelist의 마지막인덱스번호

        int underindex = (last) / 15;
        int under = (5 * underindex) + 1;

        for (int i = under; i < under + 5; i++) { //
            if (i == pgnow) {
                System.out.print(" [" + i + "]");
            } else {
                System.out.print(" " + i);
            }
        }
        System.out.print("\n");

    }
}
