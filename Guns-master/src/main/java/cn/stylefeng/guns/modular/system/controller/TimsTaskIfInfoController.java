package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.TimsTaskIfInfo;
import cn.stylefeng.guns.modular.system.service.ITimsTaskIfInfoService;

/**
 * 接口关系展示控制器
 *
 * @author fengshuonan
 * @Date 2018-12-14 17:16:53
 */
@Controller
@RequestMapping("/timsTaskIfInfo")
public class TimsTaskIfInfoController extends BaseController {

    private String PREFIX = "/system/timsTaskIfInfo/";

    @Autowired
    private ITimsTaskIfInfoService timsTaskIfInfoService;

    /**
     * 跳转到接口关系展示首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "timsTaskIfInfo.html";
    }

    /**
     * 跳转到添加接口关系展示
     */
    @RequestMapping("/timsTaskIfInfo_add")
    public String timsTaskIfInfoAdd() {
        return PREFIX + "timsTaskIfInfo_add.html";
    }

    /**
     * 跳转到修改接口关系展示
     */
    @RequestMapping("/timsTaskIfInfo_update/{timsTaskIfInfoId}")
    public String timsTaskIfInfoUpdate(@PathVariable Integer timsTaskIfInfoId, Model model) {
        TimsTaskIfInfo timsTaskIfInfo = timsTaskIfInfoService.selectById(timsTaskIfInfoId);
        model.addAttribute("item",timsTaskIfInfo);
        LogObjectHolder.me().set(timsTaskIfInfo);
        return PREFIX + "timsTaskIfInfo_edit.html";
    }

    /**
     * 获取接口关系展示列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return timsTaskIfInfoService.selectList(null);
    }

    /**
     * 新增接口关系展示
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(String fff) {
    	JSONObject parseObject2 = JSONObject.parseObject(fff);
    	TimsTaskIfInfo parseObject = JSONObject.parseObject(fff, TimsTaskIfInfo.class);
        //timsTaskIfInfoService.insert(timsTaskIfInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除接口关系展示
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer timsTaskIfInfoId) {
        timsTaskIfInfoService.deleteById(timsTaskIfInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改接口关系展示
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TimsTaskIfInfo timsTaskIfInfo) {
        timsTaskIfInfoService.updateById(timsTaskIfInfo);
        return SUCCESS_TIP;
    }

    /**
     * 接口关系展示详情
     */
    @RequestMapping(value = "/detail/{timsTaskIfInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("timsTaskIfInfoId") Integer timsTaskIfInfoId) {
        return timsTaskIfInfoService.selectById(timsTaskIfInfoId);
    }
}
