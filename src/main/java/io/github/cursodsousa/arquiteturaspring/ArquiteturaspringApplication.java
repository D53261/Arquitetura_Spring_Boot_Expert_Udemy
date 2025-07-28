package io.github.cursodsousa.arquiteturaspring; // Define o pacote principal da aplicação

import org.springframework.boot.Banner; // Importa a classe Banner para configuração de exibição
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa a anotação para configuração automática do Spring Boot
import org.springframework.boot.builder.SpringApplicationBuilder; // Importa o builder para inicializar a aplicação
import org.springframework.context.ConfigurableApplicationContext; // Importa o contexto configurável da aplicação
import org.springframework.core.env.ConfigurableEnvironment; // Importa o ambiente configurável

@SpringBootApplication // Indica que esta é uma aplicação Spring Boot
public class ArquiteturaspringApplication { // Declaração da classe principal

 public static void main(String[] args) { // Método principal de inicialização
  //SpringApplication.run(Application.class, args); // Alternativa para inicializar a aplicação

  SpringApplicationBuilder builder =
    new SpringApplicationBuilder(ArquiteturaspringApplication.class); // Cria o builder para a aplicação

//		builder.bannerMode(Banner.Mode.ON); // Configuração opcional do banner
  builder.profiles("producao", "homologacao"); // Define os perfis ativos

  builder.run(args); // Inicializa a aplicação com os argumentos recebidos

  // contexto da aplicação já iniciada:
  ConfigurableApplicationContext applicationContext = builder.context(); // Obtém o contexto da aplicação
//		var produtoRepository = applicationContext.getBean("produtoRepository"); // Exemplo de obtenção de bean

  ConfigurableEnvironment environment = applicationContext.getEnvironment(); // Obtém o ambiente da aplicação
  String applicationName = environment.getProperty("spring.application.name"); // Recupera o nome da aplicação
  System.out.println("Nome da aplicação: " + applicationName); // Exibe o nome da aplicação

	}

}