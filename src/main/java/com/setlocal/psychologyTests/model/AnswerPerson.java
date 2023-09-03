package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="answer_person", schema="psychology_tests")
public class AnswerPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ap")
    private int id;

    @Column(name = "person_username")
    private String username;

    @Column(name = "question_id")
    private int questionID;

    @Column(name = "position")
    private List<Integer> positionAnswer;

}
