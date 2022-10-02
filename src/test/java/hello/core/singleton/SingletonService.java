package hello.core.singleton;

public class SingletonService {

    //static 영역에 자기 자신으로 객체 instance 를 미리 생성
    private static final SingletonService instance = new SingletonService();

    //오직 getInstance()메서드를 통해서만 호출 가능
    public static SingletonService getInstance() {
        return instance;
    }

    //다른 곳에서 생성하지 못하도록 private 생성자 사용
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
