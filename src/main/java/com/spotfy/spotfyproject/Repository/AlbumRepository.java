package com.spotfy.spotfyproject.Repository;

import com.spotfy.spotfyproject.Model.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumModel,Integer> {
}
