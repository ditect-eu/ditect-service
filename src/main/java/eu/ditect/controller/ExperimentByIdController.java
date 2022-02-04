package eu.ditect.controller;

import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.service.query.QueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/experiment")
@RequiredArgsConstructor
class ExperimentByIdController {
  private final QueryService<String, List<ExperimentResponse>> findExperimentSrv;

  @GetMapping("{experimentid}")
  ResponseEntity<List<ExperimentResponse>> getExperiment(@PathVariable("experimentid") String experimentId) {
    return ResponseEntity.ok(findExperimentSrv.search(experimentId));
  }
}