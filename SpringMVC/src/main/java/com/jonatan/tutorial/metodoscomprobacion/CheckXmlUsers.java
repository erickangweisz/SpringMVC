package com.jonatan.tutorial.metodoscomprobacion;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jonatan.tutorial.model.User;

public class CheckXmlUsers {

	public static ArrayList<User> loadUsersIntoList(Element rootEl) {
		
		ArrayList<User> listUsersTemp = new ArrayList<User>();
		NodeList nList = rootEl.getElementsByTagName("USER");
		
		for (int i=0; i<nList.getLength(); i++) {
			Node n = nList.item(i);
			if (!n.getNodeName().equals("#text")) {
				User uTemp = new User();
				NodeList nList2 = n.getChildNodes();
				for (int j=0; j<nList2.getLength(); j++) {
					Node n2 = nList2.item(j);
					if (n2.getNodeName().equalsIgnoreCase("NAME")) {
						if (n2.getFirstChild() != null) {
							uTemp.setName(n2.getFirstChild().getNodeValue());
						}
					} else if (n2.getNodeName().equalsIgnoreCase("PASSWORD")) {
						uTemp.setPassword(n2.getFirstChild().getNodeValue());
					} else if (n2.getNodeName().equalsIgnoreCase("TYPE")) {
						uTemp.setType(n2.getFirstChild().getNodeValue());
					}
				}
				listUsersTemp.add(uTemp);
			}
		}
		return listUsersTemp;
	}
	
}
