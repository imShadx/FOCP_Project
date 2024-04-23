import java.util.*;
public class Main {
    public static void main(String[] args) {
        passGenerate G = new passGenerate();
        howStrong S = new howStrong();

        int n;

        System.out.println("Press '1' to Generate a password");
        System.out.println("Press '2' to check your password's strength");

        Scanner H = new Scanner(System.in);

        n = H.nextInt();

        switch(n){
            case 1: G.Generate();
                break;
            case 2: S.Strength();
                break;
            default:
                System.out.println("Please enter a valid input");
        }
    }
}
