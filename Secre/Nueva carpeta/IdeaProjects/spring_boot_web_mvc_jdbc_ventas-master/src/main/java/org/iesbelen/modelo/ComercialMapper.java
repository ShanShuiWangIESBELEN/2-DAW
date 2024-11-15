package org.iesbelen.modelo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ComercialMapper {

    ComercialMapper INSTANCE = Mappers.getMapper( ComercialMapper.class );

    @Mapping(target = "listaPedidos", ignore = true)
    ComercialDTO comercialToComercialDTO(Comercial comercial);
}