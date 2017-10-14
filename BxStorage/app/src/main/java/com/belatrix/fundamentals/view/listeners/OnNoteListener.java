package com.belatrix.fundamentals.view.listeners;


import com.belatrix.fundamentals.model.entity.NoteEntity;
import com.belatrix.fundamentals.storage.db.CRUDOperations;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     CRUDOperations getCrudOperations();
     void deleteNote(NoteEntity noteEntity);
     void editNote(NoteEntity noteEntity);
}
