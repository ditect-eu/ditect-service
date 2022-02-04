package eu.ditect.domain.projection;


import eu.ditect.domain.Region;

/**
 * Represents a metric without file content.
 */
public interface DatasetWithoutFileData {

  String getId();

  String getExperimentId();

  String getPartner();

  String getPilotCode();

  Region getRegion();

  String getCountry();

  boolean getManufacturingProcessing();

  boolean getPrimaryProduction();

  boolean getDistributionRetail();

  boolean getPackingStage();

  String getInstrumentName();

  String getTypeOfAnalysis();

  String getFileName();
}
