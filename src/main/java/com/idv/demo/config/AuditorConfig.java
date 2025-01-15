package com.idv.demo.config;

import com.idv.demo.utils.AuthUtils;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditorConfig")
public class AuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String currentUser = AuthUtils.getCurrentUsername();
        return Optional.ofNullable(currentUser);
    }
}
