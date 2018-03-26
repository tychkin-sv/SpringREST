package ua.tsv.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tsv.restful.entity.Remind;

public interface RemindRepository extends JpaRepository<Remind, Long> {

}
