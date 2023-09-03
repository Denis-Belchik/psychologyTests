package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.mapper.model.AnswerMapper;
import com.setlocal.psychologyTests.mapper.model.AnswerPersonMapper;
import com.setlocal.psychologyTests.model.AnswerPerson;
import com.setlocal.psychologyTests.repository.answerPerson.AnswerPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("session")
@RequiredArgsConstructor
public class TestResultService {

    private final AnswerPersonRepository answerPersonRepository;
    private final AnswerPersonMapper answerPersonMapper;

    private final Map<Integer, List<Integer>> repositoryResultTest = new LinkedHashMap<>();

    public void addResult(AnswerPersonDTO answerPersonDTO) {
        List<Integer> list;
        if (answerPersonDTO.getPositionAnswer() == null) {
            list = new ArrayList<>(List.of(0));
        } else {
            list = answerPersonDTO.getPositionAnswer();
        }
        repositoryResultTest.put(answerPersonDTO.getQuestionID(), list);

        save(answerPersonMapper.mapToEntity(answerPersonDTO));
    }

    private void save(AnswerPerson answerPerson) {
        answerPersonRepository.save(answerPerson);
    }

    public Collection<List<Integer>> getResultQuest() {
        return Collections.unmodifiableCollection(repositoryResultTest.values());
    }

    public void resultClear() {
        repositoryResultTest.clear();
    }
}