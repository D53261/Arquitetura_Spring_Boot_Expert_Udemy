package io.github.cursodsousa.arquiteturaspring.montadora.configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Motor;
import io.github.cursodsousa.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Motor; // Importa a classe Motor
import io.github.cursodsousa.arquiteturaspring.montadora.TipoMotor; // Importa o enum TipoMotor
import org.springframework.context.annotation.Bean; // Importa a anotação Bean do Spring
import org.springframework.context.annotation.Configuration; // Importa a anotação Configuration do Spring
import org.springframework.context.annotation.Primary; // Importa a anotação Primary do Spring

@Configuration // Indica que esta classe contém configurações do Spring
public class MontadoraConfiguration { // Declaração da classe de configuração

    @Bean(name = "motorAspirado") // Define um bean chamado motorAspirado
    public Motor motorAspirado(){ // Método que retorna uma instância de Motor aspirado
        var motor = new Motor(); // Cria um novo Motor
        motor.setCavalos(120); // Define a potência do motor
        motor.setCilindros(4); // Define o número de cilindros
        motor.setLitragem(1.5); // Define a litragem do motor
        motor.setModelo("L15B"); // Define o modelo do motor
        motor.setTipo(TipoMotor.ASPIRADO); // Define o tipo como aspirado
        return motor; // Retorna o bean Motor configurado
    }

    @Bean(name = "motorEletrico") // Define um bean chamado motorEletrico
    public Motor motorEletrico(){ // Método que retorna uma instância de Motor elétrico
        var motor = new Motor(); // Cria um novo Motor
        motor.setCavalos(110); // Define a potência do motor
        motor.setCilindros(3); // Define o número de cilindros
        motor.setLitragem(2.0); // Define a litragem do motor
        motor.setModelo("TH-20"); // Define o modelo do motor
        motor.setTipo(TipoMotor.ELETRICO); // Define o tipo como elétrico
        return motor; // Retorna o bean Motor configurado
    }

    @Bean(name = "motorTurbo") // Define um bean chamado motorTurbo
    @Primary // Indica que este bean é o principal quando houver múltiplos candidatos
    public Motor motorTurbo(){ // Método que retorna uma instância de Motor turbo
        var motor = new Motor(); // Cria um novo Motor
        motor.setCavalos(150); // Define a potência do motor
        motor.setCilindros(5); // Define o número de cilindros
        motor.setLitragem(2.5); // Define a litragem do motor
        motor.setModelo("XPTO-01"); // Define o modelo do motor
        motor.setTipo(TipoMotor.TURBO); // Define o tipo como turbo
        return motor; // Retorna o bean Motor configurado
    }
}
