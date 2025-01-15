package com.idv.demo.services.passport;

import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.entities.passport.DeservePassportEntity;
import com.idv.demo.repository.PassportRepository;
import com.idv.demo.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("DeservePassportService")
@RequiredArgsConstructor
public class DeservePassportService implements Passport {

    private final PassportRepository passportRepository;

    @Override
    public void process(ApplicationsEntity application) {
        DeservePassportEntity entity = DeservePassportEntity.builder()
                .expiryDate(DateUtil.getCurrentDate())
                .build();

        this.passportRepository.save(entity);
    }
}
