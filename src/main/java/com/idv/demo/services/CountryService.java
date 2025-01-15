package com.idv.demo.services;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.exception.EntityNotFoundException;
import com.idv.demo.repository.CountryRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public CountryEntity getCountryByCode(String code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Country with code " + code + " not found"));
    }

}
