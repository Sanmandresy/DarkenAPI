package com.example.numerapicontroller;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.example.numerapicontroller.Image.changeColorToGray;


@RestController
public class PostController {
  @PostMapping(path = "/image",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
      produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
  public byte[] getClientImage(@RequestParam("file") MultipartFile file) throws IOException {
    Image image = new Image(file.getOriginalFilename(), file.getSize(), file.getBytes());
    return changeColorToGray(image);
  }

}
