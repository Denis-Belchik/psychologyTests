package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="question", schema="psychology_tests")
public class Question {

    public enum TypeAnswer {
        RADIO,
        CHECKBOX
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_q")
    private int id;

    @Column(name = "body_question")
    private String bodyQuestion;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeAnswer type;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
}