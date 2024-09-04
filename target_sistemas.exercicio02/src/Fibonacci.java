public class Fibonacci {

    public static boolean pertenceFibonacci(int numero){
        int a = 0, b = 1;

        while (a <= numero){
            if (a == numero){
                return true;
            }
            int temporaria = a;
            a = b;
            b = temporaria + b;
        }
        return false;
    }
}
