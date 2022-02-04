package eu.ditect.domain.projection;

import eu.ditect.domain.License;
import java.util.List;

public interface ExperimentResponse {
  String getId();
  String getName();
  String getDescription();
  String getContact();
  License getLicense();
  List<DatasetWithoutFileData> getDatasets();
}
