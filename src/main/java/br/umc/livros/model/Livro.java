package br.umc.livros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2, max = 150, message = "O título deve ter entre 2 e 150 caracteres")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    @Size(min = 2, max = 100, message = "O nome do autor deve ter entre 2 e 100 caracteres")
    private String autor;

    @NotNull(message = "O ano de publicação é obrigatório")
    @Min(value = 1000, message = "Informe um ano válido")
    @Max(value = 2026, message = "O ano não pode ser no futuro")
    private Integer ano;

    public Livro() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
}
