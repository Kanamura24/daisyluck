package com.example.daisy.repository;

import com.example.daisy.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  @Query(value = "select i from Item i where i.title like %?1% ")
  List<Item> findByTitle(@Param("title") String title);
}
