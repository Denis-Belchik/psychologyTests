package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="answer_key", schema="psychology_tests")
public class AnswerKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ak")
    private int id;

    @Column(name = "position")
    private int position;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
