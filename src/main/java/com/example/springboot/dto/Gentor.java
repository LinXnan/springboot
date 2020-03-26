package com.example.springboot.dto;

import com.example.springboot.common.AbstractEnumConverter;
import com.example.springboot.common.PersistEnum2DB;

public enum Gentor implements PersistEnum2DB<Integer> {
    MAN(0,"男"),
    WOMAN(1,"女"),
    OTHER(2,"不详");

    private int code;
    private String value;

    private Gentor(int code,String value){
        this.code = code;
        this.value = value;
    }
    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Integer getData() {
        return code;
    }

    public static class Converter extends AbstractEnumConverter<Gentor, Integer> {

        public Converter() {
            super(Gentor.class);
        }
    }
}
