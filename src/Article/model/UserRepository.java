package Article.model;

import Article.model.User;


import java.util.ArrayList;

public class UserRepository {

    ArrayList<User> users = new ArrayList<>();

    public UserRepository(){
        User p1 = new User("hong","gildong","홍길동");
        User p2 = new User("lee","soonsin","이순신");
        User p3 = new User("kim","chulsoo","김철수");
        users.add(p1);
        users.add(p2);
        users.add(p3);
    }

    public void insertuser(User a){
        users.add(a);
    }

/*
    public void out() {
        System.out.printf("%s\n", users.get(0).getID());
        System.out.printf("%s\n", users.get(0).getPassword());
    }
*/

    public void finduserbyId(String id, String pw) {

        User user = null; //이거 널 안될때도 잇고.. 걍 생ㅅ어자랑 public붙인거랑 뭐달라
        User target = null;
//        System.out.print("여기실행됏나\n");
        for(int i =0;i<users.size();i++){
            user = users.get(i);
            if((user.getID().equals(id))&&(user.getPassword().equals(pw))){
                System.out.printf("%s 님 환영합니다!\n\n", user.getNickname());
                target = user;
            }



            /*System.out.printf("%s %s %s", user.getID(),user.getPassword(),user.getNickname());

             문자열 비교를 == 연산자를 사용하여 하고 있습니다.
             이렇게 하면 문자열이 동일한지 비교하지 않고 문자열의 참조(reference)를 비교하게 됩니다.
             문자열은 객체이며 == 연산자로 비교하면 두 문자열이 동일한 객체를 참조하는지 확인합니다.
             따라서 문자열 값이 같더라도 서로 다른 객체일 수 있으므로
             이러한 비교는 예상대로 동작하지 않을 수 있습니다.

            if(id == user.getID() && pw == user.getPassword()) {
                System.out.printf("%s 님 환영합니다!\n", user.getNickname());
                target = user;

            }*/


        }
        if (target == null){
            System.out.println("회원정보가 없습니다.\n");
        }

    }
}
