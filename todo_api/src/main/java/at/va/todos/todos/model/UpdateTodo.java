package at.va.todos.todos.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateTodo {
    @NotNull
    @Size(min=2, message = "The name must be longer")
    @Column(name="task_name")
    private String name;

    @NotNull(message = "The Responsible-name must not be null")
    @Column (name="task_responsible")
    private String responsible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
