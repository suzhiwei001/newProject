package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-14
 */
@TableName("tims_task_if_info")
public class TimsTaskIfInfo extends Model<TimsTaskIfInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 接口id
     */
    @TableId(value = "IF_ID", type = IdType.AUTO)
    private Integer ifId;
    /**
     * 接口类型（0201-主机文件；0202开放平台文件）
     */
    @TableField("IF_TYPE")
    private String ifType;
    /**
     * 接口英文名称
     */
    @TableField("IF_ENNAME")
    private String ifEnname;
    /**
     * 接口中文名称
     */
    @TableField("IF_CNNAME")
    private String ifCnname;
    /**
     * 所属环境：1国内，2.fova 3.公共4.口行
     */
    @TableField("ENV_TYPE")
    private String envType;
    /**
     * 接口维护方应用
     */
    @TableField("APP_SNAME")
    private String appSname;
    /**
     * 接口状态 1-正常 2-废弃 3-新增未审批 4-拟作废
     */
    @TableField("IF_STATUS")
    private String ifStatus;
    /**
     * 维护人
     */
    @TableField("MODIFY_UDER")
    private String modifyUder;
    /**
     * 维护部门
     */
    @TableField("MODIFY_DEPT")
    private String modifyDept;
    /**
     * 最后更新时间
     */
    @TableField("MODIFY_TIME")
    private String modifyTime;
    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 更新时间
     */
    @TableField("TIMS_UPDT")
    private String timsUpdt;
    /**
     * 工银亚洲调用细分标志
     */
    @TableField("CALLFLAG")
    private String callflag;


    public Integer getIfId() {
        return ifId;
    }

    public void setIfId(Integer ifId) {
        this.ifId = ifId;
    }

    public String getIfType() {
        return ifType;
    }

    public void setIfType(String ifType) {
        this.ifType = ifType;
    }

    public String getIfEnname() {
        return ifEnname;
    }

    public void setIfEnname(String ifEnname) {
        this.ifEnname = ifEnname;
    }

    public String getIfCnname() {
        return ifCnname;
    }

    public void setIfCnname(String ifCnname) {
        this.ifCnname = ifCnname;
    }

    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }

    public String getAppSname() {
        return appSname;
    }

    public void setAppSname(String appSname) {
        this.appSname = appSname;
    }

    public String getIfStatus() {
        return ifStatus;
    }

    public void setIfStatus(String ifStatus) {
        this.ifStatus = ifStatus;
    }

    public String getModifyUder() {
        return modifyUder;
    }

    public void setModifyUder(String modifyUder) {
        this.modifyUder = modifyUder;
    }

    public String getModifyDept() {
        return modifyDept;
    }

    public void setModifyDept(String modifyDept) {
        this.modifyDept = modifyDept;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTimsUpdt() {
        return timsUpdt;
    }

    public void setTimsUpdt(String timsUpdt) {
        this.timsUpdt = timsUpdt;
    }

    public String getCallflag() {
        return callflag;
    }

    public void setCallflag(String callflag) {
        this.callflag = callflag;
    }

    @Override
    protected Serializable pkVal() {
        return this.ifId;
    }

    @Override
    public String toString() {
        return "TimsTaskIfInfo{" +
        ", ifId=" + ifId +
        ", ifType=" + ifType +
        ", ifEnname=" + ifEnname +
        ", ifCnname=" + ifCnname +
        ", envType=" + envType +
        ", appSname=" + appSname +
        ", ifStatus=" + ifStatus +
        ", modifyUder=" + modifyUder +
        ", modifyDept=" + modifyDept +
        ", modifyTime=" + modifyTime +
        ", remark=" + remark +
        ", timsUpdt=" + timsUpdt +
        ", callflag=" + callflag +
        "}";
    }
}
