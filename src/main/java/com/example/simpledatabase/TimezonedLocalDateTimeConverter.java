package com.example.simpledatabase;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Converter
public class TimezonedLocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    private String cmsTimeZone = ZoneId.systemDefault().toString();

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if (cmsTimeZone.isEmpty()) {
            cmsTimeZone = "UTC";
        }
        if (attribute == null) {
            return null;
        }
        LocalDateTime newDateTime = attribute.atZone(ZoneId.of("UTC"))
                .withZoneSameInstant(ZoneId.of(cmsTimeZone))
                .toLocalDateTime();

        return Timestamp.valueOf(newDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        LocalDateTime newDateTime = dbData.toLocalDateTime().atZone(ZoneId.of(cmsTimeZone))
                .withZoneSameInstant(ZoneId.of("UTC"))
                .toLocalDateTime();
        return newDateTime;
    }
}