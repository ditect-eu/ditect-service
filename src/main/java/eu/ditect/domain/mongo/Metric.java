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
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Represent an instrument metric with meta data.
 */
@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Metric {

  @Id
  private String id;
  @Field("ditect:partnerCode")
  private String partner;
  @Field("ditect:pilotCode")
  private String pilotCode;
  @Field("schema:country")
  private String country;
  @Field("schema:region")
  private Region region;
  @Field("ditect:manufacturingProcessing")
  private boolean manufacturingProcessing;
  @Field("ditect:primaryProduction")
  private boolean primaryProduction;
  @Field("ditect:distributionRetail")
  private boolean distributionRetail;
  @Field("ditect:packingStage")
  private boolean packingStage;
  @Field("ditect:instrumentName")
  private String instrumentName;
  @Field("ditect:typeOfAnalysis")
  private String typeOfAnalysis;
  @Field("schema:dateCreated")
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

}
