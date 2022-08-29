package com.zyt.controller;

import com.zyt.pojo.Villager;
import com.zyt.service.VillagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/villager")
@CrossOrigin // 解决跨域
public class VillageController {

    @Autowired
    private VillagerService villagerService;

    @GetMapping("/getAllHZByRuralId/{rural_id}")
    public List<Villager> getAllHZByRuralId(@PathVariable("rural_id") String rural_id) {
        return villagerService.getAllHZByRuralId(rural_id);
    }

    @GetMapping("/getHZAndPopulationByRuralId/{rural_id}")
    public Map<Villager, Integer> getHZAndPopulationByRuralId(@PathVariable("rural_id") String rural_id) {
        return villagerService.getHZAndPopulationByRuralId(rural_id);
    }

    @GetMapping("/getHZFamilyByHZIdNumber/{id_number}")
    public List<Villager> getHZFamilyByHZIdNumber(@PathVariable("id_number") String id_number) {
        return villagerService.getHZFamilyByHZIdNumber(id_number);
    }

    @GetMapping("/updateVillagerInfo")
    public int updateVillagerInfo(Villager villager) {
        int row = villagerService.updateVillagerInfo(villager);
        return row;
    }

    @GetMapping("/getHZByName/{name}")
    public Map<Villager, Integer> getHZByName(@PathVariable("name") String name) {
        return villagerService.getHZByName(name);
    }

    @GetMapping("/getHZByIdNumber/{id_number}")
    public Map<Villager, Integer> getHZByIdNumber(@PathVariable("id_number") String id_number) {
        return villagerService.getHZByIdNumber(id_number);
    }

    @GetMapping("/getHZByRuralIdAndName/{rural_id}/{name}")
    public Map<Villager, Integer> getHZByRuralIdAndName(@PathVariable("rural_id") String rural_id,
                                                       @PathVariable("name") String name) {
        return villagerService.getHZByRuralIdAndName(rural_id,name);
    }

    @GetMapping("/getHZByRuralIdAndIdNumber/{rural_id}/{id_number}")
    public Map<Villager, Integer> getHZByRuralIdAndIdNumber(@PathVariable("rural_id") String rural_id,
                                                           @PathVariable("id_number") String id_number) {
        return villagerService.getHZByRuralIdAndIdNumber(rural_id,id_number);
    }

    @GetMapping("/getHZByNameAndIdNumber/{name}/{id_number}")
    public Map<Villager,Integer> getHZByNameAndIdNumber(@PathVariable("name") String name,
                                                        @PathVariable("id_number") String id_number) {
        return villagerService.getHZByNameAndIdNumber(name,id_number);
    }

    @GetMapping("/getHZByRuralIdAndNameAndIdNumber/{rural_id}/{name}/{id_number}")
    public Map<Villager, Integer> getHZByRuralIdAndNameAndIdNumber(@PathVariable("rural_id") String rural_id,
                                                                   @PathVariable("name") String name,
                                                                   @PathVariable("id_number") String id_number) {
        return villagerService.getHZByRuralIdAndNameAndIdNumber(rural_id,name,id_number);
    }
}
