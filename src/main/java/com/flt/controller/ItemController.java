package com.flt.controller;


import com.flt.dto.ItemDTO;
import com.flt.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public String listItems(Model model) {
        List<ItemDTO> items = service.getAllItems();
        model.addAttribute("items", items);
        return "item_list";
    }

    @GetMapping("/new")
    public String newItemForm(Model model) {
        model.addAttribute("item", new ItemDTO());
        return "item_form";
    }

    @PostMapping("/save")
    public String createOrUpdateItem(@ModelAttribute ItemDTO item) {
        if (item.getId() != null) {
            service.updateItem(item.getId(), item);
        } else {
            service.createItem(item);
        }
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        ItemDTO item = service.getItemById(id);
        model.addAttribute("item", item);
        return "item_form"; // Reuse the same form for editing
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "redirect:/items";
    }
}

