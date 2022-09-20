package com.example.taskapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Mark {
    private Integer id_mark;
    private Integer id_detail;
    private Integer id_doc;

}
