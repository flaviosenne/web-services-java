package com.template.itext.resource;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Index {
    
    @GetMapping
    public void index(){
        Document documentPDF = new Document();

        try{
            PdfWriter.getInstance(documentPDF, new FileOutputStream("C:\\Users\\user\\Desktop\\template-html-with-java\\src\\main\\resources\\templates\\example.pdf"));

            documentPDF.open();
            documentPDF.setPageSize(PageSize.A4);

            documentPDF.add(new Paragraph("Gerando PDF com a biblioteca itext do java "));
            
            documentPDF.newPage();
            documentPDF.add(new Paragraph("Segunda Pagina"));

            Image image = Image.getInstance("C:\\Users\\user\\Desktop\\template-html-with-java\\src\\main\\resources\\static\\img\\a.png");

            image.scaleToFit(400, 200);

            documentPDF.add(image);

        }catch(DocumentException documentException){
            documentException.printStackTrace();

        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally{
            documentPDF.close();
        }
    }
}
