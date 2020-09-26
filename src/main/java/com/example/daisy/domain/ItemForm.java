package com.example.daisy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ItemForm {

  private String title;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate deadline;

  private String elemNoun;

  private String elemTime;

  private boolean status;

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

  public String getElemNoun() {
    return elemNoun;
  }

  public void setElemNoun(String elemNoun) {
    this.elemNoun = elemNoun;
  }

  public String getElemTime() {
    return elemTime;
  }

  public void setElemTime(String elemTime) {
    this.elemTime = elemTime;
  }
}
