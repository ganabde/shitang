package com.canteen.system.service.impl;

import java.util.List;
import com.canteen.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canteen.system.mapper.MsgMapper;
import com.canteen.system.domain.Msg;
import com.canteen.system.service.IMsgService;

/**
 * 留言Service业务层处理
 * 
 * @author xx
 * @date 2023-04-09
 */
@Service
public class MsgServiceImpl implements IMsgService 
{
    @Autowired
    private MsgMapper msgMapper;

    /**
     * 查询留言
     * 
     * @param msgId 留言主键
     * @return 留言
     */
    @Override
    public Msg selectMsgByMsgId(Long msgId)
    {
        return msgMapper.selectMsgByMsgId(msgId);
    }

    /**
     * 查询留言列表
     * 
     * @param msg 留言
     * @return 留言
     */
    @Override
    public List<Msg> selectMsgList(Msg msg)
    {
        return msgMapper.selectMsgList(msg);
    }

    /**
     * 新增留言
     * 
     * @param msg 留言
     * @return 结果
     */
    @Override
    public int insertMsg(Msg msg)
    {
        msg.setCreateTime(DateUtils.getNowDate());
        return msgMapper.insertMsg(msg);
    }

    /**
     * 修改留言
     * 
     * @param msg 留言
     * @return 结果
     */
    @Override
    public int updateMsg(Msg msg)
    {
        return msgMapper.updateMsg(msg);
    }

    /**
     * 批量删除留言
     * 
     * @param msgIds 需要删除的留言主键
     * @return 结果
     */
    @Override
    public int deleteMsgByMsgIds(Long[] msgIds)
    {
        return msgMapper.deleteMsgByMsgIds(msgIds);
    }

    /**
     * 删除留言信息
     * 
     * @param msgId 留言主键
     * @return 结果
     */
    @Override
    public int deleteMsgByMsgId(Long msgId)
    {
        return msgMapper.deleteMsgByMsgId(msgId);
    }
}
