package eu.ditect.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Save file content into database.
 *
 * @param <T> the input(request) data type.
 * @param <R> the return type.
 */
public interface MutateSrv<T, R> {

  R mutate(MultipartFile file, T data);
}
