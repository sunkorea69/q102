package com.psc.example.q102.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OneDto {
    private String one;

    @Override
    public String toString() {
        return one;
    }

}
