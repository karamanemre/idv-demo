package com.idv.demo.entities.abstracts;

import com.idv.demo.entities.abstracts.Model;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingEntity implements Model {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected Date createdDate;

    @LastModifiedBy
    protected String modifiedBy;

    @LastModifiedDate
    protected Date modifiedDate;
}
