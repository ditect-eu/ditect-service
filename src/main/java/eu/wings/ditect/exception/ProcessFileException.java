package eu.wings.ditect.exception;

/**
 * Unchecked exception when precess files.
 */
public class ProcessFileException extends RuntimeException {

  public ProcessFileException(String message, Throwable cause) {
    super(message, cause);
  }
}
