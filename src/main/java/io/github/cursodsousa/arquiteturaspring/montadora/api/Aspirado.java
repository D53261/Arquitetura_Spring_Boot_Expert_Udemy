package io.github.cursodsousa.arquiteturaspring.montadora.api; // Define o pacote da anotação

import org.springframework.beans.factory.annotation.Qualifier; // Importa Qualifier do Spring

import java.lang.annotation.ElementType; // Tipo de elemento para uso na anotação
import java.lang.annotation.Retention; // Política de retenção da anotação
import java.lang.annotation.RetentionPolicy; // Opções de política de retenção
import java.lang.annotation.Target; // Alvo da anotação

@Retention(RetentionPolicy.RUNTIME) // Disponível em tempo de execução
@Target({ElementType.METHOD, ElementType.FIELD}) // Usada em métodos e campos
@Qualifier("motorAspirado") // Identifica beans específicos como "motorAspirado"
public @interface Aspirado { // Declaração da anotação personalizada Aspirado
} // Pode ser usada para injetar um bean Motor aspirado