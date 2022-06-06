package pe.com.scotiabank.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.scotiabank.question.model.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
