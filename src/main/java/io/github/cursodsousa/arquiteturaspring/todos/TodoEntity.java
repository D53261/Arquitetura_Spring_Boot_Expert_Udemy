package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote da entidade

import jakarta.persistence.*; // Importa as anotações JPA

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "tb_todo") // Mapeia a entidade para a tabela "tb_todo"
public class TodoEntity { // Declaração da classe da entidade

    @Id // Indica que este campo é a chave primária
    @Column(name = "id") // Mapeia para a coluna "id"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do id pelo banco
    private Integer id; // Identificador único da tarefa

    @Column(name = "descricao") // Mapeia para a coluna "descricao"
    private String descricao; // Descrição da tarefa

    @Column(name = "concluido") // Mapeia para a coluna "concluido"
    private Boolean concluido; // Indica se a tarefa foi concluída

    public Integer getId() { // Getter do id
        return id;
    }

    public void setId(Integer id) { // Setter do id
        this.id = id;
    }

    public String getDescricao() { // Getter da descrição
        return descricao;
    }

    public void setDescricao(String descricao) { // Setter da descrição
        this.descricao = descricao;
    }

    public Boolean getConcluido() { // Getter do status concluído
        return concluido;
    }

    public void setConcluido(Boolean concluido) { // Setter do status concluído
        this.concluido = concluido;
    }
}