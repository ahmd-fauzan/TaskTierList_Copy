package com.example.tasktierlist;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
abstract class TaskRoomDatabase extends RoomDatabase {

    abstract TaskDao taskDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile TaskRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TaskDao dao = INSTANCE.taskDao();
                dao.deleteAll();
                Log.d("STATE", "jalan");
                //dao.insert(new Task("PPB", "Fragment vs RecycleView", "Dalam bentuk PDF", 5, "Google", "E-Learning", "PPB_NIM", 1));
                //dao.insert(new Task("PPL1", "MindMap", "Dalam bentuk PDF bergambar", 3, "SWEBOKV3", "E-Learning", "MindMap_NIM", 2));
                //dao.insert(new Task("PPL4", "Sensor", "Kelompok Dalam bentuk PDF", 1, "Youtube", "E-Learning", "PPL_NIM", 3));
                //dao.insert(new Task("PPL4", "Instal Arduino", "Dalam bentuk PDF", 2, "Google", "E-Learning", "PPL_NIM", 2));
                //dao.insert(new Task("PPB", "Mockup", "Dalam bentuk PDF", 4, "Google", "E-Learning", "PPB_NIM", 2));
            });
        }
    };
}
