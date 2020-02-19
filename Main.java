package com.company;

import java.io.File;
import java.io.IOException;

public class Main {
    static String path = "";
    static int fileLength = 1651;
    static long count;

    public static void main(String[] args) {
        delPNG(path);

        System.out.println("Deleted " + count + " pcs");
    }

    private static void delPNG(String path){
        File dir = new File(path);
        File[] list = dir.listFiles();

        if(list == null) {
            System.out.println("The directory (" + path + ") is empty");
            return;
        }

        for(File f : list){
            if(f.isFile()){
                long len = f.length();
                if(len == fileLength){
                    f.delete();
                    count++;
                }
            }else {
                try {
                    delPNG(f.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
