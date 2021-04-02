package JieZhong.entity;

import java.io.Serializable;

public class SysRoleMenu implements Serializable {

    private int id;
    private int role_id;            /**角色id*/
    private int menu_id;           /** 菜单id*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
