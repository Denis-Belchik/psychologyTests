package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.mapper.model.AnswerPersonMapper;
import com.setlocal.psychologyTests.repository.answerPerson.AnswerPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("session")
@RequiredArgsConstructor
public class TestResultService {

//    private Optional<Integer> replay =  Optional.empty();;
    private Integer replay =  null;

    private final AnswerPersonRepository answerPersonRepository;
    private final AnswerPersonMapper answerPersonMapper;
    private final PersonService personService;

    private final Map<Integer, List<Integer>> repositoryResultTest = new LinkedHashMap<>();

    public void addResult(AnswerPersonDTO answerPersonDTO) {
        if (replay == null) {
            replay = answerPersonRepository.findReplayByUsernameAndTestId(
                    personService.showAuthPerson().getUsername(), answerPersonDTO.getTestId()).orElse(0);
            replay++;
        }
        List<Integer> list;
        if (answerPersonDTO.getPositionAnswer() == null) {
            list = new ArrayList<>(List.of(0));
            answerPersonDTO.setPositionAnswer(List.of(0));
        } else {
            list = answerPersonDTO.getPositionAnswer();
        }

        repositoryResultTest.put(answerPersonDTO.getQuestionID(), list);

        answerPersonDTO.setReplay(replay);
        answerPersonDTO.setReplacement(1);
        answerPersonDTO.setUsername(personService.showAuthPerson().getUsername());
        answerPersonRepository.save(answerPersonMapper.mapToEntity(answerPersonDTO));
    }

    public Collection<List<Integer>> getResultQuest() {
        return Collections.unmodifiableCollection(repositoryResultTest.values());
    }

    public void resultClear() {
        replay = null;
        repositoryResultTest.clear();
    }
}