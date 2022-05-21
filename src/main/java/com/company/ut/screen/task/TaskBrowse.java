package com.company.ut.screen.task;

import io.jmix.ui.screen.*;
import com.company.ut.entity.Task;


/**
 * @author  PuTongjiao
 * @date  2022/5/21 13:09
*/
@UiController("Task_.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
public class TaskBrowse extends StandardLookup<Task> {
}