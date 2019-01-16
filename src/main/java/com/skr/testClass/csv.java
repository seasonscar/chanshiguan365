package com.skr.testClass;

import java.io.*;

public class csv {
    public static void main(String[] args) throws IOException {
        String url="D:\\tubiao.csv";
        File temp=new File(url);
        InputStreamReader isr=new InputStreamReader(new FileInputStream(temp),"GBK");
        BufferedReader br = new BufferedReader(isr);
        String str="";
        String currentName="";
        StringBuffer sb=new StringBuffer();
        try{
        while((str=br.readLine())!=null){
            String[] line=str.split(",");
            if(1983<Integer.parseInt(line[1])&&Integer.parseInt(line[1])<2010){
            if(!currentName.equals(line[0])){
                currentName=line[0];
                if(sb.lastIndexOf(",")!=-1){
                     sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("]},{name:'");
                sb.append(currentName);
                sb.append("',data:[");
                sb.append(line[2]+",");
            }else{
                sb.append(line[2]+",");
            }
            }
        }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("]}");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(str);
        }
        System.out.println(sb.substring(3));

    }
}

//    {name: '安装，实施人员',data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]},
//    {name: '工人',data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]},
//            {
//        name: '销售',
//                data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
//    }, {
//        name: '项目开发',
//                data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
//    }, {
//        name: '其他',
//                data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
//    }
