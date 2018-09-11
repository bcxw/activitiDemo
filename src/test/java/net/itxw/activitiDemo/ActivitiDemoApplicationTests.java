package net.itxw.activitiDemo;

import net.itxw.activitiDemo.dao.LeaveDao;
import net.itxw.activitiDemo.model.LeaveInfo;
import net.itxw.activitiDemo.service.LeaveService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiDemoApplicationTests {

    @Resource
    private LeaveService leaveService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){

        //新增请假单
//        LeaveInfo leaveInfo=new LeaveInfo();
//        leaveInfo.setMessage("我要请假 去玩游戏");
//        leaveInfo.setStatus("wait");
//        leaveService.apply(leaveInfo);
//        leaveService.startProcess(leaveInfo.getId()+"");
//


        //项目主管查询代办
//        List<Task> tasks=leaveService.getToDoListByUserId("m1");
//        System.out.println(tasks);

        //驳回审批
//        leaveService.examine("m1","50010","no");
//        leaveService.examine("m1","52506","no");
//        leaveService.examine("m1","57506","no");
//        leaveService.examine("m1","67506","no");

        //审批通过
//        leaveService.examine("m1","65006","yes");

        //人事代码
//        List<Task> tasks=leaveService.getToDoListByUserId("h1");
//        System.out.println(tasks);
        //完成审批
//        leaveService.examine("h1","70008","yes");


    }

}
