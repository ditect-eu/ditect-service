package eu.ditect.domain;

import eu.ditect.domain.mongo.Dataset;
import java.util.List;
import lombok.Data;

@Data
public class ExperimentRequest {
  private String id;
  private String name;
  private String description;
  private String contact;
  private License license;
  private List<Dataset> datasets;
}
