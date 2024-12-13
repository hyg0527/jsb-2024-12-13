package com.example.demo;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

//    @Transactional
    @Test
    void testJpa() {
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if (oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }

//        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());

//        List<Question> questions = questionRepository.findBySubjectLike("sbb%");
//        Question q = questions.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());

//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent()); // false일 시 바로 테스트 종료.
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);

//        assertEquals(2, questionRepository.count());
//        Optional<Question> question = questionRepository.findById(1);
//        assertTrue(question.isPresent());
//        Question q = question.get();
//        questionRepository.delete(q);
//        assertEquals(1, questionRepository.count());

//        Optional<Question> oq = questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);
//        a.setCreateDate(LocalDateTime.now());
//        answerRepository.save(a);

//        Optional<Answer> oa = answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());

//        Optional<Question> oq = questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용";
//            questionService.create(subject, content, null);
//        }

        // 답변 테스트 데이터 생성
        Optional<Question> question = questionRepository.findById(1215);
        assertTrue(question.isPresent());
        Question q = question.get();

        for (int i = 0; i < 200; i++) {
            String content = String.format("%d번째 답글", i + 1);
            answerService.create(q, content, null);
        }
    }
}
