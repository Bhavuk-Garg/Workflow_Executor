package com.mysqlExample.kuroko.Task;

public class ThreadedTask implements Task{
    @Override
    public String execute() {
        System.out.println("Threaded Task Executed");
        return RandomOutput.getOutput();
    }
}