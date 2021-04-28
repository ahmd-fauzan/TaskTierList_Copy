package com.example.tasktierlist;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task implements Parcelable {

    @NonNull
    @ColumnInfo(name = "matakuliah")
    private String matakuliah;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String taskTitle;

    @NonNull
    @ColumnInfo(name = "description")
    private String desc;

    @NonNull
    @ColumnInfo(name = "deadline")
    private int deadline;

    @NonNull
    @ColumnInfo(name = "reference")
    private String reference;

    @NonNull
    @ColumnInfo(name = "link")
    private String linkToSend;

    @NonNull
    @ColumnInfo(name = "namefile")
    private String nameOfFile;

    @NonNull
    @ColumnInfo(name = "difficult")
    private int difficult;

    Task(){

    }

    @Ignore
    Task(String matakuliah, String taskTitle, String desc, int deadline, String reference, String linkToSend, String nameOfFile, int difficult){
        this.matakuliah = matakuliah;
        this.taskTitle = taskTitle;
        this.desc = desc;
        this.deadline = deadline;
        this.reference = reference;
        this.linkToSend = linkToSend;
        this.nameOfFile = nameOfFile;
        this.difficult = difficult;
    }

    protected Task(Parcel in) {
        matakuliah = in.readString();
        taskTitle = in.readString();
        desc = in.readString();
        deadline = in.readInt();
        reference = in.readString();
        linkToSend = in.readString();
        nameOfFile = in.readString();
        difficult = in.readInt();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getReference(){
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLinkToSend() {
        return linkToSend;
    }

    public void setLinkToSend(String linkToSend) {
        this.linkToSend = linkToSend;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.matakuliah);
        dest.writeString(this.taskTitle);
        dest.writeString(this.desc);
        dest.writeInt(this.deadline);
        dest.writeString(this.reference);
        dest.writeString(this.linkToSend);
        dest.writeString(this.nameOfFile);
        dest.writeInt(this.difficult);
    }
}
