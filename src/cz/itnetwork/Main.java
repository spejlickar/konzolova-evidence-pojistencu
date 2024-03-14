package cz.itnetwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean a = scanner.hasNext();
        System.out.println(a);
        while(scanner.hasNext()) {
            System.out.println("Token: " + scanner.next());
        }
    }
}
