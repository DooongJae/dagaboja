package com.dagaboja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileRestController {
	
	private static final String UPLOAD_DIR  
		= "C:\\\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\"
				+ "dagabojaBoot\\src\\main\\resources\\static\\images\\";

	@GetMapping("/index/{filename}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
    	
        try {
            File file = new File(UPLOAD_DIR + filename);
            
            // 폴더가 없을경우 notFound
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 이미지 경로에서 파일가져오기
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            // 그냥 사진만 보낼경우 정상적으로 확인 불가능 따라서 아래 객체 (ResponseEntity 사용)
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getName() + "\"")
                    .contentLength(file.length())
                    .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 맞게 MediaType 설정
                    .body(resource);
            
        } catch (FileNotFoundException e) { // 파일이 없을경우 notFound
            return ResponseEntity.notFound().build();
        }
        
    }
	


}
