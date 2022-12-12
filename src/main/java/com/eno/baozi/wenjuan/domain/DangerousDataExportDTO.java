package com.eno.baozi.wenjuan.domain;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.util.Date;

@ColumnWidth(20)
public class DangerousDataExportDTO {
    @ExcelProperty(value="序号", index = 0)
    private int order;

    @ExcelProperty(value="罪犯编号", index = 1)
    private String no;

    @ExcelProperty(value="罪犯姓名", index = 2)
    private String name;

    @ExcelProperty(value="反社会人格", index = 3)
    private String fshrg;

    @ExcelProperty(value="偏执性人格", index = 4)
    private String pzxrg;

    @ExcelProperty(value="冲动性人格", index = 5)
    private String cdxrg;

    @ExcelProperty(value="边缘性人格", index = 6)
    private String byxrg;

    @ExcelProperty(value="抑郁", index = 7)
    private String yy;

    @ExcelProperty(value="躁狂", index = 8)
    private String zk;

    @ExcelProperty(value="神经质", index = 9)
    private String sjz;

    @ExcelProperty(value="精神病性", index = 10)
    private String sjbx;

    @ExcelProperty(value="说谎量", index = 11)
    private String shl;

    @ExcelProperty(value="精神病性-幻觉", index = 12)
    private String jsbxhj;

    @ExcelProperty(value="精神病性-妄想", index = 13)
    private String jsbxwx;

    @ExcelProperty(value="精神病性-情绪障碍", index = 14)
    private String jxbxqxza;

    @ExcelProperty(value="精神病性-认知障碍", index = 15)
    private String jsbxrzza;

    @ExcelProperty(value="精神病性-紧张综合症", index = 16)
    private String jsbxjzzhz;


    @ExcelProperty(value="评估日期", index = 17)
    private String pgrq;

    @ExcelProperty(value="评估耗时(秒）", index = 18)
    private int pghs;


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFshrg() {
        return fshrg;
    }

    public void setFshrg(String fshrg) {
        this.fshrg = fshrg;
    }

    public String getPzxrg() {
        return pzxrg;
    }

    public void setPzxrg(String pzxrg) {
        this.pzxrg = pzxrg;
    }

    public String getCdxrg() {
        return cdxrg;
    }

    public void setCdxrg(String cdxrg) {
        this.cdxrg = cdxrg;
    }

    public String getByxrg() {
        return byxrg;
    }

    public void setByxrg(String byxrg) {
        this.byxrg = byxrg;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public String getSjz() {
        return sjz;
    }

    public void setSjz(String sjz) {
        this.sjz = sjz;
    }

    public String getSjbx() {
        return sjbx;
    }

    public void setSjbx(String sjbx) {
        this.sjbx = sjbx;
    }

    public String getShl() {
        return shl;
    }

    public void setShl(String shl) {
        this.shl = shl;
    }

    public String getJsbxwx() {
        return jsbxwx;
    }

    public void setJsbxwx(String jsbxwx) {
        this.jsbxwx = jsbxwx;
    }

    public String getJxbxqxza() {
        return jxbxqxza;
    }

    public void setJxbxqxza(String jxbxqxza) {
        this.jxbxqxza = jxbxqxza;
    }

    public String getJsbxhj() {
        return jsbxhj;
    }

    public void setJsbxhj(String jsbxhj) {
        this.jsbxhj = jsbxhj;
    }

    public String getJsbxrzza() {
        return jsbxrzza;
    }

    public void setJsbxrzza(String jsbxrzza) {
        this.jsbxrzza = jsbxrzza;
    }

    public String getJsbxjzzhz() {
        return jsbxjzzhz;
    }

    public void setJsbxjzzhz(String jsbxjzzhz) {
        this.jsbxjzzhz = jsbxjzzhz;
    }

    public String getPgrq() {
        return pgrq;
    }

    public void setPgrq(String pgrq) {
        this.pgrq = pgrq;
    }

    public int getPghs() {
        return pghs;
    }

    public void setPghs(int pghs) {
        this.pghs = pghs;
    }
}
