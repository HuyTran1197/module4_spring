package com.example.demo_valid_song.util;

import com.example.demo_valid_song.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class Validate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if (song.getName().equals("")){
            errors.rejectValue("name",null,"không được để trống");
        } else if (!song.getName().matches("^\\p{L}+(\\s\\p{L}+)*$")) {
            errors.rejectValue("name",null,"tên bài hát không được chứa kí tự đặc biệt");
        } else if (song.getName().length()<2 || song.getName().length()>800) {
            errors.rejectValue("name",null,"tên bài hát tối thiểu là 5, tối đa 800");
        }

        if (song.getSingle().equals("")){
            errors.rejectValue("single",null,"không được để trống");
        } else if (!song.getSingle().matches("^\\p{L}+(\\s\\p{L}+)*$")) {
            errors.rejectValue("single",null,"tên nghệ sĩ không được chứa kí tự đặc biệt");
        } else if (song.getSingle().length()<2 || song.getSingle().length()>300) {
            errors.rejectValue("single",null,"tên nghệ sĩ tối thiểu là 5, tối đa 300");
        }

        if (song.getType().equals("")){
            errors.rejectValue("type",null,"không được để trống");
        } else if (!song.getType().matches("^\\p{L}+(,?\\s\\p{L}+)*$")) {
            errors.rejectValue("type",null,"thể loại không được chứa kí tự đặc biệt ngoài dấu ','");
        } else if (song.getType().length()<2 || song.getType().length()>1000) {
            errors.rejectValue("type",null,"tên thể loại tối thiểu là 5, tối đa 1000");
        }

    }
}
