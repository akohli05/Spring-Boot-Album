import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.albums.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}