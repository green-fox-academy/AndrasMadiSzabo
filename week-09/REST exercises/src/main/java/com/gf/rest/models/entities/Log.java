package com.gf.rest.models.entities;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

//@Entity
public class Log {
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private long id;
//
//  @OneToMany(mappedBy = "log")


  private List<LogEntry> entries;
  private int entry_count;

  public Log(List<LogEntry> entries, int entry_count) {
    this.entries = entries;
    this.entry_count = entry_count;
  }
}
