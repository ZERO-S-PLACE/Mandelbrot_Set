public class PointArray {

    private int height;
    private int width;
    private double xMax;
    private double iMax;
    private double step;


    public PointArray(int width, int height,double iMax,double xMax,double step) {
        this.height = height;
        this.width = width;
        this.xMax = xMax;
        this.iMax = iMax;
        this.step = step;
    }


    public int[][] generatePointArray() {


        int[][] pointArray = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pointArray[i][j] = checkEquation(new ComplexNumber(xMax - step * j, iMax - step * i));

            }


        }
        return pointArray;

    }
    public int checkEquation(ComplexNumber p) {


        ComplexNumber z = new ComplexNumber(0,0);


        for (int i = 1; i <= Parameters.getCheckIterations(); i++) {
            z = ComplexNumber.add(ComplexNumber.mulityply(z,z),p);
            if (ComplexNumber.absoluteValue(z) > 2) {
                if (i < Parameters.getBackgroundFade()) {
                    return 0;
                }
                return (int) log2(i);
            }
        }
        return -1;

    }


    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }



}






