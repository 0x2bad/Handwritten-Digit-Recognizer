package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

final public class Network
{
    // First layer
    static Matrix W1 = new Matrix("/model/W1.csv");
    static Matrix b1 = new Matrix("/model/b1.csv");

    // Second layer
    static Matrix W2 = new Matrix("/model/W2.csv");
    static Matrix b2 = new Matrix("/model/b2.csv");

    public static int feedforward(Matrix a0)
    {
        Matrix a1 = W1.dot(a0).add(b1).sigmoid();
        Matrix a2 = W2.dot(a1).add(b2).sigmoid();

        return a2.maxRow();
    }

    public static ArrayList<GrayMap> loadTests(String filename)
    {
        ArrayList<GrayMap> tests = new ArrayList<GrayMap>();

        try {
            Scanner sc = new Scanner(new File(filename));  
            sc.useDelimiter(",|\\n");

            while (sc.hasNextInt()) {
                tests.add(new GrayMap(sc, 784, 1));
            }

        sc.close();
        } catch(Exception e) {
            System.err.println("Exception in loadTests: " + e);
        }
        return tests;
    }

    public static void test(ArrayList<GrayMap> tests)
    {
        int score[] = {0, 0};
        tests.forEach((x) -> {
            if (x.getDigit() == Network.feedforward(x)) {
                score[0]++;
            }
            score[1]++;
        }
        );
        System.out.println("Accuracy: " + score[0] + "/" + score[1]);
    }

    public static void main(String[] args)
    {
        System.out.println("Testing for java");
        Network.test(Network.loadTests("java.csv"));
    }
}
