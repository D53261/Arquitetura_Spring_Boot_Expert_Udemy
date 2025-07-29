package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do serviço

import org.springframework.stereotype.Service; // Indica que é um serviço Spring

@Service // Marca a classe como um serviço gerenciado pelo Spring
public class TodoService { // Declaração da classe de serviço

    public TodoRepository repository; // Repositório para acesso ao banco de dados
    public TodoValidator validator; // Validador para regras de negócio
    public MailSender mailSender; // Serviço de envio de e-mails

    public TodoService(TodoRepository todoRepository,
                       TodoValidator validator,
                       MailSender mailSender) { // Construtor com injeção do repositório
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) { // Método para salvar uma nova tarefa
        validator.validar(novoTodo); // Valida a tarefa antes de salvar
        return repository.save(novoTodo); // Persiste a tarefa e retorna o objeto salvo
    }

    public void atualizarStatus(TodoEntity novoTodo) { // Método para atualizar o status da tarefa
        validator.validar(novoTodo); // Valida a tarefa antes de atualizar
        repository.save(novoTodo); // Salva a tarefa atualizada no banco
        String status = novoTodo.getConcluido() == Boolean.TRUE ? "concluído" : "não concluído"; // Verifica se a tarefa foi concluída
        mailSender.enviar("Tarefa atualizada: o TODO " + novoTodo.getDescricao() + " foi atualizado para " + status); // Envia um e-mail informando a atualização
    }

    public TodoEntity buscar(Integer id) { // Método para buscar uma tarefa pelo id
        return repository.findById(id) // Busca a tarefa pelo id
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id)); // Lança exceção se não encontrar
    }
}