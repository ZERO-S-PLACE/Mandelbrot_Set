public class Parameters {

    private  static int height=720;
    private  static int width=1200;
    private  static int exportHeight=3600;
    private  static int exportWidth=6000;
    private  static double xMax=0.6;
    private  static double iMax=1.1;
    private  static double step= 0.0034;
    private  static int CheckIterations=1000;
    private  static int exportCheckIterations=10000;
    private  static int BackgroundFade=0;
    private static int zoomCount=0;

    public static int getExportCheckIterations() {
        return exportCheckIterations;
    }

    public static void setExportCheckIterations(int exportCheckIterations) {
        Parameters.exportCheckIterations = exportCheckIterations;
    }
    public static int getExportHeight() {
        return exportHeight;
    }

    public static void setExportHeight(int exportHeight) {
        Parameters.exportHeight = exportHeight;
    }

    public static int getExportWidth() {
        return exportWidth;
    }

    public static void setExportWidth(int exportWidth) {
        Parameters.exportWidth = exportWidth;
    }

    public static int getZoomCount() {
        return zoomCount;
    }

    public static void setZoomCount(int zoomCount) {
        Parameters.zoomCount = zoomCount;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Parameters.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Parameters.width = width;
    }

    public static double getxMax() {
        return xMax;
    }

    public static void setxMax(double xMax) {
        Parameters.xMax = xMax;
    }

    public static double getiMax() {
        return iMax;
    }

    public static void setiMax(double iMax) {
        Parameters.iMax = iMax;
    }

    public static double getStep() {
        return step;
    }

    public static void setStep(double step) {
        Parameters.step = step;
    }

    public static int getCheckIterations() {
        return CheckIterations;
    }

    public static void setCheckIterations(int checkIterations) {
        CheckIterations = checkIterations;
    }

    public static int getBackgroundFade() {
        return BackgroundFade;
    }

    public static void setBackgroundFade(int backgroundFade) {
        BackgroundFade = backgroundFade;
    }
}
