package com.example.taskapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class DocumentDetail{
    private Integer id_detail;
    private Integer line_number;
    private String product_name;
    private Integer id_doc;

}
