package base.otherapi;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args){
        Runtime runtime=Runtime.getRuntime();
        try {
            runtime.exec("services.msc");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
