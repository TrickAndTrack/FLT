package com.flt.service;


import com.flt.dto.ItemDTO;
import com.flt.exception.CustomException;
import com.flt.mapper.ItemMapper;
import com.flt.model.Item;
import com.flt.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper = ItemMapper.INSTANCE;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<ItemDTO> getAllItems() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public ItemDTO getItemById(Long id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new CustomException("Item not found"));
    }

    public ItemDTO createItem(ItemDTO dto) {
        Item item = mapper.toEntity(dto);
        return mapper.toDto(repository.save(item));
    }

    public ItemDTO updateItem(Long id, ItemDTO dto) {
        Item existing = repository.findById(id)
                .orElseThrow(() -> new CustomException("Item not found"));
        existing.setName(dto.getName());
        existing.setPrice(dto.getPrice());
        return mapper.toDto(repository.save(existing));
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
