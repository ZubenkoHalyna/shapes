public class Trapeze extends Shape {
    private final double firstBaseWidth;
    private final double secondBaseWidth;
    private final double leftAngle;
    private final double rightAngle;
    private final double height;
    private final TrapezeType type;

    private Trapeze(TrapezeBuilder builder) {
        super(builder.color);
        firstBaseWidth = builder.firstBaseWidth;
        secondBaseWidth = builder.secondBaseWidth;
        leftAngle = builder.leftAngle;
        rightAngle = builder.rightAngle;
        height = builder.height;
        type = builder.type;
    }

    @Override
    public void paint() {
        System.out.format("Shape: %strapeze; bases length %.2f %.2f; height length %.2f;"
                        + " angles %.0f %.0f; square %.2f; color %s\n",
                (type == TrapezeType.COMMON) ? "" : type.toString().toLowerCase() + " ",
                firstBaseWidth,
                secondBaseWidth,
                height,
                leftAngle,
                rightAngle,
                getSquare(),
                getColor().toString().toLowerCase());
    }

    @Override
    public double getSquare() {
        return (firstBaseWidth + secondBaseWidth) / 2.0 * height;
    }

    public double getFirstBaseWidth() {
        return firstBaseWidth;
    }

    public double getSecondBaseWidth() {
        return secondBaseWidth;
    }

    public double getLeftAngle() {
        return leftAngle;
    }

    public double getRightAngle() {
        return rightAngle;
    }

    public double getHeight() {
        return height;
    }

    public TrapezeType getType() {
        return type;
    }

    enum TrapezeType {
        RIGHT, ISOSCELES, COMMON
    }

    static class TrapezeBuilder {
        private double firstBaseWidth;
        private double secondBaseWidth;
        private double leftAngle;
        private double rightAngle;
        private double height;
        private TrapezeType type;
        private Color color;

        public Trapeze build() {
            type = TrapezeType.COMMON;
            if (leftAngle == 90 || rightAngle == 90) {
                type = TrapezeType.RIGHT;
            } else if (leftAngle == rightAngle) {
                type = TrapezeType.ISOSCELES;
            }
            height = Math.abs((firstBaseWidth - secondBaseWidth)
                    / (1 / (Math.tan(leftAngle * Math.PI / 180))
                    + (1 / Math.tan(rightAngle * Math.PI / 180))));
            return new Trapeze(this);
        }

        public TrapezeBuilder setFirstBaseWidth(double trapezeFirstBaseWidth) {
            firstBaseWidth = trapezeFirstBaseWidth;
            return this;
        }

        public TrapezeBuilder setSecondBaseWidth(double trapezeSecondBaseWidth) {
            secondBaseWidth = trapezeSecondBaseWidth;
            return this;
        }

        public TrapezeBuilder setLeftAngle(double trapezeLeftAngle) {
            leftAngle = trapezeLeftAngle;
            return this;
        }

        public TrapezeBuilder setRightAngle(double trapezeRightAngle) {
            rightAngle = trapezeRightAngle;
            return this;
        }

        public TrapezeBuilder setColor(Color trapezeColor) {
            color = trapezeColor;
            return this;
        }

        public Color getColor() {
            return color;
        }

        public double getRightAngle() {
            return rightAngle;
        }

        public double getFirstBaseWidth() {
            return firstBaseWidth;
        }

        public double getSecondBaseWidth() {
            return secondBaseWidth;
        }

        public double getLeftAngle() {
            return leftAngle;
        }
    }
}
