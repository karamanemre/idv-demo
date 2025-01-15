package com.idv.demo.entities.application;

import com.idv.demo.entities.FamilyMembersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "application_active_worker")
public class ApplicationsActiveWorkerEntity extends ApplicationsEntity {

    @Column(name = "duty_start_date")
    private Date dutyStartDate;

    @Column(name = "duty_end_date")
    private Date dutyEndDate;

    @Column(name = "duty_title")
    private String dutyTitle;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    private List<FamilyMembersEntity> families;
}
