package base.filetest;

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {
    public static void main(String[] args) {
        File dir = new File("G:\\VS插件");
        File destFile=new File("d:/a.txt");
//        FilenameFilter filter= (dir, name) -> name.endsWith(".vsix");
        FilenameFilter filter=new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".vsix");
            }
        };
        ArrayList<String> list=new ArrayList<>();
        getAllList(dir, filter, list);
        write2File(list,destFile);
    }

    private static void write2File(ArrayList<String> list, File destFile) {
        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new FileWriter(destFile));
            for (String str :
                    list) {
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void getAllList(File dir, FilenameFilter filter, ArrayList<String> list) {
        File[] files=dir.listFiles(filter);
        for (File f :
                files) {
            if (f.isDirectory()){
                getAllList(dir, filter, list);
            }
            else {
                if(filter.accept(dir,f.getAbsolutePath())){
                    list.add(f.getAbsolutePath());
                }
            }
        }
    }


}


