package eu.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import eu.ditect.domain.ExperimentRequest;
import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.service.MutateExperimentSrv;
import eu.ditect.service.query.QueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/experiment")
@RequiredArgsConstructor
public class ExperimentController {
  private final MutateExperimentSrv mutateExperimentSrv;
  private final QueryService<String, List<ExperimentResponse>> findExperimentSrv;

  @GetMapping("")
  ResponseEntity<List<ExperimentResponse>> getExperiments() {
    return ResponseEntity.ok(findExperimentSrv.search(""));
  }

  @PostMapping("")
  ResponseEntity<String> postExperiment(@RequestBody ExperimentRequest experiment) {
    return new ResponseEntity<>(mutateExperimentSrv.store(experiment), CREATED);
  }

  @PutMapping("{experimentid}")
  ResponseEntity<String> putExperiment(@PathVariable("experimentid") String experimentId,
                                       @RequestBody ExperimentRequest experiment) {
    return new ResponseEntity<>(mutateExperimentSrv.store(experimentId, experiment), CREATED);
  }

  @DeleteMapping("{experimentid}")
  ResponseEntity<String> deleteExperiment(@PathVariable("experimentid") String experimentId) {
    mutateExperimentSrv.deleteExperiment(experimentId);
    return new ResponseEntity<>(null, OK);
  }
}
