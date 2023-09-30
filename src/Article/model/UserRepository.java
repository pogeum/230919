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

    public User finduserbyId(String id, String pw) {

        User user = null;
        User target = null;
        for(int i =0;i<users.size();i++){
            user = users.get(i);
            if((user.getID().equals(id))&&(user.getPassword().equals(pw))){
                target = user;
                System.out.printf("%s 님 환영합니다!\n\n", target.getNickname());
            }
        }
        if (target == null){
            System.out.println("회원정보가 없습니다.\n");
        }

        return target;

    }
}
