package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Cartesian {
    private static HashMap<String,String> nameMap = new HashMap();
    static {
        nameMap.put("1", "");
        nameMap.put("2", "a,b,c");
        nameMap.put("3", "d,e,f");
        nameMap.put("4", "g,h,i");
        nameMap.put("5", "j,k,l");
        nameMap.put("6", "m,n,o");
        nameMap.put("7", "p,q,r,s");
        nameMap.put("8", "t,u,v");
        nameMap.put("9", "w,x,y,z");
        nameMap.put("0", "");
    }
    public static void main(String[] args){
        while(true) {
            String str = input();
            boolean check = check(str);
            if(!check){
                continue;
            }
            output(str);
        }
    }

    private static String input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the number 0-99 return Cartesian product：");
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I/O error！");
        }
        return str;
    }

    private static boolean check(String str){
        if(str == null || str.equals("")){
            return false;
        }
        boolean bl = true;
        char[] c = str.toCharArray();
        for(char single : c){
            if (!Character.isDigit(single)) {
                bl = false;
                break;
            }
        }
        if (!bl) {
            System.out.println("Illegal input");
            return false;
        }
        if(c.length>2){
            System.out.println("Please enter the number 0-99");
            return false;
        }
        return true;
    }

    private static void output(String str){
        char[] c = str.toCharArray();
        if(c.length==1){
            String[] result = nameMap.get(String.valueOf(c[0])).split(",");
            for (String i : result) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        if(c.length==2){
            String[] aa = nameMap.get(String.valueOf(c[0])).split(",");
            String[] bb = nameMap.get(String.valueOf(c[1])).split(",");
            for (String one : aa) {
                for (String two : bb) {
                    System.out.print(one+two+"\t");
                }
            }
            System.out.println();
        }
    }
}
