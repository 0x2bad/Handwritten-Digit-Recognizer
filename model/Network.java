package model;

final public class Network
{
    // First layer
    static Matrix W1 = new Matrix("W1.csv");
    static Matrix b1 = new Matrix("b1.csv");

    // Second layer
    static Matrix W2 = new Matrix("W2.csv");
    static Matrix b2 = new Matrix("b2.csv");

    public static int feedforward(Matrix a0)
    {
        Matrix a1 = W1.dot(a0).add(b1).sigmoid();
        Matrix a2 = W2.dot(a1).add(b2).sigmoid();

        return a2.maxRow();
    }

    public static void main(String[] args)
    {
        int result = Network.feedforward(new Matrix("a1.csv"));
        System.out.println("The number is " + result);
    }
}
