package br.umc.livros.controller;

import br.umc.livros.model.Livro;
import br.umc.livros.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.isEmpty()) {
            model.addAttribute("livros", service.buscarPorTitulo(busca));
        } else {
            model.addAttribute("livros", service.listarTodos());
        }
        return "lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("livro") Livro livro, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("livro", service.buscarPorId(id));
        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/livros";
    }
}
