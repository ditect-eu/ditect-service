package eu.ditect.domain.mongo;

import eu.ditect.domain.Region;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represent an instrument metric with meta data.
 */
@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dataset {

  @Id
  private String id;
  private String experimentId;
  private String partner;
  private String pilotCode;
  private String country;
  private Region region;
  private boolean manufacturingProcessing;
  private boolean primaryProduction;
  private boolean distributionRetail;
  private boolean packingStage;
  private String instrumentName;
  private String typeOfAnalysis;
  private Instant createdDate;
  /**
   * The actual metrics data.
   */
  private List<Map<String, Object>> data;

  /**
   * Small files (size <16MB).
   */
  private Binary file;
  private String fileName;

  //TODO: What data you need? userName,userId or both ??
  @CreatedBy
  private AuditUser createdBy;

  @Indexed
  @CreatedDate
  private Instant insertionDate;

  private String licensingInformation;
  private String authors;
  private String shortDescription;
  private String titleOfDocument;
  private boolean maze;
  private boolean poultry;
  private boolean fish;
  private boolean beef;
}
