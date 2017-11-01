package com.task.image_comparison;

import javax.swing.*;
import java.io.File;

/**
 * Created by Sonik on 30.10.2017.
 */
public class StartProg {
    public static void main(String[] args) {

        JFrame frame1 = new JFrame();
        JFrame frame2 = new JFrame();

        WriteImage image1 = new WriteImage((new File("D:\\JAVA\\GoIT Study\\Work test assignment\\ImageComparison\\src\\main\\resources\\image1.png")));
        WriteImage image2 = new WriteImage((new File("D:\\JAVA\\GoIT Study\\Work test assignment\\ImageComparison\\src\\main\\resources\\image2.png")));

        int[][] pixelsRGB1 = image1.getPixelsRGB();
        int[][] pixelsRGB2 = image2.getPixelsRGB();

        String[][] result = new String[pixelsRGB1.length][pixelsRGB1[0].length];

        for (int i = 0; i < pixelsRGB1.length; i++) {
            for (int j = 0; j < pixelsRGB1[i].length; j++) {
//                System.out.print(pixelsRGB1[i][j] == pixelsRGB2[i][j] ? "." : "x");
                if (pixelsRGB1[i][j] != pixelsRGB2[i][j]) {
                    result[i][j] = "x";
                } else {
                    result[i][j] = ".";
                }
            }
//            System.out.println();
        }


        bordersOfDiff(result);
//
//        printArray(result);

        image2.setDiff(result);

//        frame1.getContentPane().add(image1);
        frame2.getContentPane().add(image2);

//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setSize(1000, 800);
//        frame1.setVisible(true);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1000, 800);
        frame2.setVisible(true);

    }

    private static void bordersOfDiff(String[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

                if (result[i][j].equals("x") && result[i][j-1].equals(".")) {
                    result[i][j-1]="1";
                }

            }
        }

        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[j][i].equals("x") && result[j-1][i].equals(".")) {
                    result[j-1][i]="1";
                }
            }




        }
    }

    private  static void printArray(String[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}