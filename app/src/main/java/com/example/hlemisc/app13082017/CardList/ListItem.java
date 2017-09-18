package com.example.hlemisc.app13082017.CardList;

public class ListItem {
    private int _idImage;
    private String _typeCard;
    private String _ownerCard;

    public ListItem (int idImage, String typeCard, String ownerCard) {
        this._idImage = idImage;
        this._typeCard = typeCard;
        this._ownerCard = ownerCard;
    }

    public int get_idImage() {
        return _idImage;
    }

    public void set_idImage(int _idImage) {
        this._idImage = _idImage;
    }

    public String get_typeCard() {
        return _typeCard;
    }

    public void set_typeCard(String _typeCard) {
        this._typeCard = _typeCard;
    }

    public String get_ownerCard() {
        return _ownerCard;
    }

    public void set_ownerCard(String _ownerCard) {
        this._ownerCard = _ownerCard;
    }

    @Override
    public String toString() {
        return _typeCard + "\n" + _ownerCard;
    }
}
