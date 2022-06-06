package com.github.pjm03.phonesystem.phonesystem.call;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Call {
    private final String from;
    private final String to;
    private final long start;
    private final Type type;
}
