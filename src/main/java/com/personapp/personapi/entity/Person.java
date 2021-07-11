package com.personapp.personapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length = 80,nullable = false)
  private String firstName;
  @Column(length = 80,nullable = false)
  private String lastName;
  @Column(unique = true,nullable = false)
  private String cpf;
  private LocalDate birthDate;
  @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval = true)
  @JoinColumn
  private List<Phone> phones=new ArrayList<>();
}
