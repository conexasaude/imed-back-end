package com.end.beck.desafio.imedback.Mapper;

import java.util.List;

import org.modelmapper.Converters.Converter;
import org.springframework.data.domain.Page;
import org.modelmapper.ModelMapper;

/**
 * Componente responsável pelo mapeamento de
 * Entidades para DTO e
 * DTO para Entidades
 *
 * @param <T> Entidade
 * @param <D> Dto
 */
public interface EntityModelMapper<T,D> {
         /**
     * Classe da entidade
     *
     * @return A classe da entidade
     */
    Class<T>  getEntityClass();
    

    /**
     * Classe do DTO
     *
     * @return A classe do DTO
     */
    Class<D> getDtoClass();

    /**
     * Converter de entidade para DTO
     *
     * @return O Converter entidade DTO
     */
    Converter<T, D> toDtoConverter();

    /**
     * Converter de DTO para entidade
     *
     * @return O Converter DTO Entidade
     */
    Converter<D, T> toEntityConverter();

    /**
     * Registra os conversores no modelMappers
     *
     * @param modelMapper O Model Mapper a ser configurado
     */
    void configure(ModelMapper modelMapper);

    /**
     * Método que realiza a conversão de entidade para DTO
     *
     * @param dto O Dto
     * @return A Entidade
     */
    T convertToEntity(D dto);

    /**
     * Realiza a conversão de DTO para entidade
     *
     * @param entity A entidade
     * @return O DTO
     */
    D convertToDto(T entity);

    /**
     * Retorna uma lista de DTOs a partir de uma lista de entidades
     *
     * @param entityList A lista de entidades
     * @return A lista de DTO
     */
    List<D> convertToDtoList(List<T> entityList);

    Page<D> convertPageToDtoList(Page<T> page);

    /**
     * Retorna uma lista de Entidades a partir de uma lista de DTOs
     *
     * @param entityList A lista de DTO
     * @return A lista de entidade
     */
    List<T> convertToEntityList(List<D> entityList);
}
