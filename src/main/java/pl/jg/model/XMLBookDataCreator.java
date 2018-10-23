//TODO: use reflections to make more generic XML creator

package pl.jg.model;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.*;

public class XMLBookDataCreator {
	public String createXML(List <Book> bookList) {
		
	        Document document = DocumentHelper.createDocument();
	        Element root = document.addElement("books");
	        
	        System.out.println(bookList.size());
	        
	        for (Book book : bookList) {	     
	        	Element bookElement = root.addElement("book")
                .addAttribute("id", String.valueOf(book.getId()));

	        	bookElement.addElement("author")
                	.addText(String.valueOf(book.getAuthor()));	        

	        	bookElement.addElement("title")
	            	.addText(String.valueOf(book.getTitle()));
	        	
	        	bookElement.addElement("publication_year")
            		.addText(String.valueOf(book.getPublicationYear()));
	        	
	        	bookElement.addElement("description")
            		.addText(String.valueOf(book.getDescription()));	 
	        }
	        
	        return document.asXML();
	}
}
