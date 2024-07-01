package com.sesap.selecaodecurriculo.controller;

import com.sesap.selecaodecurriculo.model.usuario.UsuarioDtoRequest;
import com.sesap.selecaodecurriculo.model.usuario.UsuarioDtoResponse;
import com.sesap.selecaodecurriculo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = {"/", "/home", "/index"})
public class CurriculoController {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/submit")
    @Transactional
    public String doCadastrar(@ModelAttribute @Valid UsuarioDtoRequest usuario, @RequestParam(name = "file") MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        usuarioService.salvar(usuario, file, request);
        redirectAttributes.addFlashAttribute("mensagem", "Operação concluída com sucesso!");
        return "redirect:/home";
    }
    @GetMapping("/listar")
    public String listar(@PageableDefault(size = 5) Pageable pageable, Model model) {

        Page<UsuarioDtoResponse> usuarios = usuarioService.listar(pageable);
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }

}
