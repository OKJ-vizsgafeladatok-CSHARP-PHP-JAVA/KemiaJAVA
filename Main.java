package kemia_gyak;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


public class Main {
	public static List<Elem> beolvas() {
		List<Elem> lista = new ArrayList<Elem>();
		try {
			List<String> sorok = Files.readAllLines(Paths.get("felfedezesek.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				Elem i = new Elem(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4]);
				lista.add(i);
			}
		} catch (Exception e) {
			System.out.println("Hiba a fájl beolvasásakor. ");
		}
		return lista;
	}

	static public Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		List<Elem> a=beolvas();
		
		System.out.println("3. feladat: Felfedezések száma: "+a.size());
		int szamlalo=0;
		for (Elem e : a) {
			if(e.getEv().equals("Ókor")) {
			 szamlalo++;
			}
		}
		System.out.println("4. feladat: Felfedezések száma az ókorban: "+szamlalo);
		String beker;
		do {
			System.out.print("5. feladat: Kérek egy vegyjelet: ");
			beker=sc.nextLine();
		} while (!java.util.regex.Pattern.matches("[a-z]+", beker.toLowerCase())||beker.length()>=3 || beker.length()<1);
		
		//6. feladat
		System.out.println("6. feladat: Keresés");
		for (Elem e : a) {
			if(e.getVegyjel().toUpperCase().equals(beker.toUpperCase())) {
				System.out.println("\tAz elem vegyjele: "+e.getVegyjel());
				System.out.println("\tAz elem neve: "+e.getElem());
				System.out.println("\tRendszáma: "+e.getRendszam());
				System.out.println("\tFelfedezés éve: "+e.getEv());
				System.out.println("\tFelfedező: "+e.getFelfedezo());
			}
		}

		//7. feladat: 
		int szam=Integer.MIN_VALUE;
		int elozo=0;
		int elso=0;
		for (Elem e : a) {
			if(!e.getEv().contains("Ókor")) {
				if(elso==0) {
					elso++;
					elozo=Integer.parseInt((e.getEv()));
				}else {
				if(Integer.parseInt(e.getEv())-elozo>szam) {
					szam=Integer.parseInt((e.getEv()))-elozo;
					System.out.println(szam);
				}
					elozo=Integer.parseInt((e.getEv()));
				}
			}
		}
		System.out.println("7. feladat: "+szam+" év volt a leghosszabb időszak két elem felfedezése között. ");
		//8.feladat: 
		System.out.println("8.feladat: Statisztika");
		HashMap<String,Integer>stat=new HashMap<String,Integer>();
		for (Elem e : a) {
			stat.merge(e.getEv(), 1, Integer::sum);
		}
		for (Entry<String,Integer> elem : stat.entrySet()) {
			if(elem.getValue()>3&&!elem.getKey().equals("Ókor")) {
				System.out.println("\t"+elem.getKey()+": "+elem.getValue());
			}
		}
		
	}//end of main
}
