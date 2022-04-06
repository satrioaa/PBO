package week4;

public class Matrix {
    private final double[][] data;
    private int M;
    private int N;

    private Matrix(int m, int n) {
        this.M = m;
        this.N = n;
        this.data = new double[m][n];
    }

    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.data[i][j] = data[i][j];
    }

    private Matrix(Matrix A) {
        this(A.data);
    }

    public static Matrix random(int m, int n) {
        Matrix A = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A.data[i][j] = Math.random();
            }
        }
        return A;
    }

    public static Matrix identity(int n) {
        Matrix I = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            A.data[i][i] = 1;
        }
        return I;
    }

    // swap rows i and j
    void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A.data[j][i] = data[i][j];
            }
        }
        return A;
    }

    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N)
            throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                C.data[i][j] = A.data[i][j] + B.data[i][j];
            }
        }
        return C;
    }

    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N)
            throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                C.data[i][j] = A.data[i][j] - B.data[i][j];
            }
        }
        return C;
    }

    public boolean equals(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N)
            throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A.data[i][j] != B.data[i][j])
                    return false;
            }
        }
        return true;
    }

    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M)
            throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++) {
            for (int j = 0; j < C.N; j++) {
                for (int k = 0; k < A.N; k++) {
                    C.data[i][j] += A.data[i][k] * B.data[k][j];
                }
            }
        }
        return C;
    }

    public Matrix solve(Matrix rhs) {
        if (M != N || rhs.M != N || rhs.N != 1)
            throw new RuntimeException("Illegal matrix dimensions.");

        Matrix A = new Matrix(this);
        Matrix b = new Matrix(rhs);

        for (int i = 0; i < N; i++) {
            int max = i;
            for (int j = i + 1; j < N; j++) {
                if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
                    max = j;
            }
            A.swap(i, max);
            b.swap(i, max);

            if (A.data[i][i] == 0)
                throw new RuntimeException("Matrix is singular.");

            for (int j = i + 1; j < N; j++) {
                double m = A.data[j][i] / A.data[i][i];
                for (int k = i; k < N; k++) {
                    A.data[j][k] -= A.data[i][k] * m;
                }
                A.data[j][0] -= b.data[i][0];
            }
        }

        Matrix x = new Matrix(N, 1);
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < N; j++) {
                sum += A.data[i][j] * x.data[j][0];
            }
            x.data[i][0] = (b.data[i][0] - sum) / A.data[i][i];
        }
        return x;
    }

    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }
}

class MatrixAksi {
    private static final Matrix B = null;
    private static Matrix A;

    public static void main(String[] args) {
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
        Matrix D = new Matrix(d);
        D.show();
        System.out.println();

        A.swap(1, 2);
        A.show();
        System.out.println();

        System.out.println(A.times(B).equals(B.times(A)));
        System.out.println();

        Matrix b = Matrix.random(5, 1);
        b.show();
        System.out.println();

        Matrix x = A.solve(b);
        x.show();
        System.out.println();

        ((Matrix) A.times(x)).show();

    }
}