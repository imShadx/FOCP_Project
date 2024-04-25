//import java.util.*;
//import java.util.regex.*;
//
//public class passGenerate {
//    public String pass;
//    public int len;
//    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    String lower ="abcdefghijklmnopqrstuvwxyz";
//    String num="1234567890";
//    String special="<>@#$&*!";
//    void Generate() {
//
//        Scanner S =new Scanner(System.in);
//
//        String combination = upper+lower+num+special;
//
//        System.out.println("Enter the length of your password:");
//        len = S.nextInt();
//
//        if(len<5 || len>15){
//            System.out.println("The password length must be between 5 and 15");
//            System.exit(0);
//        }
//
//        char[] password = new char[len];
//
//        Random r = new Random();
//
//        for(int i=0;i<len;i++){
//            password[i]=combination.charAt(r.nextInt(combination.length()));
//        }
//        pass = new String(password);
//    }
//}
