package com.example.hlemisc.app13082017.Dummy;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyContent {

    public static ArrayList<DummyItem> ITEMS = new ArrayList<>();
    public static HashMap<String, DummyItem> ITEM_MAP = new HashMap<>();

    private static void addItem(DummyItem dummyItem) {
        ITEMS.add(dummyItem);
        ITEM_MAP.put(dummyItem.id, dummyItem);
    }

    static {
        addItem(new DummyItem("Card 1", "ISIC", "MEANING 1"));
        addItem(new DummyItem("Card 2", "PLATOBNA KARTA", "MEANING 2"));
        addItem(new DummyItem("Card 3", "ISIC 2", "MEANING 3"));
    }

    public static class DummyItem {
        public String id, content, meaning;

        public DummyItem (String id, String content, String meaning) {
            this.id = id;
            this.content = content;
            this.meaning = meaning;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
