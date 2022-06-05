package com.github.pjm03.phonesystem.phonesystem.human;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Human {
    @NonNull
    private String name;

    @NonNull
    private String birthday;

    @NonNull
    private String birthdayTime;

    @NonNull
    private String idNumber;

    @NonNull
    private Sex sex;

    public enum Sex {
        MAN, WOMAN, OTHER
    }
}