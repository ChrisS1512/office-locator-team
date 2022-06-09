package com.solirius.hosehackathon.errorhandling;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    /*
    The error message to return
    */
    private String message;

    /*
    The timestamp when error occurs
    */
    private LocalDateTime timestamp;
}
