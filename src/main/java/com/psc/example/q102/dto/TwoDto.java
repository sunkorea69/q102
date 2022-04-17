package com.psc.example.q102.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TwoDto {
    private String one;
    private String two;


    @Override
    public String toString() {
        return one;
    }

}
