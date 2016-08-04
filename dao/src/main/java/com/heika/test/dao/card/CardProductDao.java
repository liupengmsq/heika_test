package com.heika.test.dao.card;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.card.CardProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CardProductDao extends BaseDaoHibernate4<CardProductEntity>
{
    public String getCardNameById(Integer id)
    {
        CardProductEntity cardProductEntity = this.get(CardProductEntity.class, "id", id);
        if(cardProductEntity != null)
        {
            return cardProductEntity.getName();
        }
        return null;
    }
}
