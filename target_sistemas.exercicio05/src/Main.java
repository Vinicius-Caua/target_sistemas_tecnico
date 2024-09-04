import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scan.nextLine();
        String palavraInversa = "";

        for (int i = palavra.length() - 1; i >= 0; i--){
            palavraInversa += palavra.charAt(i);
        }
        System.out.println(palavraInversa);
    }
}