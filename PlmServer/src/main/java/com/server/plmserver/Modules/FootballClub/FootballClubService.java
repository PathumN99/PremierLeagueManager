package com.server.plmserver.Modules.FootballClub;

import com.server.plmserver.Entities.FootballClubEntity;
import com.server.plmserver.Entities.StudentEntity;
import com.server.plmserver.Repositories.FootballClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballClubService {

    private final FootballClubRepository footballClubRepository;

    public FootballClubService(FootballClubRepository footballClubRepository) {
        this.footballClubRepository = footballClubRepository;
    }

    public List<FootballClubEntity> findAllClubs() {
        return footballClubRepository.findAll();
    }

    public Optional<FootballClubEntity> findClub(Long id) {
        return footballClubRepository.findById(id);
    }

    public FootballClubEntity saveClub(FootballClubEntity footballClubEntity) {
        return footballClubRepository.save(footballClubEntity);
    }

    //    save method can be used for both create and update.
    public FootballClubEntity updateClub(FootballClubEntity footballClubEntity) {
        return footballClubRepository.save(footballClubEntity);
    }

    public String deleteClub(Long id) {
        footballClubRepository.deleteById(id);
        return "Record successfully deleted!";
    }
}
