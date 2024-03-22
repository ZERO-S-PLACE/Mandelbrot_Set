import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ParallelImage extends RecursiveTask<BufferedImage> {

    private int height;
    private int width;
    private double xMax;
    private double iMax;
    private double step;



    public ParallelImage(int width,int height,  double xMax, double iMax, double step) {
        this.height = height;
        this.width = width;
        this.xMax = xMax;
        this.iMax = iMax;
        this.step = step;
    }
    @Override
    protected BufferedImage compute() {
        System.out.println("new iteration.."+iMax+" "+xMax);


        GeneratePicture g = new GeneratePicture();
        PointArray point =new PointArray(width,height,iMax,xMax,step);
        int[][] pointArray =point.generatePointArray();
        BufferedImage image =g.generate(pointArray);

        /*// Save the image to a file
        File output = new File("MANDELBROT"+count+".png");
        try {
            ImageIO.write(image, "png", output);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        return image;
    }

    public  BufferedImage generateImage() throws InterruptedException {
        int t = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool();
        PictureColors.createColors();
        BufferedImage[] images = new BufferedImage[t];
        ParallelImage[] im = new ParallelImage[t];
        double iMaxTemp = iMax;
        int h = height / t;

        for (int i = 0; i < t; i++) {
            if (i == t - 1) {
                h = height - h * (t - 1);
            }
            im[i] = new ParallelImage(width, h, xMax, iMaxTemp, step);
            iMaxTemp = iMax - h * step * (i + 1);
            pool.submit(im[i]);
        }


        pool.shutdown();

        pool.awaitTermination(10000, TimeUnit.SECONDS);
        for (int i = 0; i < t; i++) {
            try {
                images[i] = im[i].get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("joining...");
        BufferedImage image = combineImagesVertically(images, width, height);


        // Save the image to a file
        File output = new File("MANDELBROT_ZOOM_"+Parameters.getZoomCount()+".png");
        try {
            ImageIO.write(image, "png", output);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


    private static BufferedImage combineImagesVertically(BufferedImage[] images, int width, int height) {
        // Get the total width and height of the combined image


        // Create a new BufferedImage for the combined image
        BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a Graphics2D object to draw on the combined image
        java.awt.Graphics2D g2d = combinedImage.createGraphics();

        // Draw each image onto the combined image
        int currentY = 0;
        for (BufferedImage image : images) {
            g2d.drawImage(image, 0, currentY, null);
            currentY += image.getHeight();
        }

        // Dispose of the Graphics2D object to release resources
        g2d.dispose();

        return combinedImage;
    }



}
