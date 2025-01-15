package com.idv.demo.entities.passport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Date;
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
@Entity(name = "deserve_passport")
public class DeservePassportEntity extends PassportEntity {
    @Column(name = "expiry_date")
    private Date expiryDate;
}
