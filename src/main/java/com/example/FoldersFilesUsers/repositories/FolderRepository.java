package com.example.FoldersFilesUsers.repositories;

import com.example.FoldersFilesUsers.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository <Folder, Long> {
}