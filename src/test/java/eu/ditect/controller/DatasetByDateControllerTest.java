package eu.ditect.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.cli.CliDocumentation.curlRequest;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestBody;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseBody;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import eu.ditect.domain.DateRange;
import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.service.query.QueryService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class DatasetByDateControllerTest {

  private MockMvc mockMvc;
  private QueryService<DateRange, List<DatasetWithoutFileData>> mockService;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    mockService = mock(QueryService.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new DatasetByDateController(mockService))
        .apply(documentationConfiguration(restDocumentation)
            .snippets().withDefaults(curlRequest(), requestBody(), responseBody()))
        .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint())))
        .build();
  }

  @Test
  void findMetricByRange() throws Exception {
    when(mockService.search(any())).thenReturn(List.of(mock(DatasetWithoutFileData.class)));

    mockMvc.perform(get("/api/v1/metric/date/{from}/{to}",
        "2021-06-01T21:34:33.616Z", "2021-06-22T21:34:33.616Z"))
        .andExpect(status().isOk())
        .andDo(document("{method-name}",
            relaxedResponseFields(
                fieldWithPath("[].id").description("The metric unique id"),
                fieldWithPath("[].region").description("The geographic region of getting metric"),
                fieldWithPath("[].partner").description("The partner name"),
                fieldWithPath("[].pilotCode").description("The pilot code"),
                fieldWithPath("[].instrumentName").description("The instrument name"),
                fieldWithPath("[].typeOfAnalysis").description("The type of analysis"),
                fieldWithPath("[].packingStage").description("Is at packing stage"),
                fieldWithPath("[].manufacturingProcessing")
                    .description("Is manufacturing processing"),
                fieldWithPath("[].primaryProduction").description("Is primary production"),
                fieldWithPath("[].distributionRetail").description("Is distribution retail"),
                fieldWithPath("[].fileName").description("The uploaded file name"),
                fieldWithPath("[].country").description("The country of getting metric")
            )
        ));
  }


}