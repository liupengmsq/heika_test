package com.heika.test.dao.verify;

import com.heika.test.common.VerifyUserStatus;
import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VerifyUserStatusDao extends BaseDaoHibernate4<VerifyUserStatusEntity>
{
    public void deleteByUserId(Integer userId)
    {
        this.delete(VerifyUserStatusEntity.class, "userId", userId);
    }

    public VerifyUserStatusEntity getByUserId(Integer userId)
    {
        return this.get(VerifyUserStatusEntity.class, "userId", userId);
    }

    public List<VerifyUserStatusEntity> getAll()
    {
        return this.findAll(VerifyUserStatusEntity.class);
    }

    public List<VerifyUserStatusEntity> getByUserIds(List<Integer> userIds)
    {
        return this.getList(VerifyUserStatusEntity.class, "userId", userIds);
    }

    public List<VerifyUserStatusEntity> getByStatus(VerifyUserStatus status)
    {
        return this.getList(VerifyUserStatusEntity.class, "verifyUserStatus", status.name());
    }

    public Map<Integer, VerifyUserStatus> getAllUserIdsAndStatusMap()
    {
        Map<Integer, VerifyUserStatus> userIds = new HashMap<>();
        this.findAll(VerifyUserStatusEntity.class).forEach(i->userIds.put(i.getUserId(), Enum.valueOf(VerifyUserStatus.class, i.getVerifyUserStatus())));
        return userIds;
    }

    public Map<Integer, VerifyUserStatus> getAllUserIdsAndStatusMapByStatus(VerifyUserStatus status)
    {
        Map<Integer, VerifyUserStatus> userIds = new HashMap<>();
        this.getList(VerifyUserStatusEntity.class, "verifyUserStatus", status.name()).forEach(i->userIds.put(i.getUserId(), Enum.valueOf(VerifyUserStatus.class, i.getVerifyUserStatus())));
        return userIds;
    }

    public void updateStatusToINQUIREING(Integer userId)
    {
        VerifyUserStatusEntity vus = getByUserId(userId);
        if(vus == null)
        {
            return;
        }
        vus.setVerifyUserStatus(VerifyUserStatus.INQUIREING.name());
//        vus.setCommitTime(null);
        vus.setRejectOperation(null);
        vus.setInvestigateTime(null);
        vus.setFirstVerifyTime(null);
        vus.setSecondVerifyTime(null);
        vus.setInvestigateUserId(null);
        vus.setFirstVerifyUserId(null);
        vus.setSecondVerifyUserId(null);
        vus.setInvestigateNote(null);
        vus.setFirstVerifyNote(null);
        vus.setSecondVerifyNote(null);
        vus.setFirstVerifyAmount(null);
        vus.setFirstVerifyCardProductId(null);
        vus.setSecondVerifyAmount(null);
        vus.setSecondVerifyCardProductId(null);
        vus.setInYouxinBackList(null);
        vus.setVersion(0);
        vus.setAuditUserStatus(null);
        vus.setOnlineTime(null);
        vus.setFirstCashDrawRatio(null);
        vus.setCashDrawRatio(null);

        this.update(vus);
    }
}
