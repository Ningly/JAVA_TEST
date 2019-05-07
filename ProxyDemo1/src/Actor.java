public class Actor implements IActor {
    @Override
    public void act(float money) {
        System.out.println("act");
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("dangerAct");
    }
}
