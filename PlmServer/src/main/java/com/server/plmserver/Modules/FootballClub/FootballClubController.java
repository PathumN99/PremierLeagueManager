package com.server.plmserver.Modules.FootballClub;

import com.server.plmserver.Entities.FootballClubEntity;
import com.server.plmserver.Entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/football-club")
public class FootballClubController {

    private final FootballClubService footballClubService;

    @Autowired
    public FootballClubController(FootballClubService footballClubService) {
        this.footballClubService = footballClubService;
    }

    @GetMapping
    public List<FootballClubEntity> findAllClubs() {
        return footballClubService.findAllClubs();
    }

    @GetMapping("/{id}")
    public Optional<FootballClubEntity> findClub(@PathVariable Long id) {
        return footballClubService.findClub(id);
    }

    @PostMapping
    public FootballClubEntity saveClub(@RequestBody FootballClubEntity footballClubEntity) {
        return footballClubService.saveClub(footballClubEntity);
    }

    @PutMapping("/update/{id}")
    public FootballClubEntity updateStudent(@PathVariable Long id, @RequestBody FootballClubEntity footballClubEntity) {
        footballClubEntity.set_id(id);
        return footballClubService.updateClub(footballClubEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return footballClubService.deleteClub(id);
    }

}
