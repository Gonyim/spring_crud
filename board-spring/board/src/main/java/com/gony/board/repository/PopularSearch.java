package com.gony.board.repository;

import com.gony.board.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSearch extends JpaRepository<PopularSearchEntity, String> {
}
