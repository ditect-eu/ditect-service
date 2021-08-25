*All information below is surmised by a non expert, copied and summarized from the respective wikipedia pages*

# Cranfield data

All csvs have a first column that represents an identifier which also contains information.
* Temperature it was stored in
* Spoilage
    * A is early spoilage stage
    * B is end of shelf life / spoiled
    * Z?

CSV files are sorted by type of packaging
* MAP - Modified Air Packaging
* AIR - stored in air
* ENOSE - unclear why this is a separate folder

## FTIR
obtains an infrared spectrum of absorption or emission of a solid, liquid or gas. Data represents a spectrum of wavelengths that can be plotted in a graph. 

Rows represent individual samples and columns are intensity levels for a given wavelength. Column headers are arbitrary wavelengths on the x-axis and thus vary depending on the resolution.

## HPLC
Uses the adsorption (not to be confused with absorption) of the sample in a mixture. Each component in the sample interacts slightly differently with the adsorbent material, causing different flow rates for the different components and leading to the separation of the components as they flow out of the column.
The columns represent concentrations for certain substances. As such, they are mappable to concepts (as opposed to the spectra where column headers are potentially infinite).

## GCMS
Combination of Gas Chromatography and Mass Spectrometry. A mass spectrometer is typically utilized in one of two ways: full scan or selective ion monitoring (SIM). The typical GC-MS instrument is capable of performing both functions either individually or concomitantly, depending on the setup of the particular instrument (**Sounds like a parameter to supply**).
The columns represent  for certain substances. As such, they are mappable to concepts (as opposed to the spectra where column headers are potentially infinite).

### Types
(**Do we need to distinguish between these?**)
* Partition chromatography
* Displacement chromatography
* Reversed-phase chromatography (RPC)
* Size-exclusion chromatography
* Ion-exchange chromatography
* Bioaffinity chromatography
* Aqueous normal-phase chromatography

### Parameters
* Theoretical
* Internal diameter
* Particle size
* Pore size
* Pump pressure
* Detectors
* Autosamplers

## eNose
An electronic nose intended to odors and flavours. As a first step, an electronic nose needs to be trained with qualified samples so as to build a database of reference. Then the instrument can recognize new samples by comparing a volatile compound's fingerprint to those contained in its database. Thus they can perform qualitative or quantitative analysis.
The columns represent responses from the different types of sensors, for example:
*There are two types of sensors currently used: P & T sensors implemented in chambers A and B and LY2 sensors used in chamber CL. Their specific names are LY2/LG, LY2/G, LY2/AA, LY2/GH, LY2/gCTl, LY2/gCT, T30/1, P10/1, P10/2, P40/1, T70/2, PA/2, P30/1, P40/2, P30/2, T40/2, T40/1, and TA/2. *
(https://doi.org/10.1007/s11947-014-1407-6)
This would imply that these columns can also be mapped to standardized concepts.