package com.idv.demo.services;

import com.idv.demo.entities.FileEntity;
import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.exception.BadRequestException;
import com.idv.demo.models.dtos.confirmation.ConfirmationRequest;
import com.idv.demo.models.enums.PassportStatus;
import com.idv.demo.services.application.ApplicationService;
import com.idv.demo.services.log.LogConsole;
import com.idv.demo.services.passport.Passport;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final Map<String, Passport> instances;
    private final ApplicationService applicationService;
    private final FileService fileService;
    private final LogService logService;

    public void setApplicationStatus(ConfirmationRequest request) {
        try {
            this.applicationService.changeStatus(request.getApplicationId(), request.getStatus());
            this.fileService.generateFile(request.getApplicationId());
        } catch (Exception e) {
            LogConsole.error("Error while setApplicationStatus: ", e.getMessage());
            this.logService.error(e, ConfirmationService.class);
        }
    }

    public void updatePassportStatus(String documentId, PassportStatus status) {
        try {
            FileEntity file = this.fileService.getFileByRemoteFileId(documentId);
            ApplicationsEntity application = applicationService.findById(file.getOwnerId());
            Passport instance = this.getInstance(status.getValue());
            instance.process(application);
        } catch (Exception e) {
            LogConsole.error("Error while updatePassportStatus: ", e.getMessage());
            this.logService.error(e, ConfirmationService.class);
        }
    }

    private Passport getInstance(String value) {
        Passport instance = this.instances.get(value);
        if (instance == null) {
            throw new BadRequestException("Unsupported type");
        }
        return instance;
    }
}
