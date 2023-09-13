import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    ArrayList<Article> articles = new ArrayList<>();
//    ArrayList<Comment> comments = new ArrayList<>();
    public void start() {


        Article a1 = new Article("안녕하세요 반갑습니다. 자바 공부중이에요", "냉무", 1);
        Article a2 = new Article("자바질문좀", "무무무", 2);
        Article a3 = new Article("정처기따야되냐", "아아아", 3);

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);


        Scanner scan = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> contents = new ArrayList<>();
        // ArrayList<Article> articles = new ArrayList<>();
        //articles : 객체배열 명
        //배열에 객체저장하는거
        int lastArticleId = 4;

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
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    printOut(article);
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

                    article.setTitle(newTitle);
                    article.setContent(newTitle);
                    //Article newArticle = new Article(newTitle, newContent, targetId);
                    //수정한거 another객체로 또다시만들어서 .이케안하고위에처럼해도됨.
                    //articles.set(index, newArticle);// 원래 articles배열에 껴넣기.
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

                    //articles.remove(index);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetId);
                    //위치기반삭제 : 인덱스로 지우는..
                    //값기반삭제
                    articles.remove(article); // r괄호속 article참조변수가 가리키는 값 삭제함.
                }

                // index -> 0부터 시작하기 때문에 0보다 작으면 안됨
                // 내가 가지고 있는 데이터의 개수 - 1 보다 크면 안됨


            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = scan.nextInt();

                boolean isExist = false;

                Article article = findById(targetId);

                if (article == null) {
                    System.out.print("없는 게시물입니다.");
                } else {
                    //article.setView();
                    printOut(article);
                    article.setView(article.getView() + 1);
                    System.out.printf("조회수 : %d\n", article.getView());
                    System.out.printf("댓글 목룍 : \n");
                    article.viewComment();


                }
                System.out.print("상세보기 기능을 선택해주세요.\n");
                System.out.print("1.댓글등록 / 2.추천 / 3.수정 / 4.삭제 / 5.목록으로 : ");
                int choose = scan.nextInt();

                if (choose == 1) {
                    System.out.print("댓글 달기 : ");
                    String sentences;
                    scan.nextLine();
                    sentences = scan.nextLine();

                    article.addcomment(sentences);
                    System.out.print("댓글이 등록 되었습니다.\n");
                }

            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해 주세요 : ");
                String keyword = scan.nextLine();

                ArrayList<Article> keywordList = new ArrayList<>();
                Article target = null;
                int j = 0;

                for (int i = 0; i < articles.size(); i++) {
                    //String title = articles.get(i).getTitle();

                    Article article = articles.get(i);
                    String title = article.getTitle();
                    //contains ->  true, false를반환하는 함수.

                    boolean contains = title.contains(keyword);

                    if (contains) {
                        // printOut(article);
                        keywordList.add(article);
                       /* target = article;
                    //굳이 이렇게 안 하고 바로 여기서 시세템아웃 출력 해도됨....아 그러네;; ㅅㅂ
                    //내가하려던건왜안됏던건지 알아내기.ㅇㅇ이제활용가능
                        keywordList.add(j, target);
                        j++;*/
                    }
                }

                //printarticles (0 인수 어레이리스트로 받고 위에꺼 함수에넣기.
                //코드가 이원화 돼잇으면 똑같은건데 다르게 출력됨 -> 버그래.

                /*System.out.print("===================================\n");
                for (int i = 0; i < keywordList.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("=============================\n");
                }*/
            }
        }

    }
    public Article findById(int id) {
        //int index;
        Article target = null;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
                break;
              //  index = i;
            }
        }
        return target;
    }


    public void findByKeyword(String word) {
        ArrayList<Article> keyword = new ArrayList<>();
        Article target = null;
        int j = 0;
        //단어포함된 객체 또 따로 객체배열로 저장햇음

        for (int i = 0; i < articles.size(); i++) {
            //String title = articles.get(i).getTitle();

            Article article = articles.get(i);
            String title = article.getTitle();

            boolean contains = title.contains(word);

            if (contains) {
                target = article;

                keyword.add(j, target);
                j++;
            }


        }

    }

    //printOut 인수 어레이리스트로 받도록해서 다시 응용해보기.add.
    public void printOut(Article a) {
        System.out.println("=================================\n");
        System.out.printf("번호 : %d\n", a.getId());
        System.out.printf("제목 : %s\n", a.getTitle());
        System.out.printf("내용 : %s\n", a.getContent());
        System.out.printf("등록날짜 : %s\n", a.getCurrentTime());
    }

//    public void viewComment(Article a) {
//        for (int i = 0; i < comments.size(); i++) {
//            a.getCp(); //-> 코멘트객체반환
//
//            System.out.printf("%s\n",a.getCp());
//        }
//    }
//
//    public void addcomment(Article article, String rrr) {
//        article.setComment(rrr);
//        comments.add(article.getCp());
//    }

/*
    public static void viewComment(Article a){

        Comment comments = new Comment();
        System.out.print("=================================\n");
        System.out.print("<댓글>\n");
        System.out.printf("댓글 내용 : %s", a.);


    }
    public void postComment(String sentence){
        //이함수가 호출되면 댓글겍체포인터 같이 생성되도록,.,어케함r근데 해당게시물객체랑 연결해야되는데
        Comment comments = new Comment();
        comments.setSentence(sentence);
    }
*/



}

