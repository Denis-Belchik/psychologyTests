package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "test", schema = "psychology_tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t")
    private int id;

    @Column(name = "title_test")
    private String title;

    @OneToMany(mappedBy = "test")
    private List<Question> questions = new ArrayList<>();
}