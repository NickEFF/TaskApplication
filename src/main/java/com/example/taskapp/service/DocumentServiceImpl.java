package com.example.taskapp.service;

import com.example.taskapp.entity.Document;
import com.example.taskapp.entity.DocumentDetail;
import com.example.taskapp.entity.Mark;
import com.example.taskapp.repository.DocumentRepository;
import com.example.taskapp.exception.DocumentNotFounfException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DocumentServiceImpl implements DocumentService{

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document getDocument(int documentId) {
        return documentRepository.getDocumentById(documentId)
        .orElseThrow(() ->new DocumentNotFounfException(documentId));
    }

    @Override
    public DocumentDetail getDetail(int detailId) {
        return documentRepository.getDetailById(detailId)
                .orElseThrow(() ->new DocumentNotFounfException(detailId));
    }

    @Override
    public Mark getMark(int markId) {
        return documentRepository.getMarkById(markId)
                    .orElseThrow(() ->new DocumentNotFounfException(markId));
    }

    @Override
    public void createDocument(String sender_code, String recipient_code){
        documentRepository.insertDocument(sender_code,recipient_code);
    }

    @Override
    public void createMark(Integer id_detail, Integer id_doc){
        documentRepository.insertMark(id_detail, id_doc);
    }

    @Override
    public void createDetail(String product_name, Integer id_doc){
        documentRepository.insertDetail(product_name, id_doc);
    }

    @Override
    public void deleteDocument(int id) {
        var document = documentRepository.getDocumentById(id)
                .orElseThrow(() -> new DocumentNotFounfException(id));
        documentRepository.deleteDocumentById(document.getId());
    }

    @Override
    public void deleteDetail(int id_detail) {
        var detail = documentRepository.getDetailById(id_detail)
                .orElseThrow(() -> new DocumentNotFounfException(id_detail));
        documentRepository.deleteDetailById(detail.getId_detail());
    }

    @Override
    public void deleteMark(int id_mark) {
        var mark = documentRepository.getMarkById(id_mark)
                .orElseThrow(() -> new DocumentNotFounfException(id_mark));
        documentRepository.deleteMarkById(mark.getId_mark());
    }
}
