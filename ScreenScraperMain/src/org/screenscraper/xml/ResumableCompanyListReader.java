package org.screenscraper.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.screenscraper.objects.CompanyUrl;
import org.screenscraper.xml.XmlCompanies.XmlCompany;

public class ResumableCompanyListReader {

	private static final String XmlFileName = "config.xml";
	private JAXBContext jaxbContext = null;
	private Unmarshaller unmarshaller = null;

	public List<CompanyUrl> Read() {

		List<CompanyUrl> companies = new ArrayList<CompanyUrl>();

		//
		try {
			jaxbContext = JAXBContext.newInstance("com.jaxb.workout");
			unmarshaller = jaxbContext.createUnmarshaller();

			FileInputStream fis;

			fis = new FileInputStream(XmlFileName);
			Object obj = unmarshaller.unmarshal(fis);
			XmlCompanies xmlCompanies = (XmlCompanies) obj;

			for (XmlCompany xmlCompany : xmlCompanies.getXmlCompany()) {

				CompanyUrl c = new CompanyUrl();
				c.setUrl(xmlCompany.getUrl());
				c.setName(xmlCompany.getName());
				companies.add(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return companies;
	}
}