package com.github.pjm03.phonesystem.phonesystem.phone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int idx;

    @JsonIgnore
    private String owner;

    @Column(name = "phone_number")
    private String phoneNumber;
}
