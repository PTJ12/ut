package com.company.ut.screen.task;

import com.company.ut.entity.TaskService;
import io.jmix.ui.screen.*;
import com.company.ut.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author  PuTongjiao
 * @date  2022/5/21 13:09
*/
@UiController("Task_.edit")
@UiDescriptor("task-edit.xml")
@EditedEntityContainer("taskDc")
public class TaskEdit extends StandardEditor<Task> {

    @Autowired
    private TaskService taskService;
    @Subscribe
    public void onInitEntity(InitEntityEvent<Task> event) {
        event.getEntity().setAssignee(taskService.findLeastBusyUser());
    }
}