package com.sesap.selecaodecurriculo.service;


import com.sesap.selecaodecurriculo.model.usuario.Usuario;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    private final JavaMailSender mailSender;



    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }
    public void sendEmail(Usuario usuario, String path){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("teste@teste.com");
            helper.setTo(usuario.getEmail());
            helper.setSubject("Analise de Curriculo: " + usuario.getCargoDesejado());
            helper.setText(mensagem(usuario));
            File file = new File(path);
            helper.addAttachment(file.getName(),file);
            mailSender.send(message);
        }catch (MessagingException e){
            throw new RuntimeException("Falha no envio de email:", e);
        }
    }
    private String mensagem(Usuario u){
        var body = "";
        if (!u.getObservacoes().isEmpty()){
            body = ("""
                Dados enviandos no formulario
                Nome: %s
                Email: %s
                Telefone: %s
                Cargo desejado: %s
                Observações: %s
                CEP: %s
                """.formatted(u.getNome(),u.getEmail(),u.getTelefone(),u.getCargoDesejado(),u.getObservacoes(), u.getEndereco().getCep()));
        }else {
            body = """
                Dados enviandos no formulario
                Nome: %s
                Email: %s
                Telefone: %s
                Cargo desejado: %s
                CEP: %s
                """.formatted(u.getNome(),u.getEmail(),u.getTelefone(),u.getCargoDesejado(),u.getEndereco().getCep());
        }


        return body;
    }

}
