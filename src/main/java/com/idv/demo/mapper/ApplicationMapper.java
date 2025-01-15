package com.idv.demo.mapper;

import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.entities.application.ApplicationsRetiredWorkerEntity;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationActiveWorkerRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationGetResponse;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationRetiredWorkerRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {

    ApplicationsActiveWorkerEntity toEntity(ApplicationActiveWorkerRequest request);

    ApplicationsRetiredWorkerEntity toEntity(ApplicationRetiredWorkerRequest request);

    ApplicationGetResponse toDto(ApplicationsEntity applicationsEntity);

    List<ApplicationGetResponse> toDto(List<ApplicationsEntity> entities);
}
