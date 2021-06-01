package br.com.zupedu.olucas.mlivre.product.utils;

public interface Mailer {
    void send(String body, String subject, String nameFrom, String from, String to);
}
