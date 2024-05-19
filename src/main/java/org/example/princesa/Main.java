package org.example.princesa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int c = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();

        int cf = scanner.nextInt();
        int cm = scanner.nextInt();

        int[] dragones = new int[d];
        for (int i = 0; i < d; i++) {
            dragones[i] = scanner.nextInt();
        }

        for (int i = 0; i < s; i++) {
            int ci = scanner.nextInt();
            int sendero_cf = scanner.nextInt();
            int l = scanner.nextInt();
        }
    }
}