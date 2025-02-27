package com.flt.mapper;

import com.flt.dto.ItemDTO;
import com.flt.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    ItemDTO toDto(Item item);
    Item toEntity(ItemDTO itemDTO);
}
