package com.zyt.service.impl;

import com.zyt.mapper.VillagerMapper;
import com.zyt.pojo.Villager;
import com.zyt.service.VillagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VillagerServiceImpl implements VillagerService {

    @Autowired
    private VillagerMapper villagerMapper;

    @Override
    public List<Villager> getAllHZByRuralId(String rural_id) {
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("rural_id", rural_id).
                andEqualTo("relationship","户主");

        List<Villager> HZList = villagerMapper.selectByExample(example);
        return HZList;
    }

    @Override
    public Map<Villager, Integer> getHZAndPopulationByRuralId(String rural_id) {

        Map<Villager, Integer> map = new HashMap<>();

        Example example = new Example(Villager.class);
        // 获取villagerList户主集合
        example.createCriteria().andEqualTo("rural_id", rural_id).
                andEqualTo("relationship","户主");
        List<Villager> HZList = villagerMapper.selectByExample(example);

        // 获取每个户主的家庭成员人数
        Example example1 = new Example(Villager.class);
        for(Villager hz : HZList) {
            String id = hz.getId();
            example1.createCriteria().andEqualTo("origin",id);
            int population = villagerMapper.selectByExample(example1).size();
            map.put(hz, population);
            // 每次遍历要清除
            example1.clear();
        }
        return map;
    }

    @Override
    public List<Villager> getHZFamilyByHZIdNumber(String id_number) {
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("id_number",id_number);
        List<Villager> hz = villagerMapper.selectByExample(example);
        example.clear();
        example.createCriteria().andEqualTo("origin",hz.get(0).getId());
        List<Villager> family = villagerMapper.selectByExample(example);
        return family;
    }

    @Override
    public int updateVillagerInfo(Villager villager) {
        return villagerMapper.updateByPrimaryKey(villager);
    }

    @Override
    public Map<Villager, Integer> getHZByName(String name) {
        HashMap<Villager, Integer> map = new HashMap<>();

        Villager villager = new Villager();
        villager.setName(name);
        List<Villager> list = villagerMapper.select(villager);
        List<Villager> hzList = list.stream().filter(villager1 -> "户主".equals(villager1.getRelationship()))
                .collect(Collectors.toList());

        // 获取每个户主的家庭成员人数
        Example example1 = new Example(Villager.class);
        for(Villager hz : hzList) {
            String id = hz.getId();
            example1.createCriteria().andEqualTo("origin", id);
            int population = villagerMapper.selectByExample(example1).size();
            map.put(hz, population);
            // 每次遍历要清除
            example1.clear();
        }
        return map;
    }

    @Override
    public Map<Villager, Integer> getHZByIdNumber(String id_number) {
        Map<Villager,Integer> map = new HashMap<>();

        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("id_number", id_number);
        // 目标对象
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();

        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            // 户主
            List<Villager> hzList = villagerMapper.selectByExample(example);
            example.clear();

            // 获取户主的家庭成员人数
            for(Villager hz : hzList) {
                String id = hz.getId();
                example.createCriteria().andEqualTo("origin", id);
                int population = villagerMapper.selectByExample(example).size();
                map.put(hz, population);
                // 每次遍历要清除
                example.clear();
            }
        } else {
            return map;
        }
        return map;
    }

    @Override
    public Map<Villager, Integer> getHZByRuralIdAndName(String rural_id, String name) {
        Map<Villager, Integer> map = new HashMap<>();
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("rural_id",rural_id)
                .andEqualTo("name",name);
        // 目标
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();

        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            // 户主
            List<Villager> hzList = villagerMapper.selectByExample(example);
            example.clear();

            // 获取户主的家庭成员人数
            for(Villager hz : hzList) {
                String id = hz.getId();
                example.createCriteria().andEqualTo("origin", id);
                int population = villagerMapper.selectByExample(example).size();
                map.put(hz, population);
                // 每次遍历要清除
                example.clear();
            }
        } else {
            return map;
        }
        return map;
    }

    @Override
    public Map<Villager, Integer> getHZByRuralIdAndIdNumber(String rural_id, String id_number) {
        Map<Villager,Integer> map = new HashMap<>();
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("rural_id",rural_id)
                .andEqualTo("id_number",id_number);
        // 目标
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();

        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            // 户主
            List<Villager> hzList = villagerMapper.selectByExample(example);
            example.clear();

            // 获取户主的家庭成员人数
            for(Villager hz : hzList) {
                String id = hz.getId();
                example.createCriteria().andEqualTo("origin", id);
                int population = villagerMapper.selectByExample(example).size();
                map.put(hz, population);
                // 每次遍历要清除
                example.clear();
            }
        } else {
            return map;
        }
        return map;
    }

    @Override
    public Map<Villager, Integer> getHZByNameAndIdNumber(String name, String id_number) {
        Map<Villager,Integer> map = new HashMap<>();
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("name",name)
                .andEqualTo("id_number",id_number);
        // 目标
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();

        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            // 户主
            List<Villager> hzList = villagerMapper.selectByExample(example);
            example.clear();

            // 获取户主的家庭成员人数
            for(Villager hz : hzList) {
                String id = hz.getId();
                example.createCriteria().andEqualTo("origin", id);
                int population = villagerMapper.selectByExample(example).size();
                map.put(hz, population);
                // 每次遍历要清除
                example.clear();
            }
        } else {
            return map;
        }
        return map;
    }

    @Override
    public Map<Villager, Integer> getHZByRuralIdAndNameAndIdNumber(String rural_id, String name, String id_number) {
        Map<Villager,Integer> map = new HashMap<>();
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("rural_id",rural_id)
                .andEqualTo("name",name)
                .andEqualTo("id_number",id_number);
        // 目标
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();

        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            // 户主
            List<Villager> hzList = villagerMapper.selectByExample(example);
            example.clear();

            // 获取户主的家庭成员人数
            for(Villager hz : hzList) {
                String id = hz.getId();
                example.createCriteria().andEqualTo("origin", id);
                int population = villagerMapper.selectByExample(example).size();
                map.put(hz, population);
                // 每次遍历要清除
                example.clear();
            }
        } else {
            return map;
        }
        return map;
    }
}
