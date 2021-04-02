package JieZhong.entity;

import java.io.Serializable;

public class SysMenu implements Serializable {


    private int  id;
    private String menu_name;               /**菜单名称*/
    private int parent_id;                  /**父级ID*/
    private int  order_num;                 /** 排序顺序*/
    private String url;                     /**接口地址*/
    private String target;                  /**打开方式（menuItem页签 menuBlank新窗口）*/
    private String menu_type;               /**菜单类型（M目录 C菜单 F按钮）*/
    private String visible;                 /**菜单状态（0显示 1隐藏）*/
    private String perms;                   /** 权限标识*/
    private String  icon ;                  /**菜单图标*/
    private String create_time ;            /**创建时间*/
    private String update_time ;            /**更新时间*/
    private String  create_by ;             /**创建人*/
    private String  update_by ;             /**更新人*/
    private String  remark;                 /**备注*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
