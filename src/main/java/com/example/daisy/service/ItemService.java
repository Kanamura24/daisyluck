package com.example.daisy.service;

import com.example.daisy.domain.Item;
import com.example.daisy.domain.ItemForm;
import com.example.daisy.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ItemService {
  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> findAll() {
    return itemRepository.findAll();
  }

  public Item findOne(Long id) {
    return itemRepository.findById(id).orElseThrow();
  }

  public Item save(Item item) {
    return itemRepository.save(item);
  }

  public Item formSave(ItemForm itemForm) {
    Item item = new Item();
    item.setTitle(itemForm.getTitle());
    item.setDeadline(itemForm.getDeadline());
    item.setElemNoun(itemForm.getElemNoun());
    item.setElemTime(itemForm.getElemTime());
    item.setStatus(itemForm.isStatus());
    return itemRepository.save(item);
  }

  public void delete(Long id) {
    itemRepository.deleteById(id);
  }

  public List<Item> getItems(String title) {
    return itemRepository.findByTitle(title);
  }
}
