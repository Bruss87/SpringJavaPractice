package com.example.FoldersFilesUsers.components;

import com.example.FoldersFilesUsers.models.File;
import com.example.FoldersFilesUsers.models.Folder;
import com.example.FoldersFilesUsers.models.User;
import com.example.FoldersFilesUsers.repositories.FileRepository;
import com.example.FoldersFilesUsers.repositories.FolderRepository;
import com.example.FoldersFilesUsers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;


    public void run(ApplicationArguments args){

        User zero = new User("zero");
        userRepository.save(zero);

        User monica = new User("monica");
        userRepository.save(monica);

        Folder work = new Folder("Work",monica );
        folderRepository.save(work);

        Folder downloads = new Folder("downloads", monica);
        folderRepository.save(downloads);

        File cv = new File("CV", "pdf", 70, work);
        fileRepository.save(cv);

        File notes = new File("notes", "txt", 35, work);
        fileRepository.save(notes);

        monica.addFolder(work);
        monica.addFolder(downloads);
        userRepository.save(monica);

        downloads.addFile(cv);
        folderRepository.save(downloads);

    }
}
