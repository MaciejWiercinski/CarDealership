package pl.zajavka.business;

import lombok.AllArgsConstructor;
import pl.zajavka.business.management.FileDataPreparationService;
@AllArgsConstructor
public class CarPurchaseService {

    private final FileDataPreparationService fileDataPreparationService;
    public void purchase() {
        fileDataPreparationService.prepareFirstTimePurchaseData();
        fileDataPreparationService.prepareNextTimePurchaseData();
    }
}
