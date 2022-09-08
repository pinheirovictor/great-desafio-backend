package com.great.desafio.domain.repository.spec;

import com.great.desafio.domain.filter.UsuarioFilter;
import com.great.desafio.domain.model.Usuario;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class UsuarioSpec {

    public static Specification<Usuario> usandoFiltro(UsuarioFilter filtro) {
        return (root, query, builder) ->  {

            var predicates = new ArrayList<Predicate>();

            if(filtro.getName() != null) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + filtro.getName().toLowerCase() + "%"));
            }

            if(filtro.getCpf() != null) {
                predicates.add(builder.like(builder.lower(root.get("cpf")), "%" + filtro.getCpf().toLowerCase() + "%"));
            }

            if(filtro.getRg() != null) {
                predicates.add(builder.like(builder.lower(root.get("rg")), "%" + filtro.getRg().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        };
    }
}
