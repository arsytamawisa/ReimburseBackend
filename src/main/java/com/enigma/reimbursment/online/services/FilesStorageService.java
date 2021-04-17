package com.enigma.reimbursment.online.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {

     void init();

     void save(MultipartFile file, String filename);

     Resource load(String filename);

     void deleteById(String filename, Integer port);

     Stream<Path> loadAll();
}
