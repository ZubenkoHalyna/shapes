public class Square extends Shape {
    private final double sideLength;

    public Square(double squareSideLength, Color squareColor) {
        super(squareColor);
        sideLength = squareSideLength;
    }

    @Override
    public void paint() {
        System.out.format("Shape: square; side length %.1f; square %.2f; color %s\n",
                sideLength,
                getSquare(),
                getColor().toString().toLowerCase());
    }

    @Override
    public double getSquare() {
        return sideLength * sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}
