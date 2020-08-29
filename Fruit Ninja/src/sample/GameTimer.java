package sample;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    public static int i = 0;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            // String result = getTime(i);
            // System.out.println(result);
            i++;
        }
    };


    public void  resetTime(){

        timer.cancel();
    }


    public  void runTimer(){

        timer.schedule(task, 0,1000);

    }

    public String countDown(int i)
    {

        int seconds = 60;
        return "00"+":"+(seconds-i);
    }

    public  String getTime(int sec){

        int hours = 0;
        int remainderHour = 0;
        int minutes = 0;
        int seconds = 0;

        if(sec >= 3600){

            hours = sec / 3600;
            remainderHour = sec % 3600;

            if(remainderHour >= 60){

                minutes = remainderHour / 60;
                seconds = remainderHour % 60;
            }
            else{

                seconds = remainderHour;
            }
        }
        else if(sec >= 60){

            minutes = sec / 60;
            seconds = sec % 60;
        }
        else if(sec < 60){

            seconds = sec;
        }

        String strhour;
        String strminute;
        String strsecond;

        if(seconds < 10){

            strsecond = "0" + String.valueOf(seconds);
        }
        else{

            strsecond = String.valueOf(seconds);
        }

        if(minutes < 10){

            strminute = "0" + String.valueOf(minutes);
        }
        else{

            strminute = String.valueOf(minutes);
        }
        if(hours < 10){

            strhour = "0" + String.valueOf(hours);
        }
        else{

            strhour = String.valueOf(hours);
        }

        String time = strhour + ":" + strminute + ":" + strsecond;
        return time;
    }
}