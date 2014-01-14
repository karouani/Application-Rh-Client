package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mql.strut.web.UTILS.CreerExcel;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ExcelAction {

	@EJB
	private IAdminRemote admin;
	
	private CreerExcel home;
	
	
	public String execute(){
		System.out.println("debut preparation");
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		
		String[] titres={"Matricule", "Nom", "Prenom","Abreviation","Date embauche","Participe siminaire","Date Participation","Email","Mois BAP","Post Travail","Salaire","Sexe","Business Unite","Site",};
		//admin consulterAllCollaborateurrsManager
		System.out.println("la taille "+admin.consulterAllCollaborateurrsManager().size());
		//Object[] val=new Object[admin.consulterAllCollaborateurrsManager().size()];
		List<Object> ls=new ArrayList<>();
		for (Collaborateurs col:admin.consulterAllCollaborateurrsManager()) {
			Object[] val={col.getMatricule(),col.getNom(),col.getPrenom(),col.getAbreviation(),""+col.getDateembauche(),col.getParticipeseminaire(),""+col.getDateparticipeseminaire(),col.getEmail(),col.getMoisBAP(),col.getPosttravail(),""+col.getSalaireactuel(),col.getSexe(),col.getBu().getDescbu(),col.getSite().getDescsite()};
				//{col.getMatricule(),col.getNom(),col.getPrenom(),col.getAbreviation(),""+col.getDateembauche(),col.getParticipeseminaire(),""+col.getDateparticipeseminaire(),col.getEmail(),col.getMoisBAP(),col.getPosttravail(),""+col.getSalaireactuel(),col.getSexe(),col.getBu().getDescbu(),col.getSite().getDescsite()};
			//ls.toArray()
			data.put(""+col.getCodecol(),val);
		}
		home=new CreerExcel(data, titres, "managers", "manager");
		System.out.println("fin preparation");
		return null;
	}
	

}
