package com.zyt.service;

import com.zyt.pojo.Villager;

import java.util.List;
import java.util.Map;

public interface VillagerService {

    // 根据村id获取所有户主
    List<Villager> getAllHZByRuralId(String rural_id);

    // 根据村id获取户主信息及家庭成员人数
    Map<Villager,Integer> getHZAndPopulationByRuralId(String rural_id);

    // 通过户主身份证号码获取该户主家庭成员
    List<Villager> getHZFamilyByHZIdNumber(String id_number);

    // 修改村民信息
    int updateVillagerInfo(Villager villager);

    // 根据姓名查询村民
    Map<Villager,Integer> getHZByName(String name);

    // 通过证件号码查询户主
    Map<Villager,Integer> getHZByIdNumber(String id_number);

    // 根据村id和姓名查询户主
    Map<Villager,Integer> getHZByRuralIdAndName(String rural_id, String name);

    // 根据村id和证件号码查询户主
    Map<Villager,Integer> getHZByRuralIdAndIdNumber(String rural_id, String id_number);

    // 根据姓名和证件号码查询户主
    Map<Villager,Integer> getHZByNameAndIdNumber(String name, String id_number);

    // 根据村id、姓名和证件号码查询户主
    Map<Villager,Integer> getHZByRuralIdAndNameAndIdNumber(String rural_id, String name, String id_number);
}
