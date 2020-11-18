package com.example.midterm2_skeletonproject;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseClient {


    private static CarDataBase dbClient;



    public static CarDataBase buildDbClient(Context context){
        if (dbClient == null) {
            dbClient = Room.databaseBuilder(context, CarDataBase.class, "cars_db").build();
        }
        return dbClient;
    }


    public static CarDataBase getdbClient(){
        return dbClient;
    }


    public static final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(4);// build excutor Service
    //Insert function which call execute function and pass a runnable command
    //this runnable command is a lambda expression ()->{}

    public static void insertNewCar (Car carToInsert){
        databaseWriteExecutor.execute(()->{//Runnable Command
            getdbClient().carDao().insertNewCar(carToInsert);
        });
    }

    public static void getAllCars (){


//        databaseWriteExecutor.execute(()->{//Runneble Command
//            Car[] carsFromDB =  getdbClient().carDao().loadAllCar();
//            System.out.println(carsFromDB.length);
//            System.out.println(carsFromDB[0].id + "  "+  carsFromDB[0].model);
//            System.out.println(carsFromDB[1].id + "  "+  carsFromDB[1].model);
//
//            System.out.println(carsFromDB[2].id + "  "+  carsFromDB[2].model);
//
//        });



    }



}
