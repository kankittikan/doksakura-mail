package com.doksakura.doksakuramail.model;

import lombok.Data;

@Data
public class EmailMessage {
    private String personal;
    private String to;
    private String header;
    private String html;

    public EmailMessage(String personal, String to, String header, String html) {
        this.personal = personal;
        this.to = to;
        this.header = header;
        this.html = html;
    }
}