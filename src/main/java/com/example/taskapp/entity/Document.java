package com.example.taskapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class Document {
    private Integer id;
    private Timestamp create_data;
    private String sender_code;
    private String recipient_code;

}
