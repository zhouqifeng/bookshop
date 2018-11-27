package com.qf.service.impl;

import com.qf.common.jedis.JedisClientCluster;
import com.qf.common.util.JsonUtils;
import com.qf.common.util.StrKit;
import com.qf.mapper.TbBookinfoMapper;
import com.qf.pojo.Item;
import com.qf.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbBookinfoMapper mapper;

    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Override
    public Item getItemById(Long itemId) {

        try {
            String json = jedisClientCluster.get("ITEM_INFO:"+itemId);
            if(!StrKit.isBlank(json)){
                Item item = JsonUtils.jsonToPojo(json,Item.class);
                return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Item> list = mapper.getItemById(itemId);

        if(list!=null && list.size()>0){

            Item item = list.get(0);

            try {
                jedisClientCluster.set("ITEM_INFO:"+itemId,JsonUtils.objectToJson(item));
                jedisClientCluster.expire("ITEM_INFO:"+itemId,3600);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return item;
        }

        return null;
    }
}
