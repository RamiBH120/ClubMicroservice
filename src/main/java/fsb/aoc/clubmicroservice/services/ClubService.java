package fsb.aoc.clubmicroservice.services;


import fsb.aoc.clubmicroservice.entities.Club;

public interface ClubService {

    public void updateWithoutChange( Long id, Club club);

}
