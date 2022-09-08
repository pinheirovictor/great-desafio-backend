package com.great.desafio.domain.service;

import com.great.desafio.api.assembler.UsuarioAssembler;
import com.great.desafio.domain.exception.NegocioException;
import com.great.desafio.domain.model.Usuario;
import com.great.desafio.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private UsuarioAssembler usuarioAssembler;

    public Usuario find (Long userId){
        return usuarioRepository.findById(userId).orElseThrow(() -> new NegocioException("Usuário não encontrado"));
    }

    @Transactional
    public Usuario save (Usuario usuario) throws NegocioException{
        boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf())
                .stream()
                .anyMatch(userExistente -> !userExistente.equals(usuario));

        if(cpfEmUso){
            throw new NegocioException("Já existe usuário cadastrado com esse CPF");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElseThrow(() -> new NegocioException("Erro ao buscar usuário por CPF"));
    }


    public Usuario buscarPorRg(String rg) {
        return usuarioRepository.findByRg(rg).orElseThrow(() -> new NegocioException("Erro ao buscar usuário por RG"));
    }


    // fazer um teste antes de excluir, se existe
    @Transactional
    public void delete (Long userId){

        usuarioRepository.deleteById(userId);
    }

    @Transactional
    public void deletePorCpf (String cpf){
        Usuario usuario = buscarPorCpf(cpf);
        usuarioRepository.delete(usuario);
    }


}
