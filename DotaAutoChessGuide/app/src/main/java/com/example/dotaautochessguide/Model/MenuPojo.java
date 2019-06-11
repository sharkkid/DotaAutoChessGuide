package com.example.dotaautochessguide.Model;

public class MenuPojo {
    private int MenuImage;
    private String MenuTitle;
    private  String MenuSubTitle;

    public MenuPojo() {
        super();
    }

    public MenuPojo(int MenuImage, String MenuTitle, String MenuSubTitle) {
        super();
        this.MenuImage = MenuImage;
        this.MenuTitle = MenuTitle;
        this.MenuSubTitle = MenuSubTitle;
    }


    public void setImage(int MenuImage) {
        this.MenuImage = MenuImage;
    }

    public String getMenuSubTitle() {
        return MenuSubTitle;
    }

    public String getMenuTitle() {
        return MenuTitle;
    }

    public void setMenuTitle(String MenuTitle) {
        this.MenuTitle = MenuTitle;
    }

    public int getImage() {
        return MenuImage;
    }

    public void setMenuSubTitle(String MenuSubTitle) {
        this.MenuSubTitle = MenuSubTitle;
    }
}
