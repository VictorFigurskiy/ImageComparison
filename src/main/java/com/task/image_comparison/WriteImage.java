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

    public WriteImage(File file) {
        this.file = file;
    }

    public BufferedImage readImage() {

        BufferedImage bufferedImage = null;

        try {

            bufferedImage = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        Graphics graphics = bufferedImage.getGraphics();
//
//        graphics.drawString("www.w3ii.com", 20,20);

        return bufferedImage;
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage image = readImage();
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
    }

    public int[][] getDifferent() {
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

    public void setFile(File file) {
        this.file = file;
    }

}
