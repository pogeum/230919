package Article.model;

import java.util.ArrayList;

public class UserRepository {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

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

    public LoginUser finduserbyId(String id, String pw) {

        User user = null; //이거 널 안될때도 잇고.. 걍 생ㅅ어자랑 public붙인거랑 뭐달라
        User target = null;
        LoginUser loginUser = null;
//        System.out.print("여기실행됏나\n");
        for(int i =0;i<users.size();i++){
            user = users.get(i);
            if((user.getID().equals(id))&&(user.getPassword().equals(pw))){
                target = user;
                loginUser = new LoginUser(target);
//                ac.setLoginUser(loginUser);
                System.out.printf("%s 님 환영합니다!\n\n", loginUser.getLoginuser().getNickname());

                //LoginUser loginUser = new LoginUser(target);
                //System.out.print(loginUser.getLoginuser().getNickname());

            }

        }
        if (target == null){
            System.out.println("회원정보가 없습니다.\n");
        }

        return loginUser;

    }
}
