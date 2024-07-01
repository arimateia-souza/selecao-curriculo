package com.sesap.selecaodecurriculo.service;

import com.sesap.selecaodecurriculo.model.usuario.Usuario;
import com.sesap.selecaodecurriculo.model.usuario.UsuarioDtoRequest;
import com.sesap.selecaodecurriculo.model.usuario.UsuarioDtoResponse;
import com.sesap.selecaodecurriculo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

@Service
public class UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private final EmailService emailService;
    private final ConsultaCep cep = new ConsultaCep();

    public UsuarioService(EmailService emailService) {
        this.emailService = emailService;
    }


    public void salvar(UsuarioDtoRequest u, MultipartFile file, HttpServletRequest request) {
        var novoArquivoNome = fileStorageService.save(file);
        var cepUsuario = u.endereco().cep();

        var cepBuscadoIndo = cep.buscar(cepUsuario);



        Usuario usuario = new Usuario(u, request, novoArquivoNome, cepBuscadoIndo);
        String path = "src/main/webapp/WEB-INF/file/" + novoArquivoNome;
        emailService.sendEmail(usuario,path);
        usuarioRepository.save(usuario);

    }

    public Page<UsuarioDtoResponse> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(UsuarioDtoResponse::new);
    }
}
