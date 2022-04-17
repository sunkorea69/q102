package com.psc.example.q102.custom;

import com.psc.example.q102.dto.OneDto;
import org.springframework.batch.item.file.transform.LineAggregator;

public class CustomPasThroudhLineAggregator<T> implements LineAggregator <T>{
    @Override
    public String aggregate(T item) {
        if (item instanceof OneDto) {
            return item.toString() + "_item";
        }
        return item.toString();
    }
}
