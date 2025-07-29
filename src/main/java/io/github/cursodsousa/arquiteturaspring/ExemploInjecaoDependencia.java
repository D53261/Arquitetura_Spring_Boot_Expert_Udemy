package io.github.cursodsousa.arquiteturaspring; // Exemplo de injeção de dependência manual em uma aplicação Spring

// Importando as classes necessárias do Spring
import io.github.cursodsousa.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {
        // Configuração manual do DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("usuario");
        dataSource.setPassword("senha");

        // Conectando ao banco de dados
        // Aqui, estamos criando uma conexão manualmente, mas em uma aplicação real,
        // você deve usar o DataSource configurado pelo Spring para gerenciar conexões.
        Connection connection = dataSource.getConnection();

        // A criação do EntityManager geralmente é feita através de um EntityManagerFactory,
        // mas como estamos fazendo uma injeção de dependência manual, vamos simular isso
        // com um EntityManager fictício. Em uma aplicação real, você deve usar o EntityManagerFactory
        // para criar o EntityManager corretamente.
        EntityManager entityManager = null;

        // Criando o repositório TodoRepository manualmente
        // O SimpleJpaRepository é uma implementação padrão do JpaRepository que pode ser usada diretamente
        // Aqui, estamos passando o EntityManager e a classe de entidade TodoEntity.
        TodoRepository repository =  null; // new SimpleJpaRepository<TodoEntity, Integer>(null, null);
        // Criando o validador TodoValidator manualmente
        TodoValidator validator = new TodoValidator(repository);
        // Criando o MailSender manualmente
        MailSender mailSender = new MailSender();
        // Criando o serviço TodoService manualmente
        TodoService todoService = new TodoService(repository, validator, mailSender);
    }
}
