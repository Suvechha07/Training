import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        
        System.out.print("Enter the first string into an array: ");
        String X = in.nextLine();

        System.out.print("Enter the second string into an array: ");
        String Y = in.nextLine();

        
        int[][] L = computeLcsTable(X, Y);
        String lcs = constructLcs(X, Y, L);

        
        System.out.println("LCS: " + lcs);
        System.out.println("LCS Length: " + lcs.length());
    }

    
    private static int[][] computeLcsTable(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] L = new int[m + 1][n + 1];

        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L;
    }

   
    private static String constructLcs(String X, String Y, int[][] L) {
        StringBuilder lcs = new StringBuilder();
        int i = X.length();
        int j = Y.length();

        
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

      
        return lcs.reverse().toString(); 
    }
}
