package eu.ditect.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.restdocs.cli.CliDocumentation.curlRequest;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestBody;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestPartFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseBody;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import eu.ditect.domain.MetricMetaRequest;
import eu.ditect.service.MutateSrv;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class UploadFileMetricControllerTest {

  private MockMvc mockMvc;
  private MutateSrv<MetricMetaRequest, String> mockService;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    mockService = mock(MutateSrv.class);
    this.mockMvc = MockMvcBuilders.standaloneSetup(new UploadFileMetricController(mockService))
        .apply(documentationConfiguration(restDocumentation)
            .snippets().withDefaults(curlRequest(), requestBody(), responseBody()))
        .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint())))
        .build();
  }

  @Test
  void upload() throws Exception {
    var meta = "{\n"
        + "\"partner\": \"VIDEOM\",\n"
        + "\"pilotCode\": \"P4-Fish\",\n"
        + "\"region\": \"EU\",\n"
        + "\"country\": \"Cyprus\",\n"
        + "\"manufacturingProcessing\":true,\n"
        + "\"primaryProduction\":true,\n"
        + "\"distributionRetail\":true,\n"
        + "\"packingStage\": true,\n"
        + "\"instrumentName\": \"a name\",\n"
        + "\"typeOfAnalysis\": \"a type of\"\n"
        + "}";

    MockMultipartFile mockFile = new MockMultipartFile(
        "file", "hello.txt", TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
    MockMultipartFile metaJson = new MockMultipartFile("meta", null,
        "application/json", meta.getBytes());

    when(mockService.mutate(any(), any())).thenReturn(UUID.randomUUID().toString());

    this.mockMvc
        .perform(multipart("/api/v1/metric/file/upload")
            .file(mockFile)
            .file(metaJson)
        )
        .andExpect(status().isCreated())
        .andDo(document("{method-name}",
            requestPartFields("meta",
                fieldWithPath("partner").description("The partner acronym."),
                fieldWithPath("pilotCode").description("I don't know"),
                fieldWithPath("region").description("The partner acronym."),
                fieldWithPath("country").description("The partner acronym."),
                fieldWithPath("manufacturingProcessing").description("The partner acronym."),
                fieldWithPath("primaryProduction").description("The partner acronym."),
                fieldWithPath("distributionRetail").description("The partner acronym."),
                fieldWithPath("packingStage").description("The partner acronym."),
                fieldWithPath("instrumentName").description("The partner acronym."),
                fieldWithPath("typeOfAnalysis").description("The partner acronym.")
            )
        ))
    ;
  }

}