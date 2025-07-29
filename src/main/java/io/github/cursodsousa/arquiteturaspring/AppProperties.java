package io.github.cursodsousa.arquiteturaspring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// A anotação @Configuration indica que esta classe é uma fonte de definições de beans
// e pode ser usada para carregar propriedades de configuração do Spring Boot.
@Configuration
// A anotação @ConfigurationProperties permite mapear propriedades de configuração
// de um arquivo de propriedades (como application.properties ou application.yml) para os campos desta classe
@ConfigurationProperties(prefix = "app.config")
public class AppProperties {
// Define o prefixo 'app.config' para as propriedades que serão mapeadas
    // Os campos abaixo correspondem às propriedades que serão carregadas do arquivo de configuração
    private String variavel;
    private String valor1;
    private String valor2;

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }
}
