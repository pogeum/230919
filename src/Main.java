import com.sun.management.GarbageCollectionNotificationInfo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int index = 0;
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> contents = new ArrayList<>();
        // ArrayList<Article> articles = new ArrayList<>();
        //articles : 객체배열 명
        //배열에 객체저장하는거
        int lastArticleId = 1;

        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                //contents.add(scan.nextLine());
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                //contents.add.(scan.nextLine());
                String content = scan.nextLine();

                Article article = new Article(title, content, lastArticleId);
                lastArticleId++;
                //new 객체생성 : 변수명은 article
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");
            } else if (command.equals("list")) {
                System.out.println("==============================");

                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("=============================");
                }
//추가 삭제 하면서 게시물객체 인덱스 자꾸 변함..또 배열 루프돌려서 변수명(게시물번호) 일치하는지 해서 찾음..


            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호  : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                Article article = findById(targetId);// findbyid 함수로 찾은 객체를 article에 저장.
                if (article == null) {
                    System.out.print("없는 게시물입니다.");
                } else {
                    System.out.print("제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.print("내용 : ");
                    String newContent = scan.nextLine();

                    Article newArticle = new Article(newTitle, newContent, targetId);
                    //수정한거 another객체로 또다시만들어서
                    articles.set(index, newArticle);// 원래 articles배열에 껴넣기.
                    System.out.println("수정이 완료되었습니다.");
                }





                //arraylist삭제 ->remove


            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                Article article = findById(targetId);

                if (article == null) {
                    System.out.print("없는 게시물입니다.");
                } else {

                    articles.remove(index);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetId);
                }

                // index -> 0부터 시작하기 때문에 0보다 작으면 안됨
                // 내가 가지고 있는 데이터의 개수 - 1 보다 크면 안됨


            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                boolean isExist = false;

                Article article = findById(targetId);

                if (article == null) {
                    System.out.print("없는 게시물입니다.");
                } else {
                    System.out.print("===================================\n");
                    System.out.printf("번호 : %d\n", targetId);
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.printf("등록날짜 : %s\n", article.getCurrentTime());
                }
            }
            else if (command.equals("search")){

            }


        }
    }

    public static Article findById(int id) {

        Article target = null;


        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
                index = i;
            }
        }


        return target;
    }


}
