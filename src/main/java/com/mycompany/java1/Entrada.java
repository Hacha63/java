package com.mycompany.java1;

import java.util.Calendar;
public class Entrada {
   public static void main(String[] args) {
      Calendar calendar = Calendar.getInstance();
      int day = calendar.get(Calendar.DAY_OF_WEEK);
      //day=1 diumenge
      System.out.println("Day: " + day);
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      System.out.println("Hour: " + hour);
      int minute = calendar.get(Calendar.MINUTE);
      System.out.println("Minute: " + minute);

      if (day>1 && day<6 && hour>=8 && hour<=20){

         System.out.println("Puedes acceder a una sesión de trabajo");

      }
      else {
         System.out.println("No puedes acceder a una sesión de trabajo");
      }
   }
}