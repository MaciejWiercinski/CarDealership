package pl.zajavka.integration.support;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public interface WiremockTestSupport {

    Map<String, String> VEHICLE_IDS = Map.of(
            "604539927931971", "pojazd-1.json",
            "1093515250696309", "pojazd-2.json",
            "8824220053690321", "pojazd-3.json",
            "3337520661164204", "pojazd-4.json",
            "346669836839359", "pojazd-5.json"
    );
    default void stubForSlowniki(WireMockServer wireMockServer) {
        wireMockServer.stubFor(
                WireMock.get(WireMock.urlPathMatching("/slowniki/wojewodztwa"))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/slowniki-wojewodztwa.json")));
    }

    default void stubForPojazdy(WireMockServer wireMockServer, String dateFrom, String dateTo) {
        Map<String, StringValuePattern> queryParamsPattern = Map.of(
                "data-od", equalTo(dateFrom.replace("-", "")),
                "data-do", equalTo(dateTo.replace("-", ""))
        );
        wireMockServer.stubFor(get(urlPathEqualTo("/pojazdy"))
                .withQueryParams(queryParamsPattern)
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/pojazdy.json")));
    }

    default void stubForPojzad(WireMockServer wireMockServer) {
        VEHICLE_IDS.forEach((vehicleId, fileName) -> wireMockServer.stubFor(get(urlPathEqualTo("/pojazdy/%s".formatted(vehicleId)))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/%s".formatted(fileName)))));
    }

}
