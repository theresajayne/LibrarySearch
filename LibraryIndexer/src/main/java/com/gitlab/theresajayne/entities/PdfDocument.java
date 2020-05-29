package com.gitlab.theresajayne.entities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfDocument extends AbstractDocument
{
    @Override
    public void loadFile(String filename)
    {
        try
        {
            PDDocument document = PDDocument.load(new File(filename));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            content = text.split("\n");
            title = document.getDocumentInformation().getTitle();
            author = document.getDocumentInformation().getAuthor();
            description = document.getDocumentInformation().getSubject();
            keywords = document.getDocumentInformation().getKeywords();
            document.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
