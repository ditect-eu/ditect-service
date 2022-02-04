package eu.ditect.domain.mongo;

import eu.ditect.domain.License;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an experiment made up of one or more datasets.
 */
@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experiment {
  @Id
  private String id;
  private String name;
  private String description;
  private String contact;
  private License license;
  @DBRef
  private List<Dataset> datasets;

  //TODO: What data we need? userName,userId or both ??
  @CreatedBy
  private AuditUser createdBy;

  @Indexed
  @CreatedDate
  private Instant insertionDate;
}