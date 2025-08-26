package com.sismacontab.inventory.controllers;

import com.sismacontab.inventory.services.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = {"http://10.10.10.251:8060", "http://localhost:8060"})
public class FileUploadController {

    private final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("codigoInterno") String codigoInterno) {
        
        if (file.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "File is empty");
            return ResponseEntity.badRequest()
                .body(errorResponse);
        }

        try {
            String fileUrl = fileStorageService.storeFile(file, codigoInterno);
            Map<String, Object> response = new HashMap<>();
            response.put("url", fileUrl);
            response.put("message", "File uploaded successfully");
            response.put("codigoInterno", codigoInterno);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Could not upload file: " + e.getMessage());
            return ResponseEntity.internalServerError()
                .body(errorResponse);
        }
    }
}