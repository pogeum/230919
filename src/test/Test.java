package test;


public class Test {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.setaRepository(new BRepository());


    }
}

class Controller {
        Repository aRepository;

        public void setaRepository(Repository a) {
            aRepository = a;
        }
}

class Repository {

}

class ARepository extends Repository{

}

class BRepository extends Repository{

}
