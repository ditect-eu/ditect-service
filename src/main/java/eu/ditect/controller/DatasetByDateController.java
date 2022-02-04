package eu.ditect.controller;

import eu.ditect.domain.DateRange;
import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.service.query.QueryService;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/metric/")
@RequiredArgsConstructor
class DatasetByDateController {

  private final QueryService<DateRange, List<DatasetWithoutFileData>> findMetricByDateRangeSrv;

  @GetMapping("date/{from:.+}/{to:.+}")
  ResponseEntity<List<DatasetWithoutFileData>> getMetrics(
      @PathVariable Instant from, @PathVariable Instant to) {

    return ResponseEntity.ok(findMetricByDateRangeSrv.search(new DateRange(from, to)));
  }

}
