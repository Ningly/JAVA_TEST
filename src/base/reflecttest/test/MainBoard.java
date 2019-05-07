package base.reflecttest.test;

public class MainBoard {
    public void run(PCI pci){
        pci.open();
        pci.close();
    }
}
