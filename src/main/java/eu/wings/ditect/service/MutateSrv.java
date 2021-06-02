package eu.wings.ditect.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Save file content into database.
 *
 * @param <R> the return type.
 */
public interface MutateSrv<R> {

  R mutate(MultipartFile file);
}
