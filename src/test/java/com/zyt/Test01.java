package com.zyt;

import com.zyt.mapper.RuralMapper;
import com.zyt.mapper.VillagerMapper;
import com.zyt.pojo.Rural;
import com.zyt.pojo.Villager;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test01 {

    private final BeanFactory beanFactory =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private final RuralMapper ruralMapper =
            (RuralMapper) beanFactory.getBean("ruralMapper");

    private final VillagerMapper villagerMapper =
            (VillagerMapper) beanFactory.getBean("villagerMapper");

    @Test
    public void testLombok() {

        Rural r = new Rural();
        r.setRural_name("东畈村");
        String ruralName = r.getRural_name();
        System.out.println("创建了" + ruralName + "对象");
        System.out.println(r);
    }

    @Test
    public void testInsertSelective() {
        Rural r = new Rural();
        r.setRural_name("尤停下村");

       int row = ruralMapper.insertSelective(r);
        if (row == 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testInsert() {
        Villager villager = new Villager();
        villager.setName("张三");
        villager.setAge("40");
        villager.setId_number("1111");

        int row = villagerMapper.insert(villager);

        if (row > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testDelete() {

        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("age",40);

        int row = villagerMapper.deleteByExample(example);

        if(row == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testGetAllHZByRuralId() {

        Map<Villager, Integer> map = new HashMap<>();

        Example example = new Example(Villager.class);
        // 获取villagerList户主集合
        example.createCriteria().andEqualTo("rural_id", 1).
                andEqualTo("relationship","户主");
        List<Villager> HZList = villagerMapper.selectByExample(example);

        // 获取每个户主的家庭成员人数
        Example example1 = new Example(Villager.class);
        for(Villager hz : HZList) {
            String id = hz.getId();
            example1.createCriteria().andEqualTo("origin",id);
            int population = villagerMapper.selectByExample(example1).size();
            map.put(hz, population);
            example1.clear();
        }

        System.out.println(map);
    }

    @Test
    public void testGetHZFamilyByHZId() {
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("origin",9);
        List<Villager> list = villagerMapper.selectByExample(example);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testGetHZFamilyByHZIdNumber() {
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("id_number","421182200012113730");
        List<Villager> hz = villagerMapper.selectByExample(example);
        example.clear();
        example.createCriteria().andEqualTo("origin",hz.get(0).getId());
        List<Villager> family = villagerMapper.selectByExample(example);
        family.stream().forEach(System.out::println);
    }

    @Test
    public void testGetHZByName() {
        HashMap<Villager, Integer> map = new HashMap<>();

        Villager villager = new Villager();
        villager.setName("lisi");
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
        System.out.println(map);
    }

    @Test
    public void testGetHZByIdNumber() {
        Example example = new Example(Villager.class);
        example.createCriteria().andEqualTo("id_number", "421182201002023730");
        List<Villager> list = villagerMapper.selectByExample(example);
        example.clear();
        if(list.size() !=0 && list != null) {
            example.createCriteria().andEqualTo("origin",list.get(0).getOrigin())
                    .andEqualTo("relationship","户主");
            List<Villager> list1 = villagerMapper.selectByExample(example);
            System.out.println(list1);
        } else {
            System.out.println("查无此人");
        }
    }
}
