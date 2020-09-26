package com.example.daisy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate deadline;

  private boolean status;

  private String elemNoun;

  private String elemTime;

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

  @Override
  public String toString() {
    return "item [id="
        + id
        + ", title="
        + title
        + ", deadline="
        + deadline
        + ", status"
        + status
        + ", elemNoun"
        + elemNoun
        + ", elemTime"
        + elemTime
        + "]";
  }
}
