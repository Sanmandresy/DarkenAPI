package com.example.numerapicontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class PostController {

    public byte[] changeColor(byte[] image) throws IOException{
            InputStream input = new ByteArrayInputStream(image);
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


    @PostMapping(path = "/image",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public byte[] getClientImage(@RequestParam("file")MultipartFile image) throws IOException {
        return changeColor(image.getBytes());
    }

}
