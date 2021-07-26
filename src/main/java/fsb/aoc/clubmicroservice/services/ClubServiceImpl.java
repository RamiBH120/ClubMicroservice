package fsb.aoc.clubmicroservice.services;

import fsb.aoc.clubmicroservice.entities.Club;
import fsb.aoc.clubmicroservice.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Override
    public void updateWithoutChange(Long id, Club club) {
        Club club1 = clubRepository.getById(id);
        if ( club.getNom() != null){
            club1.setNom(club.getNom());
        }
        if ( club.getNomResp() != null) {
            club1.setNomResp(club.getNomResp());
        }
        clubRepository.save(club1);
    }
}
