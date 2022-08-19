package patientintake.notifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import patientintake.ClinicCalendar;
import patientintake.Doctor;
import patientintake.PatientAppointment;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UpcomingAppointmentNotifierShould {

    private EmailNotifierDouble emailDouble;

    @BeforeEach
    void init() {
        emailDouble = new EmailNotifierDouble();
    }

    @Test
    void sendNotificationWithCorrectFormat() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.of(2018, 8, 26));
        calendar.addAppointment("Jim", "Weaver", "avery",
                "08/27/2018 2:00 pm");
        UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar, emailDouble);

        notifier.run();

        assertEquals(1, emailDouble.receivedMessages.size());
        EmailNotifierDouble.Message expectedMessage = emailDouble.receivedMessages.get(0);
        assertAll(
                () -> assertEquals("weaverjim@mail.com", expectedMessage.getToAddress()),
                () -> assertEquals("Appointment Reminder", expectedMessage.getSubject()),
                () -> assertEquals("You have an appointment tomorrow at 2:00 PM" +
                        " with Dr. Ralph Avery.", expectedMessage.getBody())
        );
    }

}
