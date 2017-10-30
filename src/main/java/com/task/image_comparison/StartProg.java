package com.task.image_comparison;

import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sonik on 30.10.2017.
 */
public class StartProg {
    public static void main(String[] args) {

        JFrame frame1 = new JFrame();
        JFrame frame2 = new JFrame();

        WriteImage image1 = new WriteImage((new File("D:\\JAVA\\GoIT Study\\Work test assignment\\ImageComparison\\src\\main\\resources\\image1.png")));
        WriteImage image2 = new WriteImage((new File("D:\\JAVA\\GoIT Study\\Work test assignment\\ImageComparison\\src\\main\\resources\\image2.png")));

        int[][] different1 = image1.getDifferent();
        int[][] different2 = image2.getDifferent();

        List<String> diffList = new ArrayList<String>();

        for (int i = 0; i < different1.length; i++) {
            for (int j = 0; j < different1[i].length; j++) {
                System.out.print(different1[i][j] == different2[i][j] ? "." : "x");
                if (different1[i][j] != different2[i][j]){
                    diffList.add(i + " " + j);
                }
            }
            System.out.println();
        }

        for (String s : diffList) {
            System.out.println(s);
        }

        System.out.println("Высота = " + different1.length);
        System.out.println("Ширина = " + different1[0].length);

        System.out.println(Arrays.deepEquals(different1, different2));


//        frame1.getContentPane().add(image1);
//        frame2.getContentPane().add(image2);

//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setSize(1000, 800);
//        frame1.setVisible(true);
//
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setSize(1000, 800);
//        frame2.setVisible(true);
    }
}
