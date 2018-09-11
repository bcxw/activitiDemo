package net.itxw.activitiDemo.service;

import net.itxw.activitiDemo.model.LeaveInfo;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;

import java.util.List;

public interface LeaveService {
    public void apply(LeaveInfo leaveInfo);

    public void updateStatus(DelegateExecution delegateExecution,String status);

    public List<String> getDeptManager(DelegateExecution delegateExecution);

    public List<String> getHrManager(DelegateExecution delegateExecution);

    public List<Task> getToDoListByUserId(String userId);

    public void startProcess(String bizKey);

    public void examine(String userId,String taskId,String result);

}
