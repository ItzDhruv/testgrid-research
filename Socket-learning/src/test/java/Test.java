import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Test {
     public static void main(String[] args) throws IOException {
         System.out.println("Enter num");
         BufferedReader readX = new BufferedReader(new InputStreamReader(System.in));
         int x = Integer.parseInt(readX.readLine());
         System.out.println("Your num is"+x);
    }
}

