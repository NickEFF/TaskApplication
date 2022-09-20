package com.example.taskapp.service;

import com.example.taskapp.entity.Document;
import com.example.taskapp.entity.DocumentDetail;
import com.example.taskapp.entity.Mark;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public interface DocumentService {
    Document getDocument(int documentId);

    DocumentDetail getDetail(int detailId);

    Mark getMark(int markId);

    void createDocument(String sender_code, String recipient_code);

    void createMark(Integer id_detail, Integer id_doc);

    void createDetail(String product_name, Integer id_doc);

    void deleteDocument(int id);

    void deleteDetail(int id_detail);

    void deleteMark(int id_mark);
}
