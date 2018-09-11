package net.itxw.activitiDemo.dao;

import net.itxw.activitiDemo.model.LeaveInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LeaveDao {

    @Insert("<script>insert into leave_info(message,status) values(#{leaveInfo.message},#{leaveInfo.status})</script>")
    @Options(useGeneratedKeys = true, keyProperty = "leaveInfo.id")
    public void insert(@Param("leaveInfo") LeaveInfo leaveInfo);

    @Update("update leave_info set status=#{status} where id=#{id}")
    public void update(LeaveInfo leaveInfo);

    @Select("select * from leave_info where id=#{id}")
    public LeaveInfo selectById(@Param("id") Integer id);

}
