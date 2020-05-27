package top.sinfonia.game.swarea.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author sunzhaojie
 * @date 2020/5/27
 */
public class TimeUtil {

    public static long daysToNow(int year, int month, int dayOfMonth,
                                 int hour, int minute, int second, int nanoOfSecond, ZoneId zone) {
        return daysToNow(ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone)
                .toInstant());
    }

    public static long daysToNow(Instant from) {
        return daysBetween(from, Instant.now());
    }

    public static long daysBetween(Instant from, Instant to) {
        return (to.toEpochMilli() - from.toEpochMilli()) / 1000 / 60 / 60 / 24;
    }

}

