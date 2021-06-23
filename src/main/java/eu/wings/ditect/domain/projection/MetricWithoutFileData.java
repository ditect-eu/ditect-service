package eu.wings.ditect.domain.projection;


import eu.wings.ditect.domain.Region;

/**
 * Represents a metric without file content.
 */
public interface MetricWithoutFileData {

  String getId();

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
