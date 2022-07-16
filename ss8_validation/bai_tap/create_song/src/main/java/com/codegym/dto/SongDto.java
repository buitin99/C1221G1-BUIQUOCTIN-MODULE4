package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;

    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[A-Za-z\\d]+$",message = "tên không được chứa ký tự đặt biệt")
    private String name;
    @NotEmpty
    @Size(max = 300)
    private String artist;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[A-Za-z,\\d]+$",message = "thể loại không được đặt ký tự đặt biệt ngoài dấu ,")
    private String type;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

     }
}
