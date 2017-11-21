package edu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vaibhav
 */

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Planner {

    public boolean bo = false;

    public int std_time = 1;
    public int total_sub_time = 0;
    public int weekdays = 0;
    public int weekends = 0;
    public int total_units = 30;
    public int no_of_weekdays;
    public int no_of_weekends;
    public int total_time;

    public float sum = 0;
    public float rem_time = 0;
    public float sum_of_pr = 0;

    public char sub_name[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    public char temp[] = new char[12];
    public float sub_time[] = new float[6];
    public float unit_time[] = new float[6];

    private int w_days(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workDays = 0;

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis())
            return 0;
        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
                ++workDays;
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return workDays;
    }

    private int w_ends(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workDays = 0;

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis())
            return 0;
        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                ++workDays;
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return workDays;
    }

    private void time(int sub_pr[], int sub_units[]) {

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        try {
            no_of_weekdays = w_days(format.parse("1/11/2016"), format.parse("07/11/2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            no_of_weekends = w_ends(format.parse("1/11/2016"), format.parse("07/11/2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        total_time = (no_of_weekdays * 7) + (no_of_weekends * 10);

        for (int i : sub_pr)
            sum_of_pr += i;

        for (int i : sub_units)
            total_sub_time += i;

        rem_time = total_time - (total_sub_time * std_time);
        int j = 0;

        for (int i : sub_pr) {
            sub_time[j] = (float) Math.round(((sub_units[j] * std_time) + ((rem_time / sum_of_pr) * i)));

            j++;
        }
    }

    private void scheduler(float sub_time[], int sub_units[]) {
        int x = 0;
        for (float i : sub_time) {
            unit_time[x] = Math.round(i / sub_units[x]);
            System.out.print(unit_time[x] + "\t");
            x++;

        }

        System.out.println(no_of_weekdays + " " + no_of_weekends);

        while (weekdays != no_of_weekdays) {
            sum = 0;
            int y = 0;
            bo = false;
            for (int i = 0; i < 6; i++)
                if (sub_units[i] > 0 && unit_time[i] <= 7) {
                    sum += unit_time[i];
                    temp[y] = sub_name[i];
                    sub_units[i]--;
                    total_units--;
                    y++;
                    if (sum > 7) {
                        sum -= unit_time[i];
                        sub_units[i]++;
                        total_units++;
                        y--;
                        weekdays++;
                        System.out.print("\n" + sum);
                        System.out.println();
                        for (int c = 0; c < y; c++)
                            System.out.print(temp[c] + "\t");
                        System.out.println();
                        bo = true;
                        break;
                    }
                }
            if (sum <= 7 && !bo) {
                weekdays++;
                System.out.print("\n" + sum);
                System.out.println();
                for (int c = 0; c < y; c++)
                    System.out.print(temp[c] + "\t");
                System.out.println();
            }
        }

        while (weekends != no_of_weekends && total_units != 0) {
            sum = 0;
            int y = 0;
            bo = false;
            int tp = 0, sp = 0;
            System.out.print("\n" + weekends);
            while (total_units != 0 && sp == tp) {
                for (int i = 0; i < 6; i++)
                    if (sub_units[i] > 0 && unit_time[i] <= 10) {
                        sum += unit_time[i];
                        temp[y] = sub_name[i];
                        sub_units[i]--;
                        total_units--;
                        y++;
                        if (sum > 10) {
                            tp++;
                            sum -= unit_time[i];
                            sub_units[i]++;
                            total_units++;
                            y--;
                            weekends++;
                            bo = true;
                            break;
                        }
                    }
                if (!bo && total_units == 0)
                    weekends++;

            }
            System.out.print("\n" + sum);
            System.out.println();
            for (int c = 0; c < y; c++)
                System.out.print(temp[c] + "\t");
            System.out.println();
        }

    }

    public static void main(String args[]) {
        int a[] = {3, 3, 3, 3, 3, 3};//diff
        int b[] = {5, 5, 5, 5, 5, 5};//units
        Planner ob = new Planner();
        ob.time(a, b);
        for (float i : ob.sub_time)
            System.out.print(i + "\t");
        ob.scheduler(ob.sub_time, b);
        System.out.print(ob.total_units);
    }
}
