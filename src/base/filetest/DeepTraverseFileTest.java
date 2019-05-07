package base.filetest;

import java.io.File;

public class DeepTraverseFileTest {
    public static void main(String[] args) {
        File file = new File("G:\\VS插件");
        int level=0;
        ListAll(file,level);
    }

    private static void ListAll(File file,int level) {
        System.out.println(InsertSpace(level)+ file.getPath());
        level++;
        File[] files = file.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) {
                    ListAll(f,level);
                } else
                    System.out.println(InsertSpace(level)+f.getPath());
            }
    }

    private static String InsertSpace(int level) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }
}
