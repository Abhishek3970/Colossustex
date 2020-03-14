package com.example.colossustex.SG.interface_firebase;

import com.example.colossustex.SG.model.ItemGroup;

import java.util.List;

public interface FirebaseLoadListener {

    void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList);
    void onFirebaseLoadFailed(String message);
}
