package com.example.numerapicontroller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Getter
@AllArgsConstructor

public class Image {
    private String name;
    private long size;
    private byte[] bytes;


    public void setAll(String name,long size,byte[] bytes){
        this.name = name;
        this.size = size;
        this.bytes = bytes;
    }


    public byte[] changeColorToGray(Image image) throws IOException {
        InputStream input = new ByteArrayInputStream(image.getBytes());
        BufferedImage saved = ImageIO.read(input);
        int width = saved.getWidth(), height = saved.getHeight();

        for(int y = 0 ; y < height; y++){
            for(int x = 0; x < width; x++){
                Color color = new Color(saved.getRGB(x,y));
                int red = (int)(color.getRed() * 0.2126),
                        green = (int)(color.getGreen() * 0.7152),
                        blue = (int)(color.getBlue() * 0.0722),
                        sum = red + green + blue;
                Color grayShade= new Color(sum,sum,sum);
                saved.setRGB(x,y,grayShade.getRGB());
            }
        }
        input.close();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(saved,"jpg",outputStream);


        outputStream.flush();
        byte[] imageAsGray = outputStream.toByteArray();
        outputStream.close();

        return imageAsGray;
    }



}
