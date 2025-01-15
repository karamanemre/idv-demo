package com.idv.demo.entities.application;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "application_retired_worker")
public class ApplicationsRetiredWorkerEntity extends ApplicationsEntity {

    @Column(name = "last_duty_title")
    private String lastDutyTitle;

    @Column(name = "reason_desc")
    private String reasonDesc;

    @Column(name = "reason_date")
    private Date reasonDate;
}
