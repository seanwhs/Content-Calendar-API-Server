package sean.contentcalendarapi.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import sean.contentcalendarapi.model.Content;
import sean.contentcalendarapi.model.Status;
import sean.contentcalendarapi.model.Type;
import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer>{
    List<Content> findByTitleContaining(String keyword);
    @Query(
        """
                SELECT * from CONTENT 
                WHERE status = :status 
        """
    )
    List<Content> findByStatus(@Param("status") Status status);

      @Query(
        """
                SELECT * from CONTENT 
                WHERE content_type = :content_type 
        """
    )
    List<Content> findByType(@Param("content_type") Type type);
}
