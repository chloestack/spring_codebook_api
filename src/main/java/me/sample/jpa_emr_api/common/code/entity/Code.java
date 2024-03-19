package me.sample.jpa_emr_api.common.code.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Code {

    @Id
    @Column(length = 10)
    private String code;

    @ManyToOne
    @JoinColumn(name = "group_code")
    private CodeGroup groupCode;

    @Column(length = 10)
    private String codeName;

}
