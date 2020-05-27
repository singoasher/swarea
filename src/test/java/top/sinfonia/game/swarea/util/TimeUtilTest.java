package top.sinfonia.game.swarea.util;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author sunzhaojie
 * @date 2020/5/27
 */
public class TimeUtilTest {

    @Test
    void testDaysBetween() {
        ZoneId zoneId = ZoneId.of("+08:00");
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        System.out.println("当前时间：" + now);

        ZonedDateTime from1 = ZonedDateTime.of(2011, 12, 29, 0, 0, 0, 0, zoneId);
        System.out.println("目标时间（一）：" + from1 + "；间隔：" + TimeUtil.daysBetween(from1.toInstant(), now.toInstant()));

        ZonedDateTime from2 = ZonedDateTime.of(2020, 5, 1, 0, 0, 0, 0, zoneId);
        System.out.println("目标时间（二）：" + from2 + "；间隔：" + TimeUtil.daysBetween(from2.toInstant(), now.toInstant()));
    }
}