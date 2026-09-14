package com.example.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailInvalidException extends IllegalArgumentException{
    private String message ;
    public EmailInvalidException(String message){
        super(message);
    }
}
