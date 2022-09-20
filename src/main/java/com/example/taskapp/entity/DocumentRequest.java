package com.example.taskapp.entity;

import org.jetbrains.annotations.NotNull;


public record DocumentRequest(
        @NotNull
        String sender_code,
        @NotNull
        String recipient_code
) {
}
