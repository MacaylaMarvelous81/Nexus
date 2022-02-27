package io.github.macaylamarvelous81.nexus1;

public enum CustomItem {

    NONE(-1),
    CUPCAKE(0),
    PORTABLE_CRAFTING_TABLE(1);

    private final int itemid;

    CustomItem(int id) {
        itemid = id;
    }

    public int getItemId() {
        return itemid;
    }

    public static CustomItem toItem(int id) {
        for (CustomItem item : CustomItem.values()) {
            if (item.getItemId() == id) {
                return item;
            }
        }
        return CustomItem.NONE;
    }

}
