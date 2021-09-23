package model;

final class Network
{
    // First layer
    static Matrix W1 = new Matrix("W1.csv");
    static Matrix b1 = new Matrix("b1.csv");

    // Second layer
    static Matrix W2 = new Matrix("W2.csv");
    static Matrix b2 = new Matrix("b2.csv");

    public static int feedforward(Matrix a0)
    {
        System.out.println("a0");
        a0.printSize();
        System.out.println("W1");
        W1.printSize();
        System.out.println("b1");
        b1.printSize();
        System.out.println("W2");
        W2.printSize();
        System.out.println("b2");
        b2.printSize();

        Matrix a1 = W1.dot(a0).add(b1).sigmoid();
        Matrix a2 = W2.dot(a1).add(b2).sigmoid();

        return a2.maxRow();
    }

    public static void main(String[] args)
    {
        int result = Network.feedforward(new Matrix("a0.csv"));
        System.out.println("The number is " + result);
    }
}
