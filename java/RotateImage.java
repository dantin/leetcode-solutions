public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = i; j < row - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - j][i];
                matrix[row - 1 - j][i] = matrix[row - 1 - i][row - 1 - j];
                matrix[row - 1 - i][row - 1 - j] = matrix[j][row - 1 - i];
                matrix[j][row - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        print(matrix);

        RotateImage solution = new RotateImage();
        solution.rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

    }
}