import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixChainMultiplication {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of matrices: ");
        int n = Integer.parseInt(br.readLine());

        int[] dimensions = new int[n + 1];
        int[][] M = new int[n][n];
        int[][] S = new int[n][n];

        // Input dimensions and validate compatibility
        for (int i = 0; i < n; i++) {
            System.out.print("Enter row and col size of A" + (i + 1) + ": ");
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            if (i == 0) {
                dimensions[i] = row;
            } else if (dimensions[i] != row) {
                System.out.println("Error: Incompatible matrix dimensions.");
                return;
            }
            dimensions[i + 1] = col;
        }

        // Calculate M-table and S-table using dynamic programming
        for (int len = 2; len <= n; len++) { // len is the chain length
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                M[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = M[i][k] + M[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (q < M[i][j]) {
                        M[i][j] = q;
                        S[i][j] = k;
                    }
                }
            }
        }

        // Output M table
        System.out.println("M Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    System.out.print("  0 ");
                } else {
                    System.out.printf("%5d ", M[i][j]);
                }
            }
            System.out.println();
        }

        // Output S table
        System.out.println("S Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    System.out.print("   0");
                } else {
                    System.out.printf("%5d ", S[i][j] + 1);
                }
            }
            System.out.println();
        }

        // Output optimal parenthesization and scalar multiplications
        System.out.print("Optimal parenthesization: ");
        printOptimalParenthesization(S, 0, n - 1);
        System.out.println();
        System.out.println(
                "The optimal ordering of the given matrices requires " + M[0][n - 1] + " scalar multiplications.");
    }

    // Recursive function to print optimal parenthesization
    private static void printOptimalParenthesization(int[][] S, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParenthesization(S, i, S[i][j]);
            printOptimalParenthesization(S, S[i][j] + 1, j);
            System.out.print(")");
        }
    }
}