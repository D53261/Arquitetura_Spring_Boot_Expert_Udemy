package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDescricao(), todo.getId())) {
            throw new IllegalArgumentException("Já existe um TODO com a descrição: " + todo.getDescricao());
        }
    }

    private boolean existeTodoComDescricao(String descricao, Integer id) {
        TodoEntity existente = repository.findByDescricao(descricao); // Busca um TODO com a descrição fornecida
        if (existente == null) {
            return false; // Se não encontrar, retorna falso
        }
        return !existente.getId().equals(id); // Retorna verdadeiro se o id do TODO existente for igual ao id fornecido
    }
}
