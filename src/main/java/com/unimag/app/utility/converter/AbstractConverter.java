package com.unimag.app.utility.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

    public abstract D fromEntity(E entity);

    public abstract E fromDTO(D DTO);

    public List<D> fromEntity(List<E> entities) {
        return entities
                .stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    public List<E> fromDTO(List<D> DTOs) {
        return DTOs
                .stream()
                .map(e -> fromDTO(e))
                .collect(Collectors.toList());
    }
}
