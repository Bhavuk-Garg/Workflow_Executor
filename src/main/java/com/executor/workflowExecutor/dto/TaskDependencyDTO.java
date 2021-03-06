package com.executor.workflowExecutor.dto;

import javax.validation.constraints.NotNull;

public class TaskDependencyDTO {
    @NotNull
    Integer fromTask;
    @NotNull
    Integer toTask;
    @NotNull
    String output;

    public Integer getFromTask() {
        return fromTask;
    }

    public void setFromTask(Integer fromTask) {
        this.fromTask = fromTask;
    }

    public Integer getToTask() {
        return toTask;
    }

    public void setToTask(Integer toTask) {
        this.toTask = toTask;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
