package br.umc.livros.service;

import br.umc.livros.model.Livro;
import br.umc.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public void salvar(Livro livro) {
        repository.save(livro);
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
