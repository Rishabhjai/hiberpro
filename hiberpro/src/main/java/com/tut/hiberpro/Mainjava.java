package com.tut.hiberpro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mainjava {
	boolean saveData(ItemEntity it, BattersEntity bts,List<ToppingsEntity> tope, List<BatterEntity> bte, History jsonfilehis, History jsonmapped) {
		boolean saveSuccess = false;
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure("com/tut/hiberpro/hibernat.cfg.xml")
					.buildSessionFactory();
//			System.out.println("hello");
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("hh");
			session.save(it);
			session.save(bts);
			session.save(jsonfilehis);
			session.save(jsonmapped);
			for(BatterEntity b : bte) {
				
				session.save(b);
				
			}
			
			for(ToppingsEntity t : tope) {
				session.save(t);
			}
			
			session.getTransaction().commit();
			saveSuccess = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
			// if(tx.isActive()) {tx.commit();}
		}
		return saveSuccess;
	}

	boolean saveHistoryInCaseOfFail(History jsonfilehis) {
		boolean saveSuccess = false;
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure("com/tut/hiberpro/hibernate.cfg.xml")
					.buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(jsonfilehis);
			session.getTransaction().commit();
			saveSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return saveSuccess;
	}

//	private String savedata() {
//		
//		Session s = null ;
//		try{
//			SessionFactory fac = new Configuration().configure("com/tut/hiberpro/hibernate.cfg.xml").buildSessionFactory();
//			 s = fac.openSession();
//			 Transaction tx = s.beginTransaction();
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return s;
//	
//		}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hibernate project started");
		Mainjava mj = new Mainjava();
		try {

//			History configfilehis = new History();
//			configfilehis.setEvent("configuration file located " );
//			configfilehis.setStarttime(System.currentTimeMillis());
//			configfilehis.setSuccess(true);

			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Calling JSON");
			File f = new File(
					"C:\\Users\\ankit\\eclipse-workspace\\hiberpro\\src\\main\\java\\com\\tut\\hiberpro\\assessment_2.json");
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS ");
			History jsonfilehis = new History();
			jsonfilehis.setEvent("Json file found : " + f.getName());
			Path p = f.toPath();
			BasicFileAttributes fatr = Files.readAttributes(p, BasicFileAttributes.class);
			Date d1 = new Date(fatr.creationTime().toMillis());
			jsonfilehis.setStarttime(df.format(d1));
			jsonfilehis.setSuccess("true");
			User user = mapper.readValue(f, User.class);
			History jsonmapped = new History();
			jsonmapped.setEvent("Json Mapped");

			Date d = new Date(System.currentTimeMillis());
			jsonmapped.setStarttime(df.format(d));
			jsonmapped.setSuccess("true");
			// System.out.println("Json file called: " + f.getName());
			// System.out.println("readValue = " +
			// user.getItems().getItem().get(0).batters);
			System.out.println("JSON file Mapped");
			System.out.println("JSON Mapped = " + user);
			ArrayList<Item> items = user.getItems().getItem();
//			Iterator<Item> item = items.iterator();
//			Item item = user.getItems().getItem().get(0);
			for (Item item : items) {
				Batters batters = item.getBatters();
				List<Batter> batter = batters.getBatter();
				List<Toppings> tops = item.getTopping();
				ItemEntity it = new ItemEntity();
				BattersEntity bts = new BattersEntity();
				List<BatterEntity> bte = new ArrayList<BatterEntity>();
				for (Batter bat : batter) {
					BatterEntity b = new BatterEntity();
					b.setId(bat.getId());
					b.setType(bat.getType());
					b.setBatters(bts);
					bte.add(b);
				}
				List<ToppingsEntity> tope = new ArrayList<ToppingsEntity>();
				for (Toppings top : tops) {
					ToppingsEntity t = new ToppingsEntity();
					t.setId(top.getId());
					t.setType(top.getType());
					t.setItem(it);
					tope.add(t);
				}

				bts.setBatter(bte);
				bts.setItem(it);
				// bts.setBatter(bte);

				it.setI_id(item.getId());
				it.setName(item.getName());
				it.setPpu(item.getPpu());
				it.setType(item.getType());
				it.setBatters(bts);
				it.setTopping(tope);

				jsonfilehis.setEndtime(df.format(new Date(f.lastModified())));
				jsonmapped.setEndtime(df.format(new Date(System.currentTimeMillis())));

//				Session s = trans();
				
				mj.saveData(it, bts, tope, bte, jsonfilehis, jsonmapped);
				
//				mj.saveData(it,bts,bte, tope);
//
//				mj.saveData(jsonfilehis);
//
//				mj.saveData(jsonmapped);
//
//				// s.save(configfilehis);
//
////				s.save(jsonfilehis);
////				s.save(jsonmapped);
//
////				s.save(it);
				System.out.println("Hello");
//				// System.out.println("hey");
//				mj.saveData(bts);
//				mj.saveData(it);
//				for (ToppingsEntity t : tope) {
//					mj.saveData(t);
//				}
////				s.save(bts);
//				
//				for (BatterEntity bat : bte) {
//					mj.saveData(bat);
//				}
				
				
			}
			System.out.println("File: " + f.getName() + " stored successfully in Database");
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS ");
			System.out.println(e.getMessage());
//			Session s = fac.openSession();
//			Transaction tx = s.beginTransaction();
			History failhis = new History();
			failhis.setEvent(e.toString());
			Date d = new Date(System.currentTimeMillis());
			failhis.setStarttime(df.format(d));
			failhis.setSuccess("false");
			failhis.setEndtime(df.format(d));
			 mj.saveHistoryInCaseOfFail(failhis);
//			s.save(failhis);
//			tx.commit();
//			s.close();

		}

//		Session s=fac.openSession();
//		Transaction tx= s.beginTransaction();
//		
//		s.save(user.getItems().getItem().get(0));
//		
//		
//		tx.commit();
//		s.close();

	}

}
