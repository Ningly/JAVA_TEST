package base.filetest;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FilenameFilterTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/");
        if (file != null)
            for (String str : file.list((dir, name) -> {
                if(name.endsWith(".txt")||name.endsWith(".zip"))
                    return true;

                return false;
            })) {
                System.out.println(str);
            }

        System.out.println("===========================");
        File[] files=file.listFiles(new SuffixFile(".txt"));
        for (File f:
             files) {
            System.out.println(f);
        }
    }
}


class SuffixFile implements FileFilter{
    private String suffix;

    public SuffixFile(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getPath().endsWith(suffix);
    }
}
