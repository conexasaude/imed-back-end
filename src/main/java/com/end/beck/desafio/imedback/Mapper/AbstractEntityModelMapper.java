package com.end.beck.desafio.imedback.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Classe abstrata que implementa os métodos básicos de um EntityModelMapper
 *
 * @param <T> Classe da entidade
 * @param <D> Classe do DTO
 */
public abstract class AbstractEntityModelMapper<T,D> implements EntityModelMapper<T, D> {
    
    @Autowired
    ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T convertToEntity(D dto) {
        if (null == dto)
            return null;

        return modelMapper.map(dto, this.getEntityClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public D convertToDto(T entity) {
        if (null == entity)
            return null;

        return modelMapper.map(entity, this.getDtoClass());
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    // public void configure(ModelMapper modelMapper) {
    //     modelMapper.createTypeMap(getEntityClass(), getDtoClass()).setPostConverter(toDtoConverter());

    //     if (getEntityClass().equals(getDtoClass())) {
    //         // log.info("Configuring modelMapper [Same Class] {} -> {}", getEntityClass(), getDtoClass());
    //         return;
    //     }

    //     modelMapper.createTypeMap(getDtoClass(), getEntityClass()).setPostConverter(toEntityConverter());
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<D> convertToDtoList(List<T> entityList) {
        return entityList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<D> convertPageToDtoList(Page<T> page) {
        List<D> content = page.getContent().stream().map(this::convertToDto)
                .collect(Collectors.toList());

        return new PageImpl<D>(content, page.getPageable(), page.getTotalElements());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> convertToEntityList(List<D> entityList) {
        return entityList.stream().map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    
}
