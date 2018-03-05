package com.mzdomanska.sda.trees.time;

public class TimeManager implements Time, Comparable<Time> {

    private final int hoursInADay = 24;
    private final int minutesInAnHour = 60;
    private final int secondsInAMinute = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public TimeManager(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }

    @Override
    public Time copy() {
        return new TimeManager(hours,minutes,seconds);
    }

    @Override
    public Time addHours(int hours) {

        if (this.hours + hours > hoursInADay) {
            return new TimeManager((this.hours+hours)-hoursInADay,minutes,seconds);
        }
        else return new TimeManager(this.hours+hours,minutes,seconds);
    }

    @Override
    public Time addMinutes(int minutes) {

        if (this.minutes + minutes > minutesInAnHour) {
            if (hours + 1 < hoursInADay) {
                return new TimeManager(hours+1,(this.minutes+minutes)-minutesInAnHour,seconds);
            }
            else {
                return new TimeManager((hours+1)-hoursInADay,(this.minutes+minutes)-minutesInAnHour,seconds);
            }
        }
        else return new TimeManager(hours,this.minutes+minutes,seconds);
    }

    @Override
    public Time addSeconds(int seconds) {

        if (this.seconds + seconds > secondsInAMinute) {
            if (minutes + 1 < minutesInAnHour) {
                return new TimeManager(hours,minutes+1,(this.seconds+seconds)-secondsInAMinute);
            }
            else {
                return new TimeManager(hours+1,(minutes+1)-minutesInAnHour,(this.seconds+seconds)-secondsInAMinute);
            }
        }
        else {
            return new TimeManager(hours,minutes,this.seconds+seconds);
        }
    }

    @Override
    public Time add(Time other) {

        if (seconds + other.getSeconds() > secondsInAMinute) {
            seconds = (seconds + other.getSeconds()) - secondsInAMinute;
            minutes++;
        }
        else {
            seconds = seconds + other.getSeconds();
        }

        if (minutes + other.getMinutes() > minutesInAnHour) {
            minutes = (minutes + other.getMinutes()) - minutesInAnHour;
            hours++;
        }
        else {
            minutes = minutes + other.getMinutes();
        }

        if (hours + other.getHours() > hoursInADay) {
            hours = ((hours+other.getHours())-hoursInADay);
        }
        else {
            hours = hours + other.getHours();
        }

        return new TimeManager(hours,minutes,seconds);
    }

    @Override
    public int compareTo(Time time) {
        if (this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds == time.getSeconds())
            return 0;
        else if (this.hours > time.getHours())
            return -1;
        else if (this.hours == time.getHours() && this.minutes > time.getMinutes())
            return -1;
        else if (this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds > time.getSeconds())
            return -1;
        else if (this.hours < time.getHours())
            return 1;
        else if (this.hours == time.getHours() && this.minutes < time.getMinutes())
            return 1;
        // ostatnia mozliwosc: this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds < time.getSeconds()
        else
            return 1;

    }

    @Override
    public String toString() {

        if (hours == hoursInADay) {
            hours = 0;
        }
        if (minutes == minutesInAnHour) {
            minutes = 0;
        }
        if (seconds == secondsInAMinute) {
            seconds = 0;
        }
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }

    public static void main(String[] args) {

        TimeManager time = new TimeManager(24,35,12);

        System.out.println(time);

        System.out.println(time.add(new TimeManager(23,50,15)));
    }
}
