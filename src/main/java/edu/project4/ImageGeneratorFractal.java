package edu.project4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageGeneratorFractal implements ImageGenerator {

    @Override
    public void generate(Pixel[][] pixels, String path) {
        try {
            BufferedImage image = new BufferedImage(pixels.length, pixels[0].length, 1);
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    Pixel curPixel = pixels[i][j];
                    Color color = new Color(curPixel.getRed(), curPixel.getGreen(), curPixel.getBlue());
                    image.setRGB(i, j, color.getRGB());
                }
            }
            File file = new File(path + ".jpg");
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
