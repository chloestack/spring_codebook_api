package me.sample.jpa_emr_api.common.code.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="code_group")
public class CodeGroup {

    @Id
    @Column(length = 10)
    private String groupCode;

    @Column(length = 10)
    private String groupName;

    @Column(length = 50)
    private String description;
    
}
