package me.sample.jpa_emr_api.emr.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(length = 45)
    private String name;

    @Column(length = 13)
    private String registrationNo;

    @Column(length = 10)
    private String genderCd;

    @Column(nullable = false, length = 10)
    private String birthday;

    @Column(nullable = false, length = 20)
    private String phone;

    @Builder
    public Patient(Long patientId, Hospital hospital, String name, String registrationNo, String genderCd, String birthday, String phone) {
        this.patientId = patientId;
        this.hospital = hospital;
        this.name = name;
        this.registrationNo = registrationNo;
        this.genderCd = genderCd;
        this.birthday = birthday;
        this.phone = phone;
    }

}
