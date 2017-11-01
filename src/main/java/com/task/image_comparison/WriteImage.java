package com.task.image_comparison;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BandedSampleModel;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sonik on 30.10.2017.
 */
public class WriteImage extends JPanel {


    private File file;
    private BufferedImage bufferedImage;

    public WriteImage(File file) {
        this.file = file;
        this.bufferedImage = readImage();
    }

    public BufferedImage readImage() {
        try {

            return ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
    }

    public int[][] getPixelsRGB() {
        BufferedImage image = readImage();

        int height = image.getHeight();
        int width = image.getWidth();

        int[][] imageArray = new int[height][width];

        for (int i = 0; i < imageArray.length; i++) {
            for (int j = 0; j < imageArray[i].length; j++) {
                imageArray[i][j] = image.getRGB(j, i);
            }
        }

        return imageArray;
    }

    public void setDiff(String[][] arrayDiff){
        Color color = new Color(255,0,0);
        int count = 0;

        for (int i = 0; i < arrayDiff.length; i++) {
            for (int j = 0; j < arrayDiff[i].length; j++) {
                if (arrayDiff[i][j].equals("1")){
                    bufferedImage.setRGB(j,i, color.getRGB());
                    count++;
                }

            }
        }
        System.out.println(count);


    }
}