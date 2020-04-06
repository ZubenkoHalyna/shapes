public class Triangle extends Shape {
    private final double firstSideLength;
    private final double secondSideLength;
    private final double angle;
    private final TriangleType type;

    private Triangle(TriangleBuilder builder) {
        super(builder.color);
        firstSideLength = builder.firstSideLength;
        secondSideLength = builder.secondSideLength;
        angle = builder.angle;
        type = builder.type;
    }

    private boolean isRegular() {
        return angle == 60;
    }

    @Override
    public void paint() {
        System.out.format("Shape: %striangle; sides length %.1f %.1f; angle %.0f;"
                        + " square %.2f; color %s\n",
                (type == TriangleType.COMMON) ? "" : type.toString().toLowerCase() + " ",
                firstSideLength,
                secondSideLength,
                angle,
                getSquare(),
                getColor().toString().toLowerCase());
    }

    @Override
    public double getSquare() {
        return firstSideLength * secondSideLength * Math.sin(angle * Math.PI / 180) / 2;
    }

    public double getFirstSideLength() {
        return firstSideLength;
    }

    public double getSecondSideLength() {
        return secondSideLength;
    }

    public double getAngle() {
        return angle;
    }

    enum TriangleType {
        REGULAR, RIGHT, ISOSCELES, COMMON
    }

    static class TriangleBuilder {
        private double firstSideLength;
        private double secondSideLength;
        private double angle;
        private Color color;
        private TriangleType type;

        public Triangle build() {
            type = TriangleType.COMMON;
            if (angle == 60 && firstSideLength == secondSideLength) {
                type = TriangleType.REGULAR;
            } else if (angle == 90 || Math.max(firstSideLength, secondSideLength)
                    == Math.min(firstSideLength, secondSideLength
                    * Math.sin(angle * Math.PI / 180))) {
                type = TriangleType.RIGHT;
            } else if (firstSideLength == secondSideLength
                    || 2 * firstSideLength * Math.cos(angle * Math.PI / 180)
                    == secondSideLength) {
                type = TriangleType.ISOSCELES;
            }
            return new Triangle(this);
        }

        public TriangleBuilder setFirstSideLength(double triangleFirstSideLength) {
            firstSideLength = triangleFirstSideLength;
            return this;
        }

        public TriangleBuilder setSecondSideLength(double triangleSecondSideLength) {
            secondSideLength = triangleSecondSideLength;
            return this;
        }

        public TriangleBuilder setAngle(double triangleAngle) {
            angle = triangleAngle;
            return this;
        }

        public TriangleBuilder setColor(Color triangleColor) {
            color = triangleColor;
            return this;
        }

        public double getFirstSideLength() {
            return firstSideLength;
        }

        public double getSecondSideLength() {
            return secondSideLength;
        }

        public double getAngle() {
            return angle;
        }

        public Color getColor() {
            return color;
        }
    }
}
