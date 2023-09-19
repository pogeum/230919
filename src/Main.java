import Article.controller.BoardApp;
//alt + enter : 함수자동호출??
//핵심 로직을 main 메서드에 작성하지 않응다. 클래스를 따로 만듦.

//    static 안쓰도록?
public class Main {

    // 밑에 메인함수에 스태틱 붙여서 다른거도 다 붙인건데 웬만함녀 붙이지 말기.
    public static void main(String[] args) {
        BoardApp app = new BoardApp();
        app.start();


    }
}
