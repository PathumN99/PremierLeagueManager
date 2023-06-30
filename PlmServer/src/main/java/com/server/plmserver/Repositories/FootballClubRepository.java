package com.server.plmserver.Repositories;

import com.server.plmserver.Entities.FootballClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballClubRepository extends JpaRepository<FootballClubEntity, Long> {
}
