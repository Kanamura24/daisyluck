package com.example.daisy.controllers;

import com.example.daisy.domain.Item;
import com.example.daisy.domain.ItemForm;
import com.example.daisy.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/daisy")
public class TodolistController {

  private final ItemService itemService;

  public TodolistController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping
  public String home(Model model, ItemForm itemForm) {
    List<Item> items = itemService.findAll();
    model.addAttribute("items", items);
    return "todolist/Home";
  }

  @GetMapping("edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    Item item = itemService.findOne(id);
    model.addAttribute("item", item);
    return "todolist/Edit";
  }

  @PostMapping("register")
  public String create(@Validated @ModelAttribute ItemForm itemForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "todolist/Home";
    }
    itemService.formSave(itemForm);
    return "redirect:/daisy/";
  }

  @PatchMapping("/toggle-status/{id}")
  public String changeStatus(@PathVariable Long id) {
    Item item = itemService.findOne(id);
    System.out.println(item.isStatus());
    item.setStatus(!item.isStatus());
    itemService.save(item);

    return "redirect:/daisy/";
  }

  @PutMapping("edit/{id}/complete")
  public String update(
      @PathVariable Long id, @Validated @ModelAttribute Item item, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "todolist/Edit";
    }
    item.setId(id);
    itemService.save(item);
    return "redirect:/daisy/";
  }

  @DeleteMapping("{id}")
  public String destroy(@PathVariable Long id) {
    itemService.delete(id);
    return "redirect:/daisy/";
  }

  @GetMapping("luck")
  public String search() {
    return "todolist/Search";
  }

  @GetMapping("luck/msg")
  public String result(@RequestParam(value = "title", required = false) String title, Model model) {
    List<Item> items = itemService.getItems(title);
    // System.out.println(items.size());
    if (items.size() == 1) {
      Item item = items.get(0);
      // System.out.println(item.getId());
      Long id = item.getId();

      return edit(id, model);
    }
    model.addAttribute("items", items);
    return "todolist/Search";
  }
}
