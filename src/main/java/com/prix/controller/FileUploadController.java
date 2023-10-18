/*package com.prix.controller;

import com.prix.Service.Inter.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class FileUploadController {

    private final FileUpload fileUpload;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile multipartFile,
                                             Model model)throws IOException{
        String imageURL = fileUpload.uploadFile(multipartFile);
        model.addAttribute("imageURL", imageURL);
        return new ResponseEntity<>(imageURL, HttpStatus.OK);
    }
}

 */
