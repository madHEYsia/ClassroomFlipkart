package com.ClassroomFlipkart.main.functions;

public class timeStampChangeFormat {

    public static String[] months = {"","Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

    public static String timeStampChangeFormat(String orignal){
        String newTime;
        String[] timearray = orignal.split("\\.");

        if(Integer.parseInt(timearray[3])>12)
            newTime = (Integer.parseInt(timearray[3])-12) + ":" +timearray[4]+ "pm, ";
        else
            newTime = timearray[3] + ":" +timearray[4]+ "am, ";

        newTime = newTime + timearray[2] +" "+ months[Integer.parseInt(timearray[1])] +"'"+ timearray[0].substring(2);

        return newTime;
    }
}
