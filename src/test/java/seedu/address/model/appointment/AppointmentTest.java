package seedu.address.model.appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.model.appointment.Appointment.DATE_FORMAT;

class AppointmentTest {

    @Test
    public void isValidDate_nullDate_returnsTrue() {
        assertTrue(Appointment.isValidDate(null));
    }

    @Test
    public void isValidDate_validDate_returnsTrue() {
        assertTrue(Appointment.isValidDate("01-01-2020"));
    }

    @Test
    public void isValidDate_invalidDate_returnsFalse() {
        assertFalse(Appointment.isValidDate("01-01-2020 12:00"));
    }

    @Test
    public void parseLocalDate_validDate_returnsLocalDate() {
        assertEquals(LocalDate.parse("01-01-2020", DateTimeFormatter.ofPattern(DATE_FORMAT)),
                Appointment.parseLocalDate("01-01-2020"));
    }

    @Test
    public void parseLocalDate_invalidDate_throwsDateTimeParseException() {
        assertThrows(DateTimeParseException.class, () -> Appointment.parseLocalDate("01-01-2020 12:00"));
    }

}