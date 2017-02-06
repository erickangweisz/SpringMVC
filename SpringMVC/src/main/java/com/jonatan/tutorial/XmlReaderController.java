package com.jonatan.tutorial;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class XmlReaderController {
	
	@RequestMapping("/xmlForm")
	public ModelAndView xmlForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xmlForm");
		return mav;
	}

	public boolean isTextNode(Node n) {
		return n.getNodeName().equals("#text");
	}

	public ArrayList<String> readXml(Document doc) {
		ArrayList<String> nListName = new ArrayList<String>();

		doc.normalize();

		Element rootEl = doc.getDocumentElement();
		NodeList nList = rootEl.getChildNodes();

		nListName.add(rootEl.getNodeName());

		for (int i = 0; i < nList.getLength(); i++) {
			Node n = nList.item(i);
			if (!isTextNode(n)) {
				nListName.add("------" + n.getNodeName() + "------");
				NodeList nList2 = n.getChildNodes();
				for (int j = 0; j < nList2.getLength(); j++) {
					Node n2 = nList2.item(j);
					if (!isTextNode(n2)) {
						nListName.add(n2.getNodeName() + ": " + n2.getFirstChild().getNodeValue());
					}
				}
			}
		}

		if (nListName.isEmpty()) {
			nListName.add("No hay elementos en la lista");
		}

		return nListName;
	}

	@RequestMapping(value = "/xmlReader", method = RequestMethod.POST)
	public ModelAndView xmlReader(@RequestParam("xmlFile") MultipartFile xmlFile) {
		ModelAndView mav;
		mav = new ModelAndView("xmlDetails");
		
		String msg = "";
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile.getInputStream());

			ArrayList<String> list = readXml(doc);

			mav.addObject("list", list);
		} catch (ParserConfigurationException e) {
			msg = e.getMessage();
		} catch (SAXException e) {
			msg = e.getMessage();
		} catch (IOException e) {
			msg = e.getMessage();
		}

		mav.addObject("msg", msg);
		return mav;
	}

	@RequestMapping(value= "/xmlReaderWebService", method = RequestMethod.POST)
	public ModelAndView xmlReaderWS(@RequestParam("xmlURL") String url) {
		ModelAndView mav;
		mav = new ModelAndView("xmlDetails");
		String msg = "";
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new URL(url).openStream());

			ArrayList<String> list = readXml(doc);

			mav.addObject("list", list);
		} catch (ParserConfigurationException e) {
			msg = e.getMessage();
		} catch (SAXException e) {
			msg = e.getMessage();
		} catch (IOException e) {
			msg = e.getMessage();
		}

		mav.addObject("msg", msg);
		return mav;
	}

}
