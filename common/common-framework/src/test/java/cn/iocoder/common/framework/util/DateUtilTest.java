package cn.iocoder.common.framework.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtilTest {

    @Test
    public void testAddDate() {
        Assert.assertNull(DateUtil.addDate(0, 0));

    }

    @Test
    public void testFormat() {
        Assert.assertEquals("", DateUtil.format(null, null));
        Assert.assertEquals("2018-01-10:12:00:00", DateUtil.format(
                new Date(1_515_585_600_000L), "yyyy-MM-dd:HH:mm:ss"));
    }

    @Test
    public void testGetDayBegin() {
        Assert.assertNull(DateUtil.getDayBegin(null));
        Assert.assertEquals(new Date(1_515_542_400_000L),
                DateUtil.getDayBegin(new Date(1_515_585_600_000L)));
    }

    @Test
    public void testGetDayEnd() {
        Assert.assertNull(DateUtil.getDayEnd(null));
        Assert.assertEquals(new Date(1_515_628_799_999L), DateUtil.getDayEnd(
                new Date(1_515_585_600_000L)));
    }

    @Test
    public void testIsBetween() {
        Assert.assertTrue(DateUtil.isBetween(DateUtil.getDayBegin(),
                DateUtil.getDayEnd()));
        Assert.assertFalse(DateUtil.isBetween(
                DateUtil.getDayBegin(new Date(0L)),
                DateUtil.getDayEnd(new Date(100_000L))));
    }

    @Test
    public void testSetCalender() {
        final GregorianCalendar calendar = new GregorianCalendar();
        DateUtil.setCalender(calendar, 2, 30, 50, 0);

        Assert.assertEquals(2, calendar.getTime().getHours());
        Assert.assertEquals(30, calendar.getTime().getMinutes());
        Assert.assertEquals(50, calendar.getTime().getSeconds());
    }
}
