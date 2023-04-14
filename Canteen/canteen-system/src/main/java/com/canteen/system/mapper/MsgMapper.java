package com.canteen.system.mapper;

import java.util.List;
import com.canteen.system.domain.Msg;

/**
 * 留言Mapper接口
 * 
 * @author xx
 * @date 2023-04-09
 */
public interface MsgMapper 
{
    /**
     * 查询留言
     * 
     * @param msgId 留言主键
     * @return 留言
     */
    public Msg selectMsgByMsgId(Long msgId);

    /**
     * 查询留言列表
     * 
     * @param msg 留言
     * @return 留言集合
     */
    public List<Msg> selectMsgList(Msg msg);

    /**
     * 新增留言
     * 
     * @param msg 留言
     * @return 结果
     */
    public int insertMsg(Msg msg);

    /**
     * 修改留言
     * 
     * @param msg 留言
     * @return 结果
     */
    public int updateMsg(Msg msg);

    /**
     * 删除留言
     * 
     * @param msgId 留言主键
     * @return 结果
     */
    public int deleteMsgByMsgId(Long msgId);

    /**
     * 批量删除留言
     * 
     * @param msgIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMsgByMsgIds(Long[] msgIds);
}
