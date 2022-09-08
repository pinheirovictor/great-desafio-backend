package com.great.desafio.api.controller;

import com.great.desafio.api.assembler.UsuarioAssembler;
import com.great.desafio.api.model.UsuarioModel;
import com.great.desafio.domain.filter.UsuarioFilter;
import com.great.desafio.domain.model.Usuario;
import com.great.desafio.domain.repository.UsuarioRepository;
import com.great.desafio.domain.repository.spec.UsuarioSpec;
import com.great.desafio.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PersistenceContext
    private EntityManager manager;
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;
    private UsuarioAssembler usuarioAssembler;

    @GetMapping
    public Page<UsuarioModel> listar(UsuarioFilter filtro, @PageableDefault(size = 10) Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioRepository.findAll(UsuarioSpec.usandoFiltro(filtro), pageable);
        List<UsuarioModel> usuariosModel = usuarioAssembler.toCollectionModel(usuariosPage.getContent());
        PageImpl<UsuarioModel> usuariosModelPage = new PageImpl<>(usuariosModel, pageable, usuariosPage.getTotalElements());
        return usuariosModelPage;
    }

    @GetMapping("/cpf/{cpf}")
    public UsuarioModel buscarPorCpf(@PathVariable String cpf) {
        return usuarioAssembler.toModel(usuarioService.buscarPorCpf(cpf));
    }

    @GetMapping("/rg/{rg}")
    public UsuarioModel buscarPorRg(@PathVariable String rg) {
        return usuarioAssembler.toModel(usuarioService.buscarPorRg(rg));
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePorCpf(@PathVariable String cpf) {
        usuarioService.deletePorCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar (@Valid @RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }


}
