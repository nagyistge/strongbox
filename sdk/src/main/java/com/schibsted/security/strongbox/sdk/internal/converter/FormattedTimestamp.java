/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Schibsted Products & Technology AS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.schibsted.security.strongbox.sdk.internal.converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.util.Locale.ENGLISH;

/**
 * Convenience methods to handle timestamp formatting
 *
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 *
 * @author stiankri
 */
public class FormattedTimestamp {
    private static final ZoneId utc = ZoneId.of("UTC");
    private static final DateTimeFormatter humanReadableFormatter = DateTimeFormatter.ofPattern("EEE MMM d u HH:mm:ss zzz", ENGLISH);
    private static final DateTimeFormatter comparableFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    private static final DateTimeFormatter localDate = DateTimeFormatter.ISO_LOCAL_DATE;


    public static String nowUTC() {
        ZonedDateTime localNow = ZonedDateTime.now();
        ZonedDateTime utcNow = localNow.withZoneSameInstant(utc);
        return utcNow.format(comparableFormatter);
    }

    public static ZonedDateTime now() {
        return ZonedDateTime.now(utc);
    }

    public static String from(ZonedDateTime timestamp) {
        return timestamp.format(comparableFormatter);
    }

    public static ZonedDateTime from(String timestamp) {
        return ZonedDateTime.parse(timestamp, comparableFormatter);
    }

    public static String toHumanReadable(ZonedDateTime timestamp) {
        return timestamp.format(humanReadableFormatter);
    }

    public static String toHumanReadable(Optional<ZonedDateTime> timestamp) {
        return timestamp.map(FormattedTimestamp::toHumanReadable).orElse("");
    }

    public static String toHumanReadable(long timestamp) {
        return toHumanReadable(fromEpoch(timestamp));
    }

    public static ZonedDateTime fromDate(String date) {
        return LocalDate.parse(date, localDate).atStartOfDay(utc);
    }

    public static Long epoch(ZonedDateTime timestamp) {
        return timestamp.withZoneSameInstant(utc).toEpochSecond();
    }

    public static String epochString(ZonedDateTime timestamp) {
        return Long.toUnsignedString(timestamp.withZoneSameInstant(utc).toEpochSecond());
    }

    public static ZonedDateTime fromEpoch(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return ZonedDateTime.ofInstant(instant, utc);
    }
}
