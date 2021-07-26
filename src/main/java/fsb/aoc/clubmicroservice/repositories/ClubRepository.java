package fsb.aoc.clubmicroservice.repositories;

import fsb.aoc.clubmicroservice.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club,Long> {
    List<Club> findByNomResp(String prenom);
}
