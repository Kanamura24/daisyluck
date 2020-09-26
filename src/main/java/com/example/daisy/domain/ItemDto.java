package com.example.daisy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ItemDto {
  private Long id;

  private String title;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate deadline;

  private boolean status;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate createTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public LocalDate getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDate createTime) {
    this.createTime = createTime;
  }

  public LocalDate getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDate updateTime) {
    this.updateTime = updateTime;
  }
}
