package eu.ditect.domain.projection;

import org.bson.types.Binary;

/**
 * Represents the file with binary data.
 */
public interface FileContent {

  String getFileName();

  Binary getFile();
}
