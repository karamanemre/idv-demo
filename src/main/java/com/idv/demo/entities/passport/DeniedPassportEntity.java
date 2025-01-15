package com.idv.demo.entities.passport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "denied_passport")
public class DeniedPassportEntity extends PassportEntity {
    @Column(name = "desc")
    private String desc;
}
