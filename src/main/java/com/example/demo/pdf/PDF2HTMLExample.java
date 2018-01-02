package com.example.demo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
/**
 * Created by Nabeel on 11/28/2017.
 */
public class PDF2HTMLExample {

    private static final String PDF = "src/main/resources/pdf/ballistic.pdf";
    private static final String HTML = "src/main/resources/html/ballistic.html";

    public static void main(String[] args){

        try {

            generateHTMLFromPdf(PDF);
            generatePDFFromHTML(HTML);

        }catch (IOException | ParserConfigurationException | DocumentException e){
            e.printStackTrace();
        }
    }


    private static void generateHTMLFromPdf(final String filename) throws ParserConfigurationException, IOException {
        PDDocument pdf = PDDocument.load(new File (filename));
        PDFDomTree parser = new PDFDomTree();
        Writer output = new PrintWriter("src/output/ballistic.html", "utf-8");
        parser.writeText(pdf, output);
        output.close();
        if(pdf != null){
            pdf.close();
        }
    }

    private static void generatePDFFromHTML(final String filename) throws ParserConfigurationException, IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream( "src/output/ballistic.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
        document.close();
    }
}
