package ru.nsu.fit.daria.Img2ASCII;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Img2ASCII {
    private BufferedImage image;
    private PrintWriter pWriter;

    public Img2ASCII() {
        try {
            pWriter = new PrintWriter("drawing.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static char color2char(int pixelValue){
        char c = ' ';

        if (pixelValue >= 230 * 3){
            c = ' ';
        } else if (pixelValue >= 191 * 3){
            c = '.';
        } else if (pixelValue >= 153 * 3){
            c = '^';
        } else if (pixelValue >= 115 * 3){
            c = '+';
        } else if (pixelValue >= 89 * 3){
            c = '*';
        } else if (pixelValue >= 77 * 3){
            c = '8';
        } else if (pixelValue >= 51 * 3){
            c = '&';
        } else if (pixelValue >= 38 * 3){
            c = '#';
        } else {
            c = '@';
        }

        return c;
    }

    public void draw(String file){
        try {
            image = ImageIO.read(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int pixelValue;

        for (int i = 0; i < image.getHeight(); i++){
            for (int j = 0; j < image.getWidth(); j++){
                Color pixel = new Color(image.getRGB(j, i));
                pixelValue = pixel.getRed() + pixel.getBlue() + pixel.getGreen();
                try {
                    pWriter.print(color2char(pixelValue));
                    pWriter.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                pWriter.print('\n');
                pWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
