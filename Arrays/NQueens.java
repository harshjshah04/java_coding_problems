// Recursion

public class NQueens {
    static int N = 5;

    public static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i=row, j=col; i>=0 && j<N; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void solve(char[][] board, int row) {
        if (row == N) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("Solution:");
        for (char[] row : board) {
            for (char ch : row) System.out.print(ch + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) board[i][j] = '.';
        solve(board, 0);
    }
}
