package com.mzdomanska.sda.trees.timeTest;

import com.mzdomanska.sda.trees.time.Time;
import com.mzdomanska.sda.trees.time.TimeManager;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeManagerTest {

    private TimeManager time1 = new TimeManager(20,40,50);
    private TimeManager time2 = new TimeManager(15,30,45);
    private TimeManager time3 = new TimeManager(23,40,46);
    private TimeManager time4 = new TimeManager(23,59,46);
    private TimeManager time5 = new TimeManager(15,30,15);

    @Test
    public void getHoursShouldReturn20Hours() {

        int hours = time1.getHours();
        assertThat(hours).isEqualTo(20);
    }

    @Test
    public void getMinutesShouldReturn40Minutes() {

        int minutes = time1.getMinutes();
        assertThat(minutes).isEqualTo(40);
    }

    @Test
    public void getSecondsShouldReturn50Seconds() {

        int seconds = time1.getSeconds();
        assertThat(seconds).isEqualTo(50);
    }

    @Test
    public void copyShouldCreateNewTimeObjWithTheSameFieldValuesAsCallingObj() {

        Time copy = time1.copy();

        assertThat(copy).isNotEqualTo(null);
        assertThat(copy).isInstanceOf(Time.class);
        assertThat(copy.getHours()).isEqualTo(20);
        assertThat(copy.getMinutes()).isEqualTo(40);
        assertThat(copy.getSeconds()).isEqualTo(50);
    }

    @Test
    public void addHoursShouldCreateNewTimeObjWithHourIncreasedBy5() {

        Time newTime1 = time1.addHours(5);

        assertThat(newTime1).isNotEqualTo(null);
        assertThat(newTime1).isInstanceOf(Time.class);
        assertThat(newTime1.getHours()).isEqualTo(1);
        assertThat(newTime1.getMinutes()).isEqualTo(time1.getMinutes());
        assertThat(newTime1.getSeconds()).isEqualTo(time1.getSeconds());

        Time newTime2 = time2.addHours(5);

        assertThat(newTime2).isNotEqualTo(null);
        assertThat(newTime2).isInstanceOf(Time.class);
        assertThat(newTime2.getHours()).isEqualTo(20);
        assertThat(newTime2.getMinutes()).isEqualTo(time2.getMinutes());
        assertThat(newTime2.getSeconds()).isEqualTo(time2.getSeconds());

    }

    @Test
    public void addMinutesShouldCreateNewTimeObjWithMinutesIncreasedBy25() {

        Time newTime1 = time1.addMinutes(25);

        assertThat(newTime1).isNotEqualTo(null);
        assertThat(newTime1).isInstanceOf(Time.class);
        assertThat(newTime1.getHours()).isEqualTo(21);
        assertThat(newTime1.getMinutes()).isEqualTo(5);
        assertThat(newTime1.getSeconds()).isEqualTo(time1.getSeconds());

        Time newTime2 = time2.addMinutes(25);

        assertThat(newTime2).isNotEqualTo(null);
        assertThat(newTime2).isInstanceOf(Time.class);
        assertThat(newTime2.getHours()).isEqualTo(time2.getHours());
        assertThat(newTime2.getMinutes()).isEqualTo(55);
        assertThat(newTime2.getSeconds()).isEqualTo(time2.getSeconds());

        Time newTime3 = time3.addMinutes(25);

        assertThat(newTime3).isNotEqualTo(null);
        assertThat(newTime3).isInstanceOf(Time.class);
        assertThat(newTime3.getHours()).isEqualTo(24);
        assertThat(newTime3.getMinutes()).isEqualTo(5);
        assertThat(newTime3.getSeconds()).isEqualTo(time3.getSeconds());

    }

    @Test
    public void addSecondsShouldCreateNewTimeObjWithSecondsIncreasedBy15() {

        Time newTime3 = time3.addSeconds(15);

        assertThat(newTime3).isNotEqualTo(null);
        assertThat(newTime3).isInstanceOf(Time.class);
        assertThat(newTime3.getHours()).isEqualTo(time3.getHours());
        assertThat(newTime3.getMinutes()).isEqualTo(41);
        assertThat(newTime3.getSeconds()).isEqualTo(1);

        Time newTime4 = time4.addSeconds(15);
        assertThat(newTime4).isNotEqualTo(null);
        assertThat(newTime4).isInstanceOf(Time.class);
        assertThat(newTime4.getHours()).isEqualTo(24);
        assertThat(newTime4.getMinutes()).isEqualTo(0);
        assertThat(newTime4.getSeconds()).isEqualTo(1);

        Time newTime5 = time5.addSeconds(15);

        assertThat(newTime5).isNotEqualTo(null);
        assertThat(newTime5).isInstanceOf(Time.class);
        assertThat(newTime5.getHours()).isEqualTo(time5.getHours());
        assertThat(newTime5.getMinutes()).isEqualTo(time5.getMinutes());
        assertThat(newTime5.getSeconds()).isEqualTo(30);

    }

}
