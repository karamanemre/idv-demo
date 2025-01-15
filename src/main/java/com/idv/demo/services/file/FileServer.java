package com.idv.demo.services.file;

import com.idv.demo.services.LogService;
import com.idv.demo.services.log.LogConsole;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServer {

    private final LogService logService;

    public String uploadFile() {
        try {
            System.out.println("File uploaded");
            return UUID.randomUUID().toString();
        } catch (Exception e) {
            LogConsole.error("An error occurred while file uploading. Detail: ", e.getMessage());
            this.logService.error(e, FileServer.class);
            throw new RuntimeException(e);
        }
    }
}
