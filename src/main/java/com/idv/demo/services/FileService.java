package com.idv.demo.services;

import com.idv.demo.entities.FileEntity;
import com.idv.demo.exception.BadRequestException;
import com.idv.demo.repository.FileRepository;
import com.idv.demo.services.file.FileServer;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileServer fileServer;
    private final FileRepository fileRepository;
    private final LogService logService;

    public void generateFile(UUID ownerId) {
        String uploadedFileId = fileServer.uploadFile();

        FileEntity fileEntity = FileEntity.builder()
                .remoteFileId(uploadedFileId)
                .ownerId(ownerId)
                .build();

        this.fileRepository.save(fileEntity);
    }

    public FileEntity getFileByRemoteFileId(String remoteFileId) {
        FileEntity file = this.fileRepository.findByRemoteFileId(remoteFileId).orElse(null);
        if (file == null) {
            throw new BadRequestException("File not found");
        }
        return file;
    }
}
