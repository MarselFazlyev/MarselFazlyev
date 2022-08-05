import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoRepository;
import ru.netology.patient.service.alert.SendAlertService;
import ru.netology.patient.service.medical.MedicalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicalServiceImplTest {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Начало тестирования класса MedicalServiceImpl");
    }

    @Test
    public void messageAboutBloodPressureAndTemperatureShouldBeCalledTwoTimes() {
        BloodPressure currentPressure = new BloodPressure(60, 120);
        BigDecimal currentTemperature = new BigDecimal("34.0");
        PatientInfo patientInfo = new PatientInfo("01", "Иван", "Петров", LocalDate.of(1980, 11, 26),
                new HealthInfo(new BigDecimal("36.65"), new BloodPressure(120, 80)));
        PatientInfoRepository patientInfoRepository = Mockito.mock(PatientInfoRepository.class);
        SendAlertService sendAlertService = Mockito.mock(SendAlertService.class);
        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, sendAlertService);

        Mockito.doReturn(patientInfo).when(patientInfoRepository).getById("01");
//       вызов метода checkBloodPressure (в нем должен быть вызван один раз метод  public void send
        medicalService.checkBloodPressure("01", currentPressure);
//        проверка условия, что метод send вызван один раз.
        Mockito.verify(sendAlertService, Mockito.only()).send(Mockito.any());

        //УСЛОВИЕ ВЫЗОВА МЕТОДА send для проверки температуры некорректно!!!!!!
        // Придется тестить нереальное значение текущей температуры для вызова метода send
        medicalService.checkTemperature("01", currentTemperature);
//      проверка вызова send второй раз.
        Mockito.verify(sendAlertService, Mockito.times(2)).send(Mockito.any());
    }

    @Test
    public void messageAboutBloodPressureAndTemperatureShouldNotBeCalledEver() {
        BloodPressure currentPressure = new BloodPressure(120, 80);
        BigDecimal currentTemperature = new BigDecimal("36.6");
        PatientInfo patientInfo = new PatientInfo("01", "Иван", "Петров", LocalDate.of(1980, 11, 26),
                new HealthInfo(new BigDecimal("36.65"), new BloodPressure(120, 80)));
        PatientInfoRepository patientInfoRepository = Mockito.mock(PatientInfoRepository.class);
        SendAlertService sendAlertService = Mockito.mock(SendAlertService.class);
        MedicalServiceImpl medicalService = new MedicalServiceImpl(patientInfoRepository, sendAlertService);

        Mockito.doReturn(patientInfo).when(patientInfoRepository).getById("01");

        medicalService.checkTemperature("01", currentTemperature);
        medicalService.checkBloodPressure("01", currentPressure);

        Mockito.verify(sendAlertService, Mockito.never()).send(Mockito.any());

    }

    @BeforeAll
    public static void finishTesting() {
        System.out.println("Завершение  тестирования класса MedicalServiceImpl");
    }


}
