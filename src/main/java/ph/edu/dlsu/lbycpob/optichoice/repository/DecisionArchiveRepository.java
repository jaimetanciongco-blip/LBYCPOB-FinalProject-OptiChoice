package ph.edu.dlsu.lbycpob.optichoice.repository;

import ph.edu.dlsu.lbycpob.optichoice.model.DecisionArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionArchiveRepository extends JpaRepository<DecisionArchive, Long> {
    List<DecisionArchive> findByUsername(String username);
}