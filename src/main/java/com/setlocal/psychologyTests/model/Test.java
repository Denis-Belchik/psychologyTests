package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private Integer id;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="date_create")
    private LocalDateTime date_create;

    @Column(name="date_last_save")
    private LocalDateTime date_last_save;

    @Column(name = "group_quest")
    private int group_quest;

    @Column(name = "size")
    private int size;

    @Column(name = "scale")
    private int scale;

    @OneToMany(mappedBy = "test")
    private List<Question> questions = new ArrayList<>();
}