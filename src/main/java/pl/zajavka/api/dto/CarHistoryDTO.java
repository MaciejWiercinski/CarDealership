package pl.zajavka.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.metadata.ManagedOperation;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarHistoryDTO {

    private String carVin;
    private List<ServiceRequestDTO> carServiceRequests;

    public static CarHistoryDTO buildDefault() {
        return CarHistoryDTO.builder()
                .carVin("empty")
                .carServiceRequests(Collections.emptyList())
                .build();
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServiceRequestDTO {
        private String carServiceRequestNumber;
        private String receivedDateTime;
        private String completedDateTime;
        private String customerComment;
        private List<ServiceDTO> services;
        private List<PartDTO> parts;
    }
}
