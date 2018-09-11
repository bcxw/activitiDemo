package net.itxw.activitiDemo.serviceImpl;

import net.itxw.activitiDemo.dao.LeaveDao;
import net.itxw.activitiDemo.model.LeaveInfo;
import net.itxw.activitiDemo.service.LeaveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Resource
    private LeaveDao leaveDao;


    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Override
    public void apply(LeaveInfo leaveInfo) {
        leaveDao.insert(leaveInfo);
        System.out.println(leaveInfo);
    }

    @Override
    public void updateStatus(DelegateExecution delegateExecution, String status) {
        String processId=delegateExecution.getProcessInstanceBusinessKey();
        LeaveInfo leaveInfo=leaveDao.selectById(Integer.valueOf(processId));
        if(leaveInfo!=null){
            leaveInfo.setStatus(status);
        }
        leaveDao.update(leaveInfo);
    }

    @Override
    public List<String> getDeptManager(DelegateExecution delegateExecution) {
        return Arrays.asList("m1","m2");
    }

    @Override
    public List<String> getHrManager(DelegateExecution delegateExecution) {
        return Arrays.asList("h1","h2");
    }

    @Override
    public  List<Task> getToDoListByUserId(String userId) {
        return taskService.createTaskQuery().processDefinitionKey("LeaveProcess").taskCandidateOrAssigned(userId).list();
    }

    @Override
    public void startProcess(String bizKey) {
        runtimeService.startProcessInstanceByKey("LeaveProcess",bizKey);
    }

    @Override
    public void examine(String userId,String taskId,String result) {
        taskService.claim(taskId,userId);
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        taskService.complete(taskId,map);
    }
}
