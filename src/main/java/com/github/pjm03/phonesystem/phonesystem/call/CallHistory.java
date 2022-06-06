package com.github.pjm03.phonesystem.phonesystem.call;

import com.github.pjm03.phonesystem.phonesystem.phone.Phone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Table(name = "call_history")
public class CallHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "c_from")
    private String from;

    @Column(name = "c_to")
    private String to;

    @Column(name = "c_start")
    private long start;

    @Column(name = "c_end")
    private long end;

    @Column(name = "c_type")
    private Type type;
}
