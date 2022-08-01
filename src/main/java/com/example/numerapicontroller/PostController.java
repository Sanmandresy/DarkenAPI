package com.example.numerapicontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
public class PostController {
    @PostMapping(path = "/image",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public byte[] getClientImage(@RequestParam("file")MultipartFile file) throws IOException {
            Image image = new Image(file.getOriginalFilename(),file.getSize(), file.getBytes());
            return image.changeColorToGray(image);
    }

}
