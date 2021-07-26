package fsb.aoc.clubmicroservice.web;

import fsb.aoc.clubmicroservice.entities.Club;
import fsb.aoc.clubmicroservice.repositories.ClubRepository;
import fsb.aoc.clubmicroservice.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClubController {

    @Autowired
    ClubRepository clubRepository;
    @Autowired
    ClubService clubService;

    @PostMapping("/clubs")
    public void ajouter(@RequestBody Club club){
        clubRepository.save(club);
    }
    @GetMapping("/clubs")
    public List<Club> getAll(){
        return clubRepository.findAll();
    }
    @DeleteMapping("/clubs/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        clubRepository.deleteById(id);
    }

    @PutMapping("/clubs/{id}")
    public void update(@PathVariable(name = "id") Long id,@RequestBody Club club){
        Club club1 = clubRepository.getById(id);
        club1.setNom(club.getNom());
        club1.setNomResp(club.getNomResp());

        clubRepository.save(club1);
    }

    @PatchMapping("/clubs/{id}")
    public void updateWithoutChange(@PathVariable(name = "id") Long id,@RequestBody Club club){
        clubService.updateWithoutChange(id,club);
    }
    @GetMapping("/clubs/byPrenom")
    public List<Club> findByPrenom(@RequestParam(name = "prenom") String prenom){
        return clubRepository.findByNomResp(prenom);
    }
}
