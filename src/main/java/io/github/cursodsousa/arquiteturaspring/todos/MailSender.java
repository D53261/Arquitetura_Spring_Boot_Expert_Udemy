package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {
    public void enviar(String mensagem) {
        // Simula o envio de um e-mail
        System.out.println("Enviando e-mail com a mensagem: " + mensagem);
        // Aqui você poderia integrar com um serviço de envio de e-mails real
    }
}
