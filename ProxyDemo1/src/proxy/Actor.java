package proxy;

public class Actor implements IAct {
    @Override
    public void basicAct(float money) {
        System.out.println("basicAct");
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("dangerAct");
    }
}
