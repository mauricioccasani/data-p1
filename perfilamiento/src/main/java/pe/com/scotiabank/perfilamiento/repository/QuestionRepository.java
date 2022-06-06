package pe.com.scotiabank.perfilamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.scotiabank.perfilamiento.model.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
