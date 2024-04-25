//import java.util.*;
//import java.util.regex.*;
//
//public class howStrong {
//    String pass;
//
//    void Strength() {
//        Scanner S = new Scanner(System.in);
//        System.out.println("Enter your password: ");
//        pass = S.next();
//        if (pass.length() > 15 || pass.length() < 5) {
//            System.out.println("The password must be between 5 and 15 characters");
//        }
//        else{
//
//
//            Pattern upperCase = Pattern.compile("[A-Z]");
//            Pattern numbers = Pattern.compile("[0-9]");
//            Pattern special = Pattern.compile("[^A-Za-z0-9]");
//
//            Matcher upper = upperCase.matcher(pass);
//            Matcher number = numbers.matcher(pass);
//            Matcher spec = special.matcher(pass);
//
//            boolean a = upper.find();
//            boolean b = number.find();
//            boolean c = spec.find();
//
//            if (a && b && c) {
//                System.out.println("The password looks strong");
//            } else {
//                if ((a && b) || (b && c) || (c && a)) {
//                    System.out.println("The password strength is average");
//                } else {
//                    System.out.println("The password seems pretty weak");
//                }
//            }
//
//            if(!a){
//                System.out.println("Try adding some uppercase letters");
//            }
//            if(!b){
//                System.out.println("Try adding some numbers");
//            }
//            if(!c){
//                System.out.println("Try adding some special characters");
//            }
//
//        }
//    }
//}