package me.sample.spring_codebook_api.codebook.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    @Column(length = 45)
    private String name;

    @Column(length = 20)
    private String organizationNo;

    @Column(length = 10)
    private String director;

    @Builder
    public Hospital(Long hospitalId, String name, String organizationNo, String director) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.organizationNo = organizationNo;
        this.director = director;
    }
}
