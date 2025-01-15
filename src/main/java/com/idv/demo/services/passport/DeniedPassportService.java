package com.idv.demo.services.passport;

import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.entities.passport.DeniedPassportEntity;
import com.idv.demo.entities.passport.DeservePassportEntity;
import com.idv.demo.repository.PassportRepository;
import com.idv.demo.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("DeniedPassportService")
@RequiredArgsConstructor
public class DeniedPassportService implements Passport {

    private final PassportRepository passportRepository;

    @Override
    public void process(ApplicationsEntity application) {
        DeniedPassportEntity entity = DeniedPassportEntity.builder()
                .desc("** dolayı kabul edilmedi")
                .build();

        this.passportRepository.save(entity);
    }
}
