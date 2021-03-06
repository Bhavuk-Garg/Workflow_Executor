package com.executor.workflowExecutor.database.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="task_dependency")
public class TaskDependency {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="fromTask")
    @NotNull
    private TaskInfo fromTask;

    @Column(name="output")
    @NotNull
    private String output;

    @ManyToOne
    @JoinColumn(name="toTask")
    @NotNull
    private TaskInfo toTask;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskInfo getFromTask() {
        return fromTask;
    }

    public void setFromTask(TaskInfo fromTask) {
        this.fromTask = fromTask;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public TaskInfo getToTask() {
        return toTask;
    }

    public void setToTask(TaskInfo toTask) {
        this.toTask = toTask;
    }

}
