package com.iup.tp.twitup.core;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConsulterProfilView;

public class ConsulterProfilController {
	IDatabase db;
	EntityManager em;
	Twitup t;
	
	public ConsulterProfilController(IDatabase db, EntityManager em, Twitup twitup){
		this.db = db;
		this.em = em;
		this.t = twitup;
	}
	
	public User getCurrentUser(){
		return t.getCurrentUser();
	}
	
	public void modifierProfil(ConsulterProfilView v){
		
		User userToModify = new User(
				t.getCurrentUser().getUuid(),
				v.getFieldUsername().getText(), //tag
				v.getFieldPassword().getText(), //pass
				v.getFieldUsername().getText(), //name
				t.getCurrentUser().getFollows(),
				v.getFieldAvatar().getText()
				);
		
		db.modifiyUser(userToModify);
		
		t.setCurrentUser(userToModify);
		
	}
	
	
}
