package com.eno.baozi.dangerous.report.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="人格")
public class Individuality {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "编号")
    private String fh;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "criminal表ID")
    private Integer criminalId;
    @ApiModelProperty(value = "入监时间")
    private Date prisonTime;

    @ApiModelProperty(value = "反社会人格")
    private Integer fshrg;
    @ApiModelProperty(value = "反社会人格级别")
    private String fshrgjb;
    @ApiModelProperty(value = "偏执性人格")
    private Integer pzxrg;
    @ApiModelProperty(value = "偏执性人格级别")
    private String pzxrgjb;
    @ApiModelProperty(value = "冲动性人格")
    private Integer cdxrg;
    @ApiModelProperty(value = "冲动性人格级别")
    private String cdxrgjb;
    @ApiModelProperty(value = "边缘性人格")
    private Integer byxrg;
    @ApiModelProperty(value = "边缘性人格级别")
    private String byxrgjb;
    @ApiModelProperty(value = "抑郁")
    private Integer yy;
    @ApiModelProperty(value = "抑郁")
    private String yyjb;
    @ApiModelProperty(value = "躁狂")
    private Integer zk;
    @ApiModelProperty(value = "躁狂")
    private String zkjb;
    @ApiModelProperty(value = "神经质")
    private Integer sjz;
    @ApiModelProperty(value = "神经质")
    private String sjzjb;
    @ApiModelProperty(value = "精神病性级")
    private Integer jsbx;
    @ApiModelProperty(value = "精神病性")
    private String jsbxjb;
    @ApiModelProperty(value = "说谎量表")
    private Integer shlb;
    @ApiModelProperty(value = "说谎量表级别")
    private String shlbjb;
    @ApiModelProperty(value = "评估日期")
    private Date pgrq;
    @ApiModelProperty(value = "评估人员id")
    private Integer pghs;
    @ApiModelProperty(value = "监狱编号")
    private String jybh;
    @ApiModelProperty(value = "监狱名称")
    private String jymc;
    @ApiModelProperty(value = "监区编号")
    private String jqbh;
    @ApiModelProperty(value = "监区名称")
    private String jqmc;
    @ApiModelProperty(value = "分监区编号")
    private String fjqbh;
    @ApiModelProperty(value = "分监区名称")
    private String fjqmc;
    @ApiModelProperty(value = "")
    private Integer jsbxHj;
    @ApiModelProperty(value = "")
    private Integer jsbxWx;
    @ApiModelProperty(value = "")
    private Integer jsbxQxza;
    @ApiModelProperty(value = "")
    private Integer jsbxRzza;
    @ApiModelProperty(value = "")
    private Integer jsbxJzzhz;
    @ApiModelProperty(value = "暴力分数")
    private BigDecimal blfs;
    @ApiModelProperty(value = "暴力等级")
    private String bldj;
    @ApiModelProperty(value = "脱逃分数")
    private BigDecimal ttfs;
    @ApiModelProperty(value = "脱逃等级")
    private String ttdj;
    @ApiModelProperty(value = "自杀分数")
    private BigDecimal zsfs;
    @ApiModelProperty(value = "自杀等级")
    private String zsdj;
    @ApiModelProperty(value = "js暴力")
    private BigDecimal jsbl;
    @ApiModelProperty(value = "js脱逃")
    private BigDecimal jstt;
    @ApiModelProperty(value = "js自杀")
    private BigDecimal jszs;
    @ApiModelProperty(value = "创建人")
    private String createName;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    private String updateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh == null ? null : fh.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
    }

    public Date getPrisonTime() {
        return prisonTime;
    }

    public void setPrisonTime(Date prisonTime) {
        this.prisonTime = prisonTime;
    }

    public Integer getFshrg() {
        return fshrg;
    }

    public void setFshrg(Integer fshrg) {
        this.fshrg = fshrg;
    }

    public String getFshrgjb() {
        return fshrgjb;
    }

    public void setFshrgjb(String fshrgjb) {
        this.fshrgjb = fshrgjb == null ? null : fshrgjb.trim();
    }

    public Integer getPzxrg() {
        return pzxrg;
    }

    public void setPzxrg(Integer pzxrg) {
        this.pzxrg = pzxrg;
    }

    public String getPzxrgjb() {
        return pzxrgjb;
    }

    public void setPzxrgjb(String pzxrgjb) {
        this.pzxrgjb = pzxrgjb == null ? null : pzxrgjb.trim();
    }

    public Integer getCdxrg() {
        return cdxrg;
    }

    public void setCdxrg(Integer cdxrg) {
        this.cdxrg = cdxrg;
    }

    public String getCdxrgjb() {
        return cdxrgjb;
    }

    public void setCdxrgjb(String cdxrgjb) {
        this.cdxrgjb = cdxrgjb == null ? null : cdxrgjb.trim();
    }

    public Integer getByxrg() {
        return byxrg;
    }

    public void setByxrg(Integer byxrg) {
        this.byxrg = byxrg;
    }

    public String getByxrgjb() {
        return byxrgjb;
    }

    public void setByxrgjb(String byxrgjb) {
        this.byxrgjb = byxrgjb == null ? null : byxrgjb.trim();
    }

    public Integer getYy() {
        return yy;
    }

    public void setYy(Integer yy) {
        this.yy = yy;
    }

    public String getYyjb() {
        return yyjb;
    }

    public void setYyjb(String yyjb) {
        this.yyjb = yyjb == null ? null : yyjb.trim();
    }

    public Integer getZk() {
        return zk;
    }

    public void setZk(Integer zk) {
        this.zk = zk;
    }

    public String getZkjb() {
        return zkjb;
    }

    public void setZkjb(String zkjb) {
        this.zkjb = zkjb == null ? null : zkjb.trim();
    }

    public Integer getSjz() {
        return sjz;
    }

    public void setSjz(Integer sjz) {
        this.sjz = sjz;
    }

    public String getSjzjb() {
        return sjzjb;
    }

    public void setSjzjb(String sjzjb) {
        this.sjzjb = sjzjb == null ? null : sjzjb.trim();
    }

    public Integer getJsbx() {
        return jsbx;
    }

    public void setJsbx(Integer jsbx) {
        this.jsbx = jsbx;
    }

    public String getJsbxjb() {
        return jsbxjb;
    }

    public void setJsbxjb(String jsbxjb) {
        this.jsbxjb = jsbxjb == null ? null : jsbxjb.trim();
    }

    public Integer getShlb() {
        return shlb;
    }

    public void setShlb(Integer shlb) {
        this.shlb = shlb;
    }

    public String getShlbjb() {
        return shlbjb;
    }

    public void setShlbjb(String shlbjb) {
        this.shlbjb = shlbjb == null ? null : shlbjb.trim();
    }

    public Date getPgrq() {
        return pgrq;
    }

    public void setPgrq(Date pgrq) {
        this.pgrq = pgrq;
    }

    public Integer getPghs() {
        return pghs;
    }

    public void setPghs(Integer pghs) {
        this.pghs = pghs;
    }

    public String getJybh() {
        return jybh;
    }

    public void setJybh(String jybh) {
        this.jybh = jybh == null ? null : jybh.trim();
    }

    public String getJymc() {
        return jymc;
    }

    public void setJymc(String jymc) {
        this.jymc = jymc == null ? null : jymc.trim();
    }

    public String getJqbh() {
        return jqbh;
    }

    public void setJqbh(String jqbh) {
        this.jqbh = jqbh == null ? null : jqbh.trim();
    }

    public String getJqmc() {
        return jqmc;
    }

    public void setJqmc(String jqmc) {
        this.jqmc = jqmc == null ? null : jqmc.trim();
    }

    public String getFjqbh() {
        return fjqbh;
    }

    public void setFjqbh(String fjqbh) {
        this.fjqbh = fjqbh == null ? null : fjqbh.trim();
    }

    public String getFjqmc() {
        return fjqmc;
    }

    public void setFjqmc(String fjqmc) {
        this.fjqmc = fjqmc == null ? null : fjqmc.trim();
    }

    public Integer getJsbxHj() {
        return jsbxHj;
    }

    public void setJsbxHj(Integer jsbxHj) {
        this.jsbxHj = jsbxHj;
    }

    public Integer getJsbxWx() {
        return jsbxWx;
    }

    public void setJsbxWx(Integer jsbxWx) {
        this.jsbxWx = jsbxWx;
    }

    public Integer getJsbxQxza() {
        return jsbxQxza;
    }

    public void setJsbxQxza(Integer jsbxQxza) {
        this.jsbxQxza = jsbxQxza;
    }

    public Integer getJsbxRzza() {
        return jsbxRzza;
    }

    public void setJsbxRzza(Integer jsbxRzza) {
        this.jsbxRzza = jsbxRzza;
    }

    public Integer getJsbxJzzhz() {
        return jsbxJzzhz;
    }

    public void setJsbxJzzhz(Integer jsbxJzzhz) {
        this.jsbxJzzhz = jsbxJzzhz;
    }

    public BigDecimal getBlfs() {
        return blfs;
    }

    public void setBlfs(BigDecimal blfs) {
        this.blfs = blfs;
    }

    public String getBldj() {
        return bldj;
    }

    public void setBldj(String bldj) {
        this.bldj = bldj == null ? null : bldj.trim();
    }

    public BigDecimal getTtfs() {
        return ttfs;
    }

    public void setTtfs(BigDecimal ttfs) {
        this.ttfs = ttfs;
    }

    public String getTtdj() {
        return ttdj;
    }

    public void setTtdj(String ttdj) {
        this.ttdj = ttdj == null ? null : ttdj.trim();
    }

    public BigDecimal getZsfs() {
        return zsfs;
    }

    public void setZsfs(BigDecimal zsfs) {
        this.zsfs = zsfs;
    }

    public String getZsdj() {
        return zsdj;
    }

    public void setZsdj(String zsdj) {
        this.zsdj = zsdj == null ? null : zsdj.trim();
    }

    public BigDecimal getJsbl() {
        return jsbl;
    }

    public void setJsbl(BigDecimal jsbl) {
        this.jsbl = jsbl;
    }

    public BigDecimal getJstt() {
        return jstt;
    }

    public void setJstt(BigDecimal jstt) {
        this.jstt = jstt;
    }

    public BigDecimal getJszs() {
        return jszs;
    }

    public void setJszs(BigDecimal jszs) {
        this.jszs = jszs;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }
}
