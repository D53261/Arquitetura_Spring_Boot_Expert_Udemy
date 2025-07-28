package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do serviço

import org.springframework.stereotype.Service; // Indica que é um serviço Spring
import org.springframework.web.bind.annotation.PathVariable; // Importa anotação para parâmetros de caminho
import org.springframework.web.bind.annotation.RequestBody; // Importa anotação para corpo da requisição

@Service // Marca a classe como um serviço gerenciado pelo Spring
public class TodoService { // Declaração da classe de serviço

    public TodoRepository repository; // Repositório para acesso ao banco de dados

    public TodoService(TodoRepository todoRepository) { // Construtor com injeção do repositório
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) { // Método para salvar uma nova tarefa
        return repository.save(novoTodo); // Persiste a tarefa e retorna o objeto salvo
    }

    public void atualizarStatus(@RequestBody TodoEntity novoTodo) { // Método para atualizar o status da tarefa
        repository.save(novoTodo); // Salva a tarefa atualizada no banco
    }

    public TodoEntity buscar(@PathVariable("id") Integer id) { // Método para buscar uma tarefa pelo id
        return repository.findById(id) // Busca a tarefa pelo id
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id)); // Lança exceção se não encontrar
    }
}