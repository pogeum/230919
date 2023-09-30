package Article.model;

import java.util.ArrayList;

public class LikeRepository {
    ArrayList<Like> likerepository = new ArrayList<>();

    public void insert(Like like){
        likerepository.add(like);
    }

    public LikeRepository getLikerepository(){

        return this;
    }

    public Like findbyNick(String nickname){
        Like target=null;
        for(int i = 0;i<likerepository.size();i++){
            String compare=likerepository.get(i).getUsernickname();
            if(nickname.equals(compare)){
                target = likerepository.get(i);
            }
        }
        return target;
    }

}
