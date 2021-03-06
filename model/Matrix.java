package model;

import java.io.*;  
import java.util.Scanner;  
import java.lang.Math;


public class Matrix 
{  
    public interface EachElement
    {
        double callback(double element);
    }
    public int rows;
    public int columns;
    public double matrix[][];

    public Matrix() {}

    public Matrix(String filename)
    {
        try {
            InputStream in = getClass().getResourceAsStream(filename);
            Scanner sc = new Scanner(in);  
            sc.useDelimiter(",|\\n");

            rows = sc.nextInt();
            columns = sc.nextInt();

            matrix = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
        sc.close();
        } catch(Exception e) {
            System.out.println(e);
            System.out.println("exiting from exception");
            System.exit(1);
        }
    }


    public Matrix(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    public Matrix(double matrix[][], int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    public Matrix(Scanner sc, int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        matrix = new double[rows][columns];
        for (int i = 0; i < 784; i++) {
            int got = sc.nextInt();
            matrix[i][0] = got;
            matrix[i][0] /= 255.0;
        }
    }

    public Matrix map(EachElement apply)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = apply.callback(matrix[i][j]);
            }
        }
        return this;
    }

    public Matrix dot(Matrix right)
    {
        assert columns == right.rows
            : "left columns do not equal right rows for matrix multiplication" + 
              " (" + rows + "x" + columns + "), " + 
              " (" + right.rows + "x" + right.columns + ")";

        Matrix result = new Matrix(rows, right.columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < right.columns; j++) {
                for (int k = 0; k < columns; k++) {
                    result.matrix[i][j] += matrix[i][k] * right.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Matrix add(Matrix right)
    {
        assert rows == right.rows && columns == right.columns
            : "Matrices are not the same dimensions for matrix addition" +
              " (" + rows + "x" + columns + "), " + 
              " (" + right.rows + "x" + right.columns + ")";

        Matrix result = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = matrix[i][j] + right.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix sigmoid()
    {
        Matrix result = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = 1.0 / (1.0 + Math.exp(-matrix[i][j]));
            }
        }
        return result;
    }

    // returns the index of the row with largest value
    public int maxRow()
    {
        double maxValue = -1.0;
        int rowIndexOfMax = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    rowIndexOfMax = i;
                }
            }
        }
        return rowIndexOfMax;
    }

    public void printSize()
    {
        System.out.println("(" + rows + "x" + columns + ")");
    }

    @Override
    public String toString()
    {
        String str = new String("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str = str.concat(String.valueOf("\t" + matrix[i][j]));
            }
            str = str.concat("\n");
        }
        return str;
    }

    public static void main(String[] args)
    {
            Matrix matrix1 = new Matrix("./matrix1.csv");
            Matrix matrix2 = new Matrix("./matrix2.csv");

            Matrix product = matrix1.dot(matrix2);
            System.out.println(product);

            System.out.println(matrix1.sigmoid());

            Matrix matrix3 = new Matrix("./matrix3.csv");

            System.out.println(matrix1);

            System.out.println(matrix1.add(matrix3).maxRow());
    }
}
