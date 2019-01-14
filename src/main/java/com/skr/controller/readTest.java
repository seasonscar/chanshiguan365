package com.skr.controller;

import java.io.*;

public class readTest {
    public static void main(String[] args) {
        File f=new File("D://test/lkm.fs00.fs00");
        try {
            FileInputStream fi=new FileInputStream(f);
            InputStreamReader is=new InputStreamReader(fi);
            BufferedReader br=new BufferedReader(is);
            int i=0;
            while(br.readLine()!=null){
                i++;
                System.out.println(i+"=="+br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
