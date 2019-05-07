package base.reflecttest.test;

public class VideoCard implements PCI {
    @Override
    public void open() {
        System.out.println("VideoCard open");
    }

    @Override
    public void close() {
        System.out.println("VideoCard close");
    }
}
